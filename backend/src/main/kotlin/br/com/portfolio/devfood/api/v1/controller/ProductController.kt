package br.com.portfolio.devfood.api.v1.controller

import br.com.portfolio.devfood.api.v1.dto.request.ProductRq
import br.com.portfolio.devfood.api.v1.dto.response.ProductRs
import br.com.portfolio.devfood.domain.service.ProductService
import br.com.portfolio.devfood.infra.integration.ImgBBClient
import org.apache.tomcat.util.codec.binary.Base64
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val productService: ProductService,
    private val imgBBClient: ImgBBClient
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<ProductRs>> = ResponseEntity
        .ok(productService.findAll().map { p -> ProductRs(p) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ProductRs> = ResponseEntity
        .ok(ProductRs(productService.findById(id)))

    @PostMapping
    @Transactional
    fun save(productRq: ProductRq): ResponseEntity<ProductRs> {
        var product = productRq.toEntity()
        val image = Base64.encodeBase64(productRq.image.bytes)
        val result = String(image)
        println(result)
        val response = imgBBClient.uploader(result)
//        send(productRq.image)
        product = product.copy(
            imageLink = response.data.url,
            deleteImageLink = response.data.delete_url
        )
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