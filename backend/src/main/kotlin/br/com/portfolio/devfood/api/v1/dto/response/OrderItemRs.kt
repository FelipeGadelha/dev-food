package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.OrderItem
import br.com.portfolio.devfood.domain.model.Product
import java.math.BigDecimal

class OrderItemRs private constructor(
    val id: Long,
    val product: Product,
    val quantity: Int,
    val unitPrice: BigDecimal,
    val totalPrice: BigDecimal,
    val observation: String,
    val orderId: Long
) {
    constructor(orderItem: OrderItem):
        this(
            id = orderItem.id,
            product = orderItem.product,
            quantity = orderItem.quantity,
            unitPrice = orderItem.unitPrice,
            totalPrice = orderItem.totalPrice,
            observation = orderItem.observation,
            orderId = orderItem.order.id
        )
}