package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.Category
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(Include.NON_NULL)
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
