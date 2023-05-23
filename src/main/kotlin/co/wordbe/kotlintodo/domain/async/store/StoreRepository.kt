package co.wordbe.kotlintodo.domain.async.store

import co.wordbe.kotlintodo.domain.async.product.Product
import io.smallrye.mutiny.Multi
import org.springframework.stereotype.Repository


interface StoreAsyncRepository {
    fun findByProductsAsMulti(products: List<Product>): Multi<Store>
}

@Repository
class StoreAsyncRepositoryImpl: StoreAsyncRepository {
    override fun findByProductsAsMulti(products: List<Product>): Multi<Store> {
        return Multi.createFrom()
            .item(Store(id = 1L, name = "가게"))
    }
}