package br.com.portfolio.devfood.api.v1.controller

import br.com.portfolio.devfood.api.v1.dto.request.OrderRq
import br.com.portfolio.devfood.api.v1.dto.response.OrderRs
import br.com.portfolio.devfood.domain.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/orders")
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping
    fun findAll(): ResponseEntity<List<OrderRs>> = ResponseEntity
        .ok(orderService.findAll().map { o -> OrderRs(o) })

    @GetMapping("/{code}")
    fun findById(@PathVariable code: String): ResponseEntity<OrderRs> = ResponseEntity
        .ok(OrderRs(orderService.findByCode(code)))

    @PostMapping
    fun save(@RequestBody orderRq: OrderRq): ResponseEntity<OrderRs> {
        val order = orderRq.toEntity()
        return ResponseEntity(
            OrderRs(orderService.save(order)),
            HttpStatus.CREATED
        )
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) { orderService.deleteById(id) }
}