package com.flipedds.crud_projeto

import com.flipedds.crud_projeto.services.ContatoService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import java.util.*
import kotlin.system.exitProcess

@SpringBootApplication
@EnableMongoRepositories
class CrudProjetoApplication(
    private val contatoService: ContatoService
): CommandLineRunner {
    override fun run(vararg args: String?) {
        val scanner = Scanner(System.`in`)

        while (true) {
            println("Selecione uma operação:")
            println("1: Criar contato")
            println("2: Listar contatos")
            println("3: Buscar contato por ID")
            println("4: Atualizar contato")
            println("5: Deletar contato")
            println("6: Sair")

            when (scanner.nextLine()) {
                "1" -> contatoService.criarContato(scanner)
                "2" -> contatoService.listarTodosContatos()
                "3" -> contatoService.buscarContatoPorId(scanner)
                "4" -> contatoService.atualizarContato(scanner)
                "5" -> contatoService.deletarContato(scanner)
                "6" -> exitProcess(0)
                else -> println("Opção inválida.")
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<CrudProjetoApplication>(*args)
}
