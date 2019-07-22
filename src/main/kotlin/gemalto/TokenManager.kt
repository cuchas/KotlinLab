package gemalto

import java.util.*

internal fun generateOtp() =  UUID.randomUUID().toString()

fun fakeOtp() = "123123"

open class TokenManager {
    open fun getOtp() = generateOtp()
}

class MyTokenManager: TokenManager() {
    override fun getOtp() = fakeOtp()
}