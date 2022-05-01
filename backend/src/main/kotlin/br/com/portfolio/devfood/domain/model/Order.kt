package br.com.portfolio.devfood.domain.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.SortedSet
import java.util.TreeSet
import javax.persistence.*

@Entity
@Table(name = "orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,
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

}