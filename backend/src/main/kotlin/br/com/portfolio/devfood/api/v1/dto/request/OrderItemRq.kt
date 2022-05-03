package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.OrderItem
import br.com.portfolio.devfood.domain.model.Product

class OrderItemRq(
    private val quantity: Int,
    val orderId: Long,
    val productId: Long,

    ) {
    fun toEntity() =
        OrderItem(
            quantity = quantity,
            product = Product(id = productId)
        )

}
