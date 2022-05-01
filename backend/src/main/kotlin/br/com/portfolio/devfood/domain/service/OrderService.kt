package br.com.portfolio.devfood.domain.service

import br.com.portfolio.devfood.domain.exception.EntityInUseException
import br.com.portfolio.devfood.domain.exception.EntityNotFoundException
import br.com.portfolio.devfood.domain.model.Order
import br.com.portfolio.devfood.domain.repository.OrderRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {
    companion object {
        private const val MSG_ORDER_NOT_FOUND = "Pedido com o ID %d não existe"
        private const val MSG_ORDER_IN_USE = "Pedido com o ID %d não pode ser removido, pois esta em uso"
    }

    @Transactional
    fun findAll(): List<Order> = orderRepository.findAll()

    @Transactional
    fun findById(id: Long): Order = orderRepository.findById(id)
        .orElseThrow { EntityNotFoundException(String.format(MSG_ORDER_NOT_FOUND, id)) }

//    @Transactional
//    fun save(order: Order): Order {
//        val category = categoryService.findById(product.category.id)
//        return orderRepository.save(product.copy(category = category))
//    }
//    @Transactional
//    fun update(id: Long, update: Order): Order {
//        val product = this.findById(id).update(update)
//        return this.save(product)
//    }

    @Transactional
    fun deleteById(id: Long) {
        try {
            orderRepository.run { deleteById(id); flush() }
        } catch (e: EmptyResultDataAccessException) {
            throw EntityNotFoundException(String.format(MSG_ORDER_NOT_FOUND, id))
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException(String.format(MSG_ORDER_IN_USE, id))
        }
    }
}