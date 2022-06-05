package br.com.portfolio.devfood.domain.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,
    val name: String = "",
    val description: String = "",
    val price: BigDecimal = BigDecimal.ZERO,
    val active: Boolean = true,
    val imageLink: String = "",
    val deleteImageLink: String = "",
    @ManyToOne @JoinColumn(nullable = false)
    val category: Category = Category()
) {
    fun update(update: Product): Product {
        return Product(
            id = this.id,
            name = update.name,
            description = update.description,
            price = update.price,
            imageLink = update.imageLink,
            deleteImageLink = update.deleteImageLink,
            active = update.active,
            category = this.category
        )
    }
}