package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.State

class StateRs private constructor(
    val id: Long,
    val name: String
) {
    constructor(state: State):
            this(
            id = state.id,
            name = state.name
        )

}
