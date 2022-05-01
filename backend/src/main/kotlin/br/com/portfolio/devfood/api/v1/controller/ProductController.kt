package br.com.portfolio.devfood.api.v1.controller

import br.com.portfolio.devfood.api.v1.dto.request.ProductRq
import br.com.portfolio.devfood.api.v1.dto.response.ProductRs
import br.com.portfolio.devfood.domain.model.Product
import br.com.portfolio.devfood.domain.repository.ProductRepository
import br.com.portfolio.devfood.domain.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<ProductRs>> = ResponseEntity
        .ok(productService.findAll().map { p -> ProductRs(p) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ProductRs> = ResponseEntity
        .ok(ProductRs(productService.findById(id)))

    @PostMapping
    fun save(@RequestBody productRq: ProductRq): ResponseEntity<ProductRs> {
        val product = productRq.toEntity()
        return ResponseEntity(
            ProductRs(productService.save(product)),
            HttpStatus.CREATED
        )
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody productRq: ProductRq): ResponseEntity<ProductRs> {
        val product = productRq.toEntity()
        return ResponseEntity.ok(ProductRs(productService.update(id, product)))
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) { productService.deleteById(id) }
}