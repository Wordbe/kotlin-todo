package co.wordbe.kotlintodo.domain.async.address

import co.wordbe.kotlintodo.domain.async.user.User
import org.springframework.stereotype.Repository
import java.util.concurrent.Flow


@Repository
interface AddressAsyncRepository {
    fun findByUserAsPublisher(user: User): Flow.Publisher<Address>
}