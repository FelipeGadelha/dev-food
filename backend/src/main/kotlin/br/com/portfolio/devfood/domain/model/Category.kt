package br.com.portfolio.devfood.domain.model

import javax.persistence.*

@Entity
@Table(name = "categories")
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,
    val name: String = "",
    @ManyToOne @JoinColumn(name= "parent_category_id")
    val parentCategory: Category? = null
) {
    fun update(update: Category): Category {
        return Category(
            id = this.id,
            name = update.name,
            parentCategory = this.parentCategory
        )
    }
}