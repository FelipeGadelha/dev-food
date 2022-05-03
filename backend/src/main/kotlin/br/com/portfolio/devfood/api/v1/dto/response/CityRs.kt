package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.City

class CityRs private constructor(
    val id: Long,
    val name: String,
    val state: StateRs
) {
    constructor(city: City):
            this(
            id = city.id,
            name = city.name,
            state = StateRs(city.state)
        )
}
