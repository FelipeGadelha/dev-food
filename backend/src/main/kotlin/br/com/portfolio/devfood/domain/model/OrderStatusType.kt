package br.com.portfolio.devfood.domain.model

enum class OrderStatusType(val description: String) {
    CREATED("Criado"),
    CONFIRMED("Confirmado"),
    DELIVERED("Entregue"),
    CANCELED("Cancelado");
}