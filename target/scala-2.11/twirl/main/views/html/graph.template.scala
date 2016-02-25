
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object graph_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class graph extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(jsBody: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href=""""),_display_(/*4.47*/routes/*4.53*/.Assets.at("stylesheets/style.css")),format.raw/*4.88*/("""">
<script src=""""),_display_(/*5.15*/routes/*5.21*/.Assets.at("javascripts/jquery-1.12.0.min.js")),format.raw/*5.67*/(""""></script>
<script type="text/javascript" src=""""),_display_(/*6.38*/routes/*6.44*/.Assets.at("javascripts/loader.js")),format.raw/*6.79*/(""""></script>
<script type="text/javascript" src=""""),_display_(/*7.38*/routes/*7.44*/.Assets.at("javascripts/jsapi.js")),format.raw/*7.78*/(""""></script>
<link rel="stylesheet" href=""""),_display_(/*8.31*/routes/*8.37*/.Assets.at("stylesheets/bootstrap.min.css")),format.raw/*8.80*/("""">
<script src=""""),_display_(/*9.15*/routes/*9.21*/.Assets.at("javascripts/bootstrap.min.js")),format.raw/*9.63*/(""""></script>
<script type="text/javascript">
    var data2 = """),_display_(/*11.18*/Html(jsBody)),format.raw/*11.30*/("""
"""),format.raw/*12.1*/("""</script>
<script type="text/javascript" src=""""),_display_(/*13.38*/routes/*13.44*/.Assets.at("javascripts/graph_script.js")),format.raw/*13.85*/(""""></script>
<html>
    <head>
        <title>TEST</title>
    </head>
    <body>

        <div id="elemdiv" style="width:100%;height: 380px;">
        </div>
	   	<div id = "chart_div">
        </div>
        <br>
        <p>Slowest pages</p>


    <table id="table_slow_value" class="table table-condensed">
    <thead>
      <tr>
        <th>URL</th>
        <th>Status</th>
        <th>Latency (in ms)</th>
      </tr>
    </thead>
        <tbody>

        </tbody>
        </table>

        <p>All pages</p>
        <table id="table_all_value" class="table table-condensed">
        <thead>
          <tr>
            <th>URL</th>
            <th>Status</th>
            <th>Latency (in ms)</th>
          </tr>
        </thead>
        <tbody>

        </tbody>
        </table>
        <br>
    </body>
</html>"""))
      }
    }
  }

  def render(jsBody:String): play.twirl.api.HtmlFormat.Appendable = apply(jsBody)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (jsBody) => apply(jsBody)

  def ref: this.type = this

}


}

/**/
object graph extends graph_Scope0.graph
              /*
                  -- GENERATED --
                  DATE: Wed Feb 24 14:07:56 EET 2016
                  SOURCE: /home/denis/Heroku/site-latency/play-getting-started/app/views/graph.scala.html
                  HASH: c8e3a956922c6daf7c492b321cf6e70ce0027233
                  MATRIX: 527->1|638->17|665->18|776->103|790->109|845->144|888->161|902->167|968->213|1043->262|1057->268|1112->303|1187->352|1201->358|1255->392|1323->434|1337->440|1400->483|1443->500|1457->506|1519->548|1607->609|1640->621|1668->622|1742->669|1757->675|1819->716
                  LINES: 20->1|25->1|26->2|28->4|28->4|28->4|29->5|29->5|29->5|30->6|30->6|30->6|31->7|31->7|31->7|32->8|32->8|32->8|33->9|33->9|33->9|35->11|35->11|36->12|37->13|37->13|37->13
                  -- GENERATED --
              */
          