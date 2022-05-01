package br.com.portfolio.devfood.api.v1.controller

import br.com.portfolio.devfood.api.v1.dto.request.CityRq
import br.com.portfolio.devfood.api.v1.dto.request.StateRq
import br.com.portfolio.devfood.api.v1.dto.response.CityRs
import br.com.portfolio.devfood.api.v1.dto.response.StateRs
import br.com.portfolio.devfood.domain.service.CityService
import br.com.portfolio.devfood.domain.service.StateService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/cities")
class CityController(
    private val cityService: CityService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<CityRs>> = ResponseEntity
        .ok(cityService.findAll().map { c -> CityRs(c) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CityRs> = ResponseEntity
        .ok(CityRs(cityService.findById(id)))

    @PostMapping
    fun save(@RequestBody cityRq: CityRq): ResponseEntity<CityRs> {
        val city = cityRq.toEntity()
        return ResponseEntity(
            CityRs(cityService.save(city)),
            HttpStatus.CREATED
        )
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody cityRq: CityRq): ResponseEntity<CityRs> {
        val city = cityRq.toEntity()
        return ResponseEntity.ok(CityRs(cityService.update(id, city)))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) { cityService.deleteById(id) }
}