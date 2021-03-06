package controllers

import play.api.libs.ws.{WS, WSResponse}
import play.api.mvc._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.ws.ning.NingWSClient

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  case class DataSet(url:String,status:Int,start:Long,end:Long)
  implicit val sslClient = NingWSClient()

  def measure (input: List[DataSet]):Future[List[DataSet]] = {
    val startTime = System.currentTimeMillis()
    val futureArray:List[Future[DataSet]] = {
      input.map {
        case elem => {
          val start = System.currentTimeMillis()
          val futClient: Future[WSResponse] = WS.clientUrl(elem.url).withRequestTimeout(35000).get()
          futClient.map{
            reqq => {
              println(elem.url,reqq.status, start - startTime,start - startTime + (System.currentTimeMillis() - start))
              DataSet(elem.url,reqq.status, start - startTime,start - startTime + (System.currentTimeMillis() - start))
            }
          }
        }
      }
    }
    Future.sequence(futureArray)
  }

  def client_send(url:String) = Action.async {
    import play.api.libs.ws.ning._
    import play.api.libs.ws._
    import scala.util.matching.Regex
    implicit val sslClient = NingWSClient()

    val pattern = new Regex("(http)://(([a-zA-Z0-9_-]+)(\\.)*(\\/)*)+")

    val allHtml: Future[List[DataSet]] = WS.clientUrl(url).withRequestTimeout(45000).get().map{
      elem => pattern.findAllMatchIn(elem.body).filter(elem => elem.group(0) != "http://www").map {
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

    val answer: Future[List[DataSet]] = allHtml.flatMap(measure)

    answer.map{i =>
      println(Json.toJson(i).toString());
      Ok(views.html.graph(Json.toJson(i).toString()))
    }
  }
}
