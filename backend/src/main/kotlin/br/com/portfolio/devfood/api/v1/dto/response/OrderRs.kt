package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.Order
import br.com.portfolio.devfood.domain.model.OrderItem
import br.com.portfolio.devfood.domain.model.OrderStatus
import java.math.BigDecimal
import java.util.*

class OrderRs private constructor(
    val id: Long,
    val code: String,
    val totalValue: BigDecimal,
    val client: UserRs,
    val orderStatus: SortedSet<OrderStatus>,
    val addressDelivery: AddressRs,
    val ordersItens: List<OrderItem>,
) {
    constructor(order: Order):
            this(
                id = order.id,
                code = order.code,
                totalValue = order.totalValue,
                client = UserRs(order.client),
                orderStatus = order.orderStatus,
                addressDelivery = AddressRs(order.addressDelivery),
                ordersItens = order.ordersItens
            )
}
