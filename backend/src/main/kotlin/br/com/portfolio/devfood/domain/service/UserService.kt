package br.com.portfolio.devfood.domain.service

import br.com.portfolio.devfood.domain.exception.EntityInUseException
import br.com.portfolio.devfood.domain.exception.EntityNotFoundException
import br.com.portfolio.devfood.domain.model.Product
import br.com.portfolio.devfood.domain.model.User
import br.com.portfolio.devfood.domain.repository.UserRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    companion object {
        private const val MSG_USER_NOT_FOUND = "Usuário com o ID %d não existe"
        private const val MSG_USER_IN_USE = "Usuário com o ID %d não pode ser removido, pois esta em uso"
    }

    @Transactional
    fun findAll(): List<User> = userRepository.findAll()

    @Transactional
    fun findById(id: Long): User = userRepository.findById(id)
        .orElseThrow { EntityNotFoundException(String.format(MSG_USER_NOT_FOUND, id)) }
    @Transactional
    fun save(user: User): User = userRepository.save(user)
    @Transactional
    fun update(id: Long, update: User): User {
        val user = this.findById(id).update(update)
        return this.save(user)
    }

    @Transactional
    fun deleteById(id: Long) {
        try {
            userRepository.run { deleteById(id); flush() }
        } catch (e: EmptyResultDataAccessException) {
            throw EntityNotFoundException(String.format(MSG_USER_NOT_FOUND, id))
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException(String.format(MSG_USER_IN_USE, id))
        }
    }
}
