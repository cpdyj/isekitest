import io.vertx.ext.web.Router
import webhandler.*

suspend fun initRoute(router: Router){
    router.apply {
        get("/version").handler(Version())
    }
}