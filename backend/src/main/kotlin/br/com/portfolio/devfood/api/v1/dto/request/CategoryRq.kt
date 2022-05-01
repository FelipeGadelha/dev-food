package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.Category

class CategoryRq(
    private val parentCategoryId: Long?,
    private val name: String
) {
    fun toEntity() =
        Category(
            name = name,
            parentCategory = parentCategoryId?.let { Category(it) }
        )

}
