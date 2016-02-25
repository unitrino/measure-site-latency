
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/denis/Heroku/site-latency/play-getting-started/conf/routes
// @DATE:Wed Feb 24 11:45:57 EET 2016


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
