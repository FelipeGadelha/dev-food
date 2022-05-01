//package br.com.portfolio.devfood.api.v1.controller
//
//import br.com.portfolio.devfood.api.v1.dto.request.OrderRq
//import br.com.portfolio.devfood.api.v1.dto.request.ProductRq
//import br.com.portfolio.devfood.api.v1.dto.response.OrderRs
//import br.com.portfolio.devfood.api.v1.dto.response.ProductRs
//import br.com.portfolio.devfood.domain.model.Product
//import br.com.portfolio.devfood.domain.repository.ProductRepository
//import br.com.portfolio.devfood.domain.service.OrderService
//import br.com.portfolio.devfood.domain.service.ProductService
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.*
//
//@RestController
//@RequestMapping("/v1/orders")
//class OrderController(
//    private val orderService: OrderService
//) {
//
//    @GetMapping
//    fun findAll(): ResponseEntity<List<OrderRs>> = ResponseEntity
//        .ok(orderService.findAll().map { o -> OrderRs(o) })
//
//    @GetMapping("/{id}")
//    fun findById(@PathVariable id: Long): ResponseEntity<OrderRs> = ResponseEntity
//        .ok(OrderRs(orderService.findById(id)))
//
//    @PostMapping
//    fun save(@RequestBody orderRq: OrderRq): ResponseEntity<OrderRs> {
//        val order = orderRq.toEntity()
//        return ResponseEntity(
//            OrderRs(orderService.save(order)),
//            HttpStatus.CREATED
//        )
//    }
//
//    @PutMapping("/{id}")
//    fun update(@PathVariable id: Long, @RequestBody orderRq: OrderRq): ResponseEntity<OrderRs> {
//        val order = orderRq.toEntity()
//        return ResponseEntity.ok(OrderRs(orderService.update(id, order)))
//    }
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deleteById(@PathVariable id: Long) { orderService.deleteById(id) }
//}