package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.City
import br.com.portfolio.devfood.domain.model.State

class CityRq(
    private val name: String,
    private val stateId: Long
) {
    fun toEntity() = City(
        name = name,
        state = State(id = stateId)
    )
}
