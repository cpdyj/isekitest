package service

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import java.util.*

class UserService:AbstractVerticle() {
    override fun start(startFuture: Future<Void>?) {
        super.start(startFuture)

    }
}


data class LoginRequest @JsonCreator constructor(
    @JsonProperty("username")
    val username: String,
    @JsonProperty("password")
    val password: String,
    @JsonProperty("twoFactorAuth")
    val twoFactorAuth:String="",
    @JsonProperty("expireTime")
    val expireTime:Date?=null
)

fun login(loginRequest: LoginRequest):String{
    TODO()
}