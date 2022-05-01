package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.Product
import java.math.BigDecimal

class ProductRq(
    private val name: String,
    private val description: String,
    private val price: BigDecimal,
) {
    fun toEntity() =
        Product(
            name = name,
            description = description,
            price = price
        )
}
