package controllers

import play.api.libs.ws.WS
import play.api.mvc._
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import play.api.libs.concurrent.Execution.Implicits.defaultContext

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  case class DataSet(url:String,status:Int,start:Long,end:Long)


  def measure (input: List[DataSet]):Future[List[DataSet]] = {
    import play.api.libs.ws.ning._
    val startTime = System.currentTimeMillis()
    val futureArray:Future[List[DataSet]] = scala.concurrent.Future {
      input.map {
        case elem => {
          val start = System.currentTimeMillis()
          implicit val sslClient = NingWSClient()
          val futClient = Await.result(WS.clientUrl(elem.url).withRequestTimeout(5000).get(),Duration.Inf)
          DataSet(elem.url,futClient.status, start - startTime,start - startTime + (System.currentTimeMillis() - start))
        }
      }
    }
    futureArray
  }

  def client_send(url:String) = Action.async {
    import play.api.libs.ws.ning._
    import play.api.libs.ws._
    import scala.util.matching.Regex
    implicit val sslClient = NingWSClient()
    val pattern = new Regex("(http|https)://(([a-zA-Z0-9_-]+)(\\.)*(\\/)*)+")
    val allHtml = WS.clientUrl(url).withRequestTimeout(5000).get().map{
      elem => pattern.findAllMatchIn(elem.body).map {
        all =>
          DataSet(all.group(0),0,0L,0L)
      }.toList
    }

    import play.api.libs.json._
    import play.api.libs.functional.syntax._

    implicit val locationWrites: Writes[DataSet] = (
      (JsPath \ "url").write[String] and
        (JsPath \ "status").write[Int] and
        (JsPath \ "start").write[Long] and
        (JsPath \ "end").write[Long]
      )(unlift(DataSet.unapply))

    val answer:Future[List[DataSet]] = allHtml.flatMap(measure)
    answer.map{i =>
      println(Json.toJson(i).toString());
      Ok(views.html.graph(Json.toJson(i).toString()))
    }
  }
}
