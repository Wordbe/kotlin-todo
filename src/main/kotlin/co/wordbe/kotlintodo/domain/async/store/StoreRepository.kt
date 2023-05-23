package co.wordbe.kotlintodo.domain.async.store

import co.wordbe.kotlintodo.domain.async.product.Product
import io.smallrye.mutiny.Multi
import org.springframework.stereotype.Repository


@Repository
interface StoreAsyncRepository {
    fun findByProductsAsMulti(products: List<Product>): Multi<Store>
}