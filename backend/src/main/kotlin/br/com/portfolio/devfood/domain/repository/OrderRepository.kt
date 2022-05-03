package br.com.portfolio.devfood.domain.repository

import br.com.portfolio.devfood.domain.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface OrderRepository: JpaRepository<Order, Long> {
    fun findByCode(code: String): Optional<Order>
}