package br.com.portfolio.devfood.api.v1.dto.request

import br.com.portfolio.devfood.domain.model.Address
import br.com.portfolio.devfood.domain.model.City

class AddressRq(
    val cep: String,
    val place: String,
    val number: String,
    val complement: String?,
    val district: String,
    val cityId: Long
) {
    fun toEntity() =
        Address(
            cep = cep,
            place = place,
            number = number,
            complement = complement,
            district = district,
            city = City(id = cityId)
        )

}
