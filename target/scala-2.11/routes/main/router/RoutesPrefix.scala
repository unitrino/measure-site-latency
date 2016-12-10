
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/denis/Heroku/site-latency/site-latency/conf/routes
// @DATE:Sun Nov 20 12:32:37 EET 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
