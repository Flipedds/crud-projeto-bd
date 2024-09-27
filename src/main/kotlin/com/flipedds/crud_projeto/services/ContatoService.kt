package com.flipedds.crud_projeto.services

import com.flipedds.crud_projeto.entities.Contato
import com.flipedds.crud_projeto.repositories.ContatoRepository
import org.bson.types.ObjectId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ContatoService(val contatoRepository: ContatoRepository) {
    fun criarContato() {
        val scanner = Scanner(System.`in`)

        println("Digite o nome:")
        val nome = scanner.nextLine()
        println("Digite o sobrenome:")
        val sobrenome = scanner.nextLine()
        println("Digite o telefone:")
        val telefone = scanner.nextLine()
        println("Digite o email:")
        val email = scanner.nextLine()

        val novoContato = Contato(
            nome = nome,
            sobrenome = sobrenome,
            telefone = telefone,
            email = email
        )
        val contatoCriado = contatoRepository.save(novoContato)
        println("Contato criado com sucesso: $contatoCriado")
    }

    fun listarTodosContatos() {
        val contatos = contatoRepository.findAll()
        if (contatos.isEmpty()) {
            println("Nenhum contato encontrado.")
            return
        }
        contatos.forEach { println(it) }
    }

    fun buscarContatoPorId() {
        val scanner = Scanner(System.`in`)

        println("Digite o ID do contato:")
        val id = scanner.nextLine()

        val contato = contatoRepository.findByIdOrNull(id)

        if (contato == null) {
            println("Contato não encontrado.")
            return
        }
        println("Contato encontrado: $contato")
    }

    fun atualizarContato() {
        val scanner = Scanner(System.`in`)

        println("Digite o ID do contato a ser atualizado:")
        val id = scanner.nextLine()

        if (!contatoRepository.existsById(id)) {
            println("Contato não encontrado.")
            return
        }

        println("Digite o novo nome (ou deixe em branco para não alterar):")
        val nome = scanner.nextLine()

        println("Digite o novo sobrenome (ou deixe em branco para não alterar):")
        val sobrenome = scanner.nextLine()

        println("Digite o novo telefone (ou deixe em branco para não alterar):")
        val telefone = scanner.nextLine()

        println("Digite o novo email (ou deixe em branco para não alterar):")
        val email = scanner.nextLine()

        val contatoExistente = contatoRepository.findByIdOrNull(id)!!

        val contatoAtualizado = Contato(
            id = ObjectId(id),
            nome = nome.ifBlank { contatoExistente.nome },
            sobrenome = sobrenome.ifBlank { contatoExistente.sobrenome },
            telefone = telefone.ifBlank { contatoExistente.telefone },
            email = email.ifBlank { contatoExistente.email }
        )

        contatoRepository.save(contatoAtualizado)

        println("Contato atualizado com sucesso: $contatoAtualizado")

    }

    fun deletarContato() {
        val scanner = Scanner(System.`in`)

        println("Digite o ID do contato a ser deletado:")
        val id = scanner.nextLine()

        if (!contatoRepository.existsById(id)) {
            println("Contato não encontrado.")
            return
        }

        contatoRepository.deleteById(id)

        if (contatoRepository.existsById(id)) {
            println("Não foi possível deletar o contato")
            return
        }
        println("Contato deletado com sucesso.")
    }
}