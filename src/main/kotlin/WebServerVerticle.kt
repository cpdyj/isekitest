import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.http.HttpServer
import io.vertx.ext.web.Router
import io.vertx.kotlin.core.http.closeAwait
import io.vertx.kotlin.core.http.listenAwait
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class WebServerVerticle : AbstractVerticle() {
    lateinit var server:HttpServer
    lateinit var router:Router


    override fun start(startFuture: Future<Void>?) {
        GlobalScope.launch(vertx.dispatcher()){
            try {
                server = vertx.createHttpServer()
                router = Router.router(vertx)
                initRoute(router)
                server.requestHandler(router)
                    .listenAwait()
                startFuture?.complete()
            }catch (e:Exception){
                startFuture?.fail(e)
            }
        }
    }

    override fun stop(stopFuture: Future<Void>?) {
        GlobalScope.launch (vertx.dispatcher()){
            try {
                server.closeAwait()
                router.clear()
                stopFuture?.complete()
            }catch (e:Exception){
                stopFuture?.fail(e)
            }
        }
    }
}