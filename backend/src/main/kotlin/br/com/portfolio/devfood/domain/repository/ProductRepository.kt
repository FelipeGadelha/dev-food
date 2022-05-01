package br.com.portfolio.devfood.domain.repository

import br.com.portfolio.devfood.domain.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long>