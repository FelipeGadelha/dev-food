package br.com.portfolio.devfood.api.v1.controller

import br.com.portfolio.devfood.api.v1.dto.request.CategoryRq
import br.com.portfolio.devfood.api.v1.dto.response.CategoryRs
import br.com.portfolio.devfood.domain.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
@RequestMapping("/v1/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<CategoryRs>> = ResponseEntity
        .ok(categoryService.findAll().map { c -> CategoryRs(c) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CategoryRs> = ResponseEntity
        .ok(CategoryRs(categoryService.findById(id)))

    @PostMapping
    fun save(@RequestBody categoryRq: CategoryRq): ResponseEntity<CategoryRs> {
        val category = categoryRq.toEntity()
        return ResponseEntity(
            CategoryRs(categoryService.save(category)),
            HttpStatus.CREATED
        )
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody categoryRq: CategoryRq): ResponseEntity<CategoryRs> {
        val category = categoryRq.toEntity()
        return ResponseEntity.ok(CategoryRs(categoryService.update(id, category)))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) { categoryService.deleteById(id) }
}