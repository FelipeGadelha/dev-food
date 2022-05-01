package br.com.portfolio.devfood.api.v1.controller

import br.com.portfolio.devfood.api.v1.dto.request.StateRq
import br.com.portfolio.devfood.api.v1.dto.response.StateRs
import br.com.portfolio.devfood.domain.service.StateService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/states")
class StateController(
    private val stateService: StateService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<StateRs>> = ResponseEntity
        .ok(stateService.findAll().map { s -> StateRs(s) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<StateRs> = ResponseEntity
        .ok(StateRs(stateService.findById(id)))

    @PostMapping
    fun save(@RequestBody stateRq: StateRq): ResponseEntity<StateRs> {
        val state = stateRq.toEntity()
        return ResponseEntity(
            StateRs(stateService.save(state)),
            HttpStatus.CREATED
        )
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody stateRq: StateRq): ResponseEntity<StateRs> {
        val state = stateRq.toEntity()
        return ResponseEntity.ok(StateRs(stateService.update(id, state)))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) { stateService.deleteById(id) }
}