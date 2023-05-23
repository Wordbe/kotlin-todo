package co.wordbe.kotlintodo.domain.async.product

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux


@Repository
interface ProductAsyncRepository {
    fun findByIdsAsFlux(ids: List<Long>): Flux<Product>
}