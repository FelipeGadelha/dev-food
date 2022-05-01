package br.com.portfolio.devfood.domain.model

import java.util.*
import javax.persistence.*
//import javax.validation.constraints.NotBlank

@Entity
@Table(name = "states")
data class State(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1,
    val name: String = ""
) {
    fun update(updated: State) = State(
        id = this.id,
        name = updated.name
    )
}