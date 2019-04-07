package msgtype

import io.vertx.core.json.JsonObject
import org.junit.Assert
import org.junit.Test
import java.util.*

class LoginRequestTest {
    @Test
    fun test() {
        val source = LoginRequest(
            username = "TEST username",
            password = "test password",
            expireTime = Date()
        )
        val json = JsonObject.mapFrom(source).toString()
        Assert.assertEquals(source, JsonObject(json).mapTo(LoginRequest::class.java))
    }
}