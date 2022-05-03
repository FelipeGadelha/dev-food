package br.com.portfolio.devfood.domain.model

import com.fasterxml.jackson.annotation.JsonBackReference
import java.math.BigDecimal
import java.util.Objects
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class OrderItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,
    val quantity: Int = 0,
    val unitPrice: BigDecimal = BigDecimal.ZERO,
    val totalPrice: BigDecimal = BigDecimal.ZERO,
    val observation: String = "",
    @ManyToOne @JoinColumn(nullable = false) @JsonBackReference	val order: Order = Order(),
    @ManyToOne @JoinColumn(nullable = false) val product: Product = Product()
) {
    fun update(updated: OrderItem) = OrderItem(
        id = if (Objects.isNull(id)) this.id else updated.id,
        quantity = updated.quantity,
        unitPrice = updated.unitPrice,
        totalPrice = updated.totalPrice,
        observation = updated.observation,
        order = updated.order,
        product = updated.product
    )
}
