package co.wordbe.kotlintodo.domain.async.user

import io.reactivex.rxjava3.core.Maybe
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

@Repository
interface UserAsyncRepository {
    fun findUserByIdAsMaybe(id: Long): Maybe<User>
}

open class UserRepositoryBase {
    fun prepareUser(id: Long) = User(
        id = id,
        email = "sample@example.com",
        createdAt = LocalDateTime.now()
    )
}

class UserRxRepository: UserRepositoryBase(), UserAsyncRepository {
    companion object {
        const val TIME_DELAY_MS = 5000L
    }

    override fun findUserByIdAsMaybe(id: Long): Maybe<User> {
        val user = prepareUser(id)
        return Maybe.just(user).delay(TIME_DELAY_MS, TimeUnit.MILLISECONDS)
    }
}