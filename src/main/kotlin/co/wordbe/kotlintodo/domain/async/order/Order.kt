package co.wordbe.kotlintodo.domain.async.order

import co.wordbe.kotlintodo.domain.async.address.Address
import co.wordbe.kotlintodo.domain.async.product.Product
import co.wordbe.kotlintodo.domain.async.store.Store
import co.wordbe.kotlintodo.domain.async.user.User

data class Order(
    val id: Long,
    val buyer: User,
    val products: List<Product>,
    val stores: List<Store>,
    val address: Address,
)