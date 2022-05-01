package br.com.portfolio.devfood.domain.repository

import br.com.portfolio.devfood.domain.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository<Order, Long> {
}