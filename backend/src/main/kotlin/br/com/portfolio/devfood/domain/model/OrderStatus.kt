package br.com.portfolio.devfood.domain.model

import java.time.OffsetDateTime
import javax.persistence.Embeddable
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Embeddable
class OrderStatus(
    @Enumerated(EnumType.STRING)
    val status: OrderStatusType,
    val moment: OffsetDateTime = OffsetDateTime.now()
) : Comparable<OrderStatus?> {

    override fun compareTo( other: OrderStatus?): Int {
        return status.compareTo(other!!.status)
    }
}