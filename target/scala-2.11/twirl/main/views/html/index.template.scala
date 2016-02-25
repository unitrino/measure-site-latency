
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href=""""),_display_(/*3.47*/routes/*3.53*/.Assets.at("stylesheets/style.css")),format.raw/*3.88*/("""">
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src=""""),_display_(/*5.38*/routes/*5.44*/.Assets.at("javascripts/script.js")),format.raw/*5.79*/(""""></script>
<html>
    <head>
        <title>Site for measure latency</title>
    </head>
    <body>
	    <div id = "container">
            <div id = "url_form">
                Put web site in field and push "Send"
                <form action = "/check">
                <input type = "text" name = "site_url">
                <input type = "submit" value = "Send">
	   	        </form>
	        </div>

            <div id = "main_info">
                This is test web site for measure sub html`s in page, which you entered.<br>
                <br>
                Coming soon:
                <ul>
                <li>checking for valid html!!</li>
                <li>change speedl!!</li>
                </ul>
            </div>
	    </div>
    </body>
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Wed Feb 24 18:37:06 EET 2016
                  SOURCE: /home/denis/Heroku/site-latency/play-getting-started/app/views/index.scala.html
                  HASH: 254359a0a7e8abd82031b906d0a27ef7da0eee9a
                  MATRIX: 609->0|720->85|734->91|789->126|923->234|937->240|992->275
                  LINES: 25->1|27->3|27->3|27->3|29->5|29->5|29->5
                  -- GENERATED --
              */
          