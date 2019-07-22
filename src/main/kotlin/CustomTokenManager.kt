import gemalto.TokenManager
import gemalto.fakeOtp

class CustomTokenManager: TokenManager() {
    override fun getOtp() = fakeOtp()
}