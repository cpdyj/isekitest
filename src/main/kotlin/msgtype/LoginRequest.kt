package msgtype

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class LoginRequest @JsonCreator constructor(
    @JsonProperty("username")
    val username: String,
    @JsonProperty("password")
    val password: String,
    @JsonProperty("twoFactorAuth")
    val twoFactorAuth: String = "",
    @JsonProperty("expireTime")
    val expireTime: Date? = null
)

