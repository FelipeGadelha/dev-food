package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.User

class UserRs private constructor(
    val id: Long,
    val name: String,
    val email: String

) {
    constructor(user: User):
        this(
            id = user.id,
            name = user.name,
            email = user.email
        )
}
