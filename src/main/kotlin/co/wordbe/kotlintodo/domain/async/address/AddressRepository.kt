package co.wordbe.kotlintodo.domain.async.address

import co.wordbe.kotlintodo.domain.async.user.User
import org.springframework.stereotype.Repository
import java.util.concurrent.Flow


interface AddressAsyncRepository {
    fun findByUserAsPublisher(user: User): Flow.Publisher<Address>
}

@Repository
class AddressAsyncRepositoryImpl: AddressAsyncRepository {
    override fun findByUserAsPublisher(user: User): Flow.Publisher<Address> {
        return Flow.Publisher {  }
    }
}