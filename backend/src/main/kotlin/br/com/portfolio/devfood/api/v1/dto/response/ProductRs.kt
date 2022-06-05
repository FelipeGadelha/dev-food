package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.Product
import java.math.BigDecimal

class ProductRs private constructor(
    val id: Long,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val imageLink: String,
    val active: Boolean
) {
    constructor(product: Product):
        this(
            id = product.id,
            name = product.name,
            description = product.description,
            price = product.price,
            imageLink = product.imageLink,
            active = product.active
        )
}
