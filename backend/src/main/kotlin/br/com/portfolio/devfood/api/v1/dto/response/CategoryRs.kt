package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.Category

class CategoryRs private constructor(
    val id: Long,
    val name: String,
    val parentCategory: String?
) {
    constructor(category: Category):
            this(
                id = category.id,
                name = category.name,
                parentCategory = category.parentCategory?.name
            )

}
