package br.com.portfolio.devfood.domain.model

import java.util.Objects
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "cities")
data class City(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1,
    val name: String = "",
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "state_id", nullable = false)
    val state: State = State()
) {
    fun update(updated: City) = City(
        id = if (Objects.isNull(id)) this.id else updated.id,
        name = updated.name,
        state = updated.state
    )
}