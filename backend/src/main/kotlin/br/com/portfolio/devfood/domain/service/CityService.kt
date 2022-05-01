package br.com.portfolio.devfood.domain.service

import br.com.portfolio.devfood.domain.exception.EntityInUseException
import br.com.portfolio.devfood.domain.exception.EntityNotFoundException
import br.com.portfolio.devfood.domain.model.Category
import br.com.portfolio.devfood.domain.model.City
import br.com.portfolio.devfood.domain.repository.CategoryRepository
import br.com.portfolio.devfood.domain.repository.CityRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CityService(
    private val cityRepository: CityRepository,
    private val stateService: StateService
) {
    companion object {
        private const val MSG_CITY_NOT_FOUND = "Cidade com o ID %d não existe"
        private const val MSG_CITY_IN_USE = "Cidade com o ID %d não pode ser removida, pois esta em uso"
    }

    @Transactional
    fun findAll(): List<City> = cityRepository.findAll()

    @Transactional
    fun findById(id: Long): City = cityRepository.findById(id)
        .orElseThrow { EntityNotFoundException("Cidade de id $id não existe") }

    @Transactional
    fun save(city: City): City {
        val state = stateService.findById(city.id)
        return cityRepository.save(city.copy(state = state))
    }
    @Transactional
    fun update(id: Long, update: City): City {
        val city = this.findById(id).update(update)
        return this.save(city)
    }

    @Transactional
    fun deleteById(id: Long) {
        try {
            cityRepository.run { deleteById(id); flush() }
        } catch (e: EmptyResultDataAccessException) {
            throw EntityNotFoundException(String.format(MSG_CITY_NOT_FOUND, id))
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException(String.format(MSG_CITY_IN_USE, id))
        }
    }
}