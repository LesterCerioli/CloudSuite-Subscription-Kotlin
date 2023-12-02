package com.ltserp.subscription

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.with
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.MSSQLServerContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)

class TestSubscriptionApplication {

	@Bean
	@ServiceConnection
	fun sqlServerContainer(): MSSQLServerContainer<*> {
		return MSSQLServerContainer(DockerImageName.parse("mcr.microsoft.com/mssql/server:latest"))
	}

}

fun main(args: Array<String>) {
	fromApplication<SubscriptionApplication>().with(TestSubscriptionApplication::class).run(*args)
}
