package br.com.portfolio.devfood.domain.service

import br.com.portfolio.devfood.domain.exception.EntityInUseException
import br.com.portfolio.devfood.domain.exception.EntityNotFoundException
import br.com.portfolio.devfood.domain.model.Category
import br.com.portfolio.devfood.domain.repository.CategoryRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    companion object {
        private const val MSG_CATEGORY_NOT_FOUND = "Categoria com o ID %d não existe"
        private const val MSG_CATEGORY_IN_USE = "Categoria com o ID %d não pode ser removida, pois esta em uso"
    }

    @Transactional
    fun findAll(): List<Category> = categoryRepository.findAll()

    @Transactional
    fun findById(id: Long): Category = categoryRepository.findById(id)
        .orElseThrow { EntityNotFoundException("Categoria de id $id não existe") }

    @Transactional
    fun save(category: Category): Category {
        category.parentCategory?.let { findById(it.id) }
        return categoryRepository.save(category)
    }
    @Transactional
    fun update(id: Long, update: Category): Category {
        val category = this.findById(id).update(update)
        return this.save(category)
    }

    @Transactional
    fun deleteById(id: Long) {
        try {
            categoryRepository.run { deleteById(id); flush() }
        } catch (e: EmptyResultDataAccessException) {
            throw EntityNotFoundException(String.format(MSG_CATEGORY_NOT_FOUND, id))
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException(String.format(MSG_CATEGORY_IN_USE, id))
        }
    }
}