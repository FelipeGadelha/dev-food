package br.com.portfolio.devfood

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
//@EnableCustomRepositories
class DevFoodApplication

fun main(args: Array<String>) {
	runApplication<DevFoodApplication>(*args)
}
