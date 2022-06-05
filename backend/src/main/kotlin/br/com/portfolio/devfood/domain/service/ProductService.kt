package br.com.portfolio.devfood.domain.service

import br.com.portfolio.devfood.domain.component.UploadImgBB
import br.com.portfolio.devfood.domain.exception.EntityInUseException
import br.com.portfolio.devfood.domain.exception.EntityNotFoundException
import br.com.portfolio.devfood.domain.model.Product
import br.com.portfolio.devfood.domain.repository.ProductRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryService: CategoryService
) {
    companion object {
        private const val MSG_PRODUCT_NOT_FOUND = "Produto com o ID %d não existe"
        private const val MSG_PRODUCT_IN_USE = "Produto com o ID %d não pode ser removido, pois esta em uso"
    }

    @Transactional
    fun findAll(): List<Product> = productRepository.findAll()

    @Transactional
    fun findById(id: Long): Product = productRepository.findById(id)
        .orElseThrow { EntityNotFoundException(String.format(MSG_PRODUCT_NOT_FOUND, id)) }

    @Transactional
    fun save(product: Product): Product {
        val category = categoryService.findById(product.category.id)
        return productRepository.save(product.copy(category = category))
    }
    @Transactional
    fun update(id: Long, update: Product): Product {
        val product = this.findById(id).update(update)
        return this.save(product)
    }

    @Transactional
    fun deleteById(id: Long) {
        try {
            productRepository.run { deleteById(id); flush() }
        } catch (e: EmptyResultDataAccessException) {
            throw EntityNotFoundException(String.format(MSG_PRODUCT_NOT_FOUND, id))
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException(String.format(MSG_PRODUCT_IN_USE, id))
        }
    }
}