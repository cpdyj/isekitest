package service

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import msgtype.LoginRequest

class UserService:AbstractVerticle() {
    override fun start(startFuture: Future<Void>?) {
        super.start(startFuture)

    }
}



fun login(loginRequest: LoginRequest):String{
    TODO()
}