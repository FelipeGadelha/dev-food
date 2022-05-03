package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.User

class UserUpdateRq(
    private val name: String,
    private val email: String,
) {
    fun toEntity() = User(
        name = name,
        email = email,
    )
}


