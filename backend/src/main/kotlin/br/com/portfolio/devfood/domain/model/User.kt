package br.com.portfolio.devfood.domain.model

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,
//    val firstName: String,
//    val LastName: String,
    val username: String = "",
    val email: String = "",
    val password: String = "",
    @OneToMany(mappedBy = "client")
    val orders: List<Order> = ArrayList(),
) {
    fun update(update: User): User {
        return User(
            id = this.id,
            username = update.username,
            email = update.email,
            password = this.password,
            orders = this.orders
        )
    }

}