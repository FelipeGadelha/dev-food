package br.com.portfolio.devfood.domain.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderStatusService(
    private val orderService: OrderService
) {
    @Transactional fun findAll(code: String) = orderService.findByCode(code).orderStatus
    @Transactional fun confirmation(code: String) = orderService.findByCode(code).confirm()
    @Transactional fun delivered(code: String) = orderService.findByCode(code).deliver()
    @Transactional fun cancellation(code: String) = orderService.findByCode(code).cancel()
    @Transactional fun lastStatus(code: String) = orderService.findByCode(code).currentStatus()
}