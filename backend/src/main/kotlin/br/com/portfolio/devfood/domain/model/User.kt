package br.com.portfolio.devfood.domain.model

import org.hibernate.annotations.CreationTimestamp
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,
//    val firstName: String,
//    val LastName: String,
    val name: String = "",
    val email: String = "",
    val password: String = "",
    @OneToMany(mappedBy = "client")
    val orders: List<Order> = ArrayList(),
    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    val creationDate: OffsetDateTime = OffsetDateTime.now()
) {
    fun update(update: User): User {
        return User(
            id = this.id,
            name = update.name,
            email = update.email,
            password = this.password,
            orders = this.orders,
            creationDate = this.creationDate
        )
    }

}