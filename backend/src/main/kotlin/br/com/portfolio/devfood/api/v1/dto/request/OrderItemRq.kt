package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.Order
import br.com.portfolio.devfood.domain.model.OrderItem
import br.com.portfolio.devfood.domain.model.Product
import java.math.BigDecimal

class OrderItemRq(
    private val quantity: Int,
    val unitPrice: BigDecimal,
    val totalPrice: BigDecimal,
    val observation: String,
    val orderId: Long,
    val productId: Long,

    ) {
    fun toEntity() =
        OrderItem(
            quantity = quantity,
            unitPrice = unitPrice,
            totalPrice = totalPrice,
            observation = observation,
            order = Order(id = orderId),
            product = Product(id = productId)
        )

}
