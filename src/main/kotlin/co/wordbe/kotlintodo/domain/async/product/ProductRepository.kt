package co.wordbe.kotlintodo.domain.async.product

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux


interface ProductAsyncRepository {
    fun findByIdsAsFlux(ids: List<Long>): Flux<Product>
}

@Repository
class ProductAsyncRepositoryImpl: ProductAsyncRepository {
    override fun findByIdsAsFlux(ids: List<Long>): Flux<Product> {
        return Flux.just()
    }
}