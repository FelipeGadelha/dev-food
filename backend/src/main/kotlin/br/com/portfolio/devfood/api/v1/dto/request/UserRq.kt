package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.User

class UserRq(
    private val username: String,
    private val email: String,
    private val password: String,
) {
    fun toEntity() = User(
            username = username,
            email = email,
            password = password
        )
}

