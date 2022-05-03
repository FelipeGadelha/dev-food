package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.Order
import br.com.portfolio.devfood.domain.model.User

class OrderRq(
    private val client: Long,
    private val address: AddressRq,
    private val itens: List<OrderItemRq>
) {
    fun toEntity() = Order(
            client = User(client),
            addressDelivery = address.toEntity(),
            ordersItens = itens.map { it.toEntity() }
        )
}
