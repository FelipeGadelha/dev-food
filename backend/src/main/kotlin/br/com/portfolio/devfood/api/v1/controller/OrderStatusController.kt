package br.com.portfolio.devfood.api.v1.controller

import br.com.portfolio.devfood.domain.model.OrderStatus
import br.com.portfolio.devfood.domain.model.OrderStatusType
import br.com.portfolio.devfood.domain.service.OrderStatusService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/orders/{code}/status")
class OrderStatusController(
    private val orderStatusService: OrderStatusService
) {
    @GetMapping
    fun findAll(@PathVariable code: String): ResponseEntity<SortedSet<OrderStatus>> {
        return ResponseEntity.ok(orderStatusService.findAll(code))
    }

    @GetMapping("/last")
    fun lastStatus(@PathVariable code: String): ResponseEntity<OrderStatusType> {
        return ResponseEntity.ok(orderStatusService.lastStatus(code))
    }

    @PutMapping("/confimation")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun confimation(@PathVariable code: String) = orderStatusService.confirmation(code)

    @PutMapping("/delivered")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delivered(@PathVariable code: String) = orderStatusService.delivered(code)

    @PutMapping("/cancellation")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun cancellation(@PathVariable code: String) = orderStatusService.cancellation(code)
}