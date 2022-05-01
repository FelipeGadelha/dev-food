package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.Order
import br.com.portfolio.devfood.domain.model.User

class OrderRs private constructor(id: Long, client: User) {
    constructor(order: Order):
            this(
                id = order.id,
                client = order.client,
//                orderStatus = order.orderStatus,
//                addressDelivery = AddressRs(order.addressDelivery)
            )

}
