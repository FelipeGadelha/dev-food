package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.User

class UserRs private constructor(
    val id: Long,
    val email: String,
    val username: String
) {
    constructor(user: User):
        this(
            id = user.id,
            email = user.email,
            username = user.username,
        )
}
