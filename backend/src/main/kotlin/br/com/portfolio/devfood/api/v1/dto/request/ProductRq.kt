package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.Category
import br.com.portfolio.devfood.domain.model.Product
import org.springframework.web.multipart.MultipartFile
import java.math.BigDecimal

class ProductRq(
    private val name: String,
    private val description: String,
    private val price: BigDecimal,
    val image: MultipartFile,
    private val categoryId: Long
) {
    fun toEntity() =
        Product(
            name = name,
            description = description,
            price = price,
            category = Category(categoryId)
        )
}
