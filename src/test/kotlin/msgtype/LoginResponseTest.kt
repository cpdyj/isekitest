package msgtype

import io.vertx.core.json.JsonObject
import org.junit.Assert
import org.junit.Test

class LoginResponseTest {
    @Test
    fun test() {
        val loginResponse = LoginResponse(
            key = "testValue_____FFFFFFFFF",
            errReason = ErrReason.NEED_2FA
        )
        val json = JsonObject.mapFrom(loginResponse)
        Assert.assertEquals(json.toString(), """{"key":"testValue_____FFFFFFFFF","errReason":"NEED_2FA"}""")
        val two = json.mapTo(LoginResponse::class.java)
        Assert.assertEquals(loginResponse, two)
    }
}