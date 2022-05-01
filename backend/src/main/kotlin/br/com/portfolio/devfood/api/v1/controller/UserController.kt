package br.com.portfolio.devfood.api.v1.controller

import br.com.portfolio.devfood.api.v1.dto.View
import br.com.portfolio.devfood.api.v1.dto.request.ProductRq
import br.com.portfolio.devfood.api.v1.dto.request.UserRq
import br.com.portfolio.devfood.api.v1.dto.response.ProductRs
import br.com.portfolio.devfood.api.v1.dto.response.UserRs
import br.com.portfolio.devfood.domain.model.Product
import br.com.portfolio.devfood.domain.repository.ProductRepository
import br.com.portfolio.devfood.domain.service.ProductService
import br.com.portfolio.devfood.domain.service.UserService
import com.fasterxml.jackson.annotation.JsonView
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<UserRs>> = ResponseEntity
        .ok(userService.findAll().map { u -> UserRs(u) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<UserRs> = ResponseEntity
        .ok(UserRs(userService.findById(id)))

    @PostMapping
    fun save(@RequestBody userRq: UserRq): ResponseEntity<UserRs> {
        val user = userRq.toEntity()
        return ResponseEntity(
            UserRs(userService.save(user)),
            HttpStatus.CREATED
        )
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody userRq: UserRq): ResponseEntity<UserRs> {
        val user = userRq.toEntity()
        return ResponseEntity.ok(UserRs(userService.update(id, user)))
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) { userService.deleteById(id) }
}