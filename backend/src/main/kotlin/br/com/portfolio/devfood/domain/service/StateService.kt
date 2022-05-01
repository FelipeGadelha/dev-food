package br.com.portfolio.devfood.domain.service

import br.com.portfolio.devfood.domain.exception.EntityInUseException
import br.com.portfolio.devfood.domain.exception.EntityNotFoundException
import br.com.portfolio.devfood.domain.model.Category
import br.com.portfolio.devfood.domain.model.City
import br.com.portfolio.devfood.domain.model.State
import br.com.portfolio.devfood.domain.repository.CategoryRepository
import br.com.portfolio.devfood.domain.repository.CityRepository
import br.com.portfolio.devfood.domain.repository.StateRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StateService(
    private val stateRepository: StateRepository
) {
    companion object {
        private const val MSG_STATE_NOT_FOUND = "Estado com o ID %d não existe"
        private const val MSG_STATE_IN_USE = "Estado com o ID %d não pode ser removido, pois esta em uso"
    }

    @Transactional
    fun findAll(): List<State> = stateRepository.findAll()

    @Transactional
    fun findById(id: Long): State = stateRepository.findById(id)
        .orElseThrow { EntityNotFoundException("Estado de id $id não existe") }

    @Transactional
    fun save(state: State): State = stateRepository.save(state)

    @Transactional
    fun update(id: Long, update: State): State {
        val state = this.findById(id).update(update)
        return this.save(state)
    }

    @Transactional
    fun deleteById(id: Long) {
        try {
            stateRepository.run { deleteById(id); flush() }
        } catch (e: EmptyResultDataAccessException) {
            throw EntityNotFoundException(String.format(MSG_STATE_NOT_FOUND, id))
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException(String.format(MSG_STATE_IN_USE, id))
        }
    }
}