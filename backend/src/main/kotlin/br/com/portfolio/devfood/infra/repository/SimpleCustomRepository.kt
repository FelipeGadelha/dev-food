//package br.com.portfolio.devfood.infra.repository
//
//import arrow.core.Either
//import br.com.portfolio.devfood.domain.repository.CustomJpaRepository
//import org.springframework.data.jpa.repository.support.JpaEntityInformation
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository
//import javax.persistence.EntityManager
//
//class SimpleCustomRepository<T, ID>(
//    private val entityInformation: JpaEntityInformation<T, *>,
//    private val manager: EntityManager
//) : SimpleJpaRepository<T, ID>(entityInformation, manager),
//    CustomJpaRepository<T, ID> {
//    override fun findById(id: Long): Either<Unit, T> {
//        TODO("Not yet implemented")
//    }
//
//}
