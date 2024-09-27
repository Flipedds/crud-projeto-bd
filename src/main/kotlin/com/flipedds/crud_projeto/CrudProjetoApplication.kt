package com.flipedds.crud_projeto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.shell.command.annotation.CommandScan

@SpringBootApplication
@EnableMongoRepositories
@CommandScan
class CrudProjetoApplication

fun main(args: Array<String>) {
    runApplication<CrudProjetoApplication>(*args)
}
