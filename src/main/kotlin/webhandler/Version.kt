package webhandler

import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext

class Version : Handler<RoutingContext> {
    override fun handle(event: RoutingContext?) {
        event?.response()?.apply {
            this.putHeader("Content-Type", "text/plain; charset=utf-8")
                .putHeader("Cache-Control", "no-cache")
                .putHeader("Server", "Iseki blog server/0.0.1")
                .end("Iseki's blog. Version:0.0.1")
        }
    }

}