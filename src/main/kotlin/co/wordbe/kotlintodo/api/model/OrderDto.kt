package co.wordbe.kotlintodo.api.model

data class OrderRequest(
    val userId: Long,
    val productIds: List<Long>,
)