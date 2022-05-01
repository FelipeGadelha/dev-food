package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.State

class StateRq(
    private val name: String
) {
    fun toEntity() = State(
        name = name
    )
}
