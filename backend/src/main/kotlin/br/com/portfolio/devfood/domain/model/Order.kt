package br.com.portfolio.devfood.domain.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import org.springframework.util.Assert
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,

    val code: String = UUID.randomUUID().toString(),

    @ManyToOne @JoinColumn(name = "user_client_id", nullable = false)
    val client: User = User(),

    @Embedded val addressDelivery: Address = Address(),
    @OneToMany(mappedBy = "order")
    @JsonManagedReference
    val ordersItens: List<OrderItem> = ArrayList(),

    @ElementCollection
    @CollectionTable(name = "order_status",
        joinColumns = [JoinColumn(name = "order_status_id")])
    @OrderBy("moment asc")
    val orderStatus: SortedSet<OrderStatus> = TreeSet()
) {
    val totalValue: BigDecimal = ordersItens.stream()
        .map(OrderItem::totalPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add)
    fun addOrderStatus(status: OrderStatusType) = this.orderStatus.add(OrderStatus(status))
    fun confirm() {
        Assert.state(readyForConfirmation(), String.format(
                "Status do pedido %s não pode ser alterado de %s para %s",
                this.code, currentStatus().description, OrderStatusType.CONFIRMED.description
            )
        )
        orderStatus.add(OrderStatus(OrderStatusType.CONFIRMED))
    }

    fun deliver() {
        Assert.state(readyForDeliver(), String.format(
                "Status do pedido %s não pode ser alterado de %s para %s",
                this.code, currentStatus().description, OrderStatusType.DELIVERED.description
            )
        )
        orderStatus.add(OrderStatus(OrderStatusType.DELIVERED))
    }

    fun cancel() {
        Assert.state(readyForCancellation(), String.format(
                "Status do pedido %s não pode ser alterado de %s para %s",
                this.code, currentStatus().description, OrderStatusType.CANCELED.description
            )
        )
        orderStatus.add(OrderStatus(OrderStatusType.CANCELED))
    }

    private fun readyForConfirmation(): Boolean {
        return !orderStatus.stream()
            .anyMatch { s: OrderStatus -> s.status != OrderStatusType.CREATED }
    }

    private fun readyForDeliver(): Boolean {
        return orderStatus.stream()
            .anyMatch { s: OrderStatus ->
                s.status == OrderStatusType.CONFIRMED &&
                        s.status != OrderStatusType.CANCELED
            }
    }

    private fun readyForCancellation(): Boolean {
        return orderStatus.size == 1 &&
                orderStatus.stream().anyMatch { s: OrderStatus -> s.status == OrderStatusType.CREATED }
    }
    fun currentStatus(): OrderStatusType = orderStatus.last().status

}