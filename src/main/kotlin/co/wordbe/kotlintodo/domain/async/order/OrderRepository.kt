package co.wordbe.kotlintodo.domain.async.order

import co.wordbe.kotlintodo.domain.async.address.Address
import co.wordbe.kotlintodo.domain.async.product.Product
import co.wordbe.kotlintodo.domain.async.store.Store
import co.wordbe.kotlintodo.domain.async.user.User
import org.springframework.stereotype.Repository
import java.util.concurrent.CompletableFuture


@Repository
interface OrderAsyncRepository {
    fun createAsFuture(
        buyer: User,
        products: List<Product>,
        stores: List<Store>,
        address: Address,
    ): CompletableFuture<Order>
}