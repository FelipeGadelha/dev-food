package br.com.portfolio.devfood.api.v1.dto.response

import br.com.portfolio.devfood.domain.model.Address

class AddressRs private constructor(
    val place: String,
    val district: String,
    val cep: String,
    val number: String,
    val complement: String?,
    val city: CityRs
) {
    constructor(address: Address):
            this(
            place = address.place,
            district = address.district,
            cep = address.cep,
            number = address.number,
            complement = address.complement,
            city = CityRs(address.city)
        )

}
