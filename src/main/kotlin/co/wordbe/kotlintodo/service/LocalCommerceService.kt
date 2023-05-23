package co.wordbe.kotlintodo.service

import co.wordbe.kotlintodo.api.model.OrderRequest
import co.wordbe.kotlintodo.domain.async.address.AddressAsyncRepository
import co.wordbe.kotlintodo.domain.async.order.Order
import co.wordbe.kotlintodo.domain.async.order.OrderAsyncRepository
import co.wordbe.kotlintodo.domain.async.product.ProductAsyncRepository
import co.wordbe.kotlintodo.domain.async.store.StoreAsyncRepository
import co.wordbe.kotlintodo.domain.async.user.UserAsyncRepository
import io.smallrye.mutiny.Multi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.future.await
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.rx3.awaitSingle
import org.springframework.stereotype.Service
import java.util.concurrent.Flow

@Service
class LocalCommerceService(
    private val userRepository: UserAsyncRepository,
    private val addressRepository: AddressAsyncRepository,
    private val productRepository: ProductAsyncRepository,
    private val storeRepository: StoreAsyncRepository,
    private val orderRepository: OrderAsyncRepository,
) {

    suspend fun order(orderRequest: OrderRequest): Order {
        val (userId, productIds) = orderRequest

        // 1. 구매자 조회
        val buyer = userRepository.findUserByIdAsMaybe(userId).awaitSingle()

        // 2. 주소 조회 및 유효성 체크
        val address = addressRepository.findByUserAsPublisher(buyer).awaitLast()
        checkNotNull(address)

        // 3. 상품 조회
        val products = productRepository.findByIdsAsFlux(productIds).asFlow().toList()
        check(products.isNotEmpty())

        // 4. 가게 조회
        val stores = storeRepository.findByProductsAsMulti(products).asFlow().toList()
        check(stores.isNotEmpty())

        // 5. 주문 생성
        val order = orderRepository.createAsFuture(buyer, products, stores, address).await()

        return order
    }
}

private fun <T> Multi<T>.asFlow(): kotlinx.coroutines.flow.Flow<T> {
    TODO("Not yet implemented")
}

private fun <T> Flow.Publisher<T>.awaitLast(): T {
    TODO("Not yet implemented")
}
