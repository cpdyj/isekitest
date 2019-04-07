import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.json.JsonObject
import io.vertx.redis.RedisOptions


fun main(vararg args: String) {
    println("Hello world!!!")
    val vertx = Vertx.vertx()
    vertx.deployVerticle("WebServerVerticle") {
        if (it.succeeded()) {
            println(it)
        }
    }
}

class GlobalConfig private constructor(
    val httpServerOptions: HttpServerOptions,
    val redisOptions: RedisOptions,
    val postgreSqlConfig: JsonObject
) {
    companion object {
        fun fromJson(json: JsonObject): GlobalConfig =
            GlobalConfig(
                httpServerOptions = HttpServerOptions(json.getJsonObject("httpServerOptions")),
                redisOptions = RedisOptions(json.getJsonObject("redisOptions")),
                postgreSqlConfig = { JsonObject() }()
            )
    }
}