package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.Order

class OrderRq(
    val client: Long,
    val address: AddressRq,
    val itens: List<OrderItemRq>
) {
//    fun toEntity() =
//        Order(
//            client = client,
//
//
//
//        )

}
