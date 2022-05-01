package br.com.portfolio.devfood.domain.repository

import br.com.portfolio.devfood.domain.model.State
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StateRepository: JpaRepository<State, Long>