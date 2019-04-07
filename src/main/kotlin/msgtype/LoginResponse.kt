package msgtype

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class LoginResponse @JsonCreator constructor(
    @JsonProperty("key")
    val key: String,
    @JsonProperty("errReason")
    val errReason: ErrReason
)

enum class ErrReason {
    NEED_2FA
}