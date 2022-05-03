package br.com.portfolio.devfood.domain.service

import br.com.portfolio.devfood.domain.exception.EntityInUseException
import br.com.portfolio.devfood.domain.exception.EntityNotFoundException
import br.com.portfolio.devfood.domain.model.*
import br.com.portfolio.devfood.domain.repository.OrderRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val userService: UserService,
    private val cityService: CityService,
    private val productService: ProductService
) {
    companion object {
        private const val MSG_ORDER_NOT_FOUND = "Pedido com o ID %d não existe"
        private const val MSG_ORDER_IN_USE = "Pedido com o ID %d não pode ser removido, pois esta em uso"
    }

    @Transactional
    fun findAll(): List<Order> = orderRepository.findAll()

    @Transactional
    fun findByCode(code: String): Order = orderRepository.findByCode(code)
        .orElseThrow { EntityNotFoundException(String.format(MSG_ORDER_NOT_FOUND, code)) }

    @Transactional
    fun save(order: Order): Order {
        val client = userService.findById(order.client.id)
        val city = cityService.findById(order.addressDelivery.city.id)
        val itens: List<OrderItem> = order.ordersItens.map { item ->
            val product = productService.findById(item.product.id)
            return@map item.copy(
                product = product,
                order = order
            )
         }

        val result = Order(
            client = client,
            ordersItens = itens,
            addressDelivery = order.addressDelivery.copy(city = city)
        )
        result.addOrderStatus(OrderStatusType.CREATED)
        return orderRepository.save(result)
    }
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