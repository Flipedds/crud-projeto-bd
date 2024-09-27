package com.flipedds.crud_projeto.commands

import com.flipedds.crud_projeto.services.ContatoService
import org.springframework.shell.command.annotation.Command

@Command(group = "Customer Commands")
class ContatoCommands(private val contatoService: ContatoService) {
    @Command(command= ["criar-contato"],
        description="Criar um novo contato")
    public fun criarContato() = contatoService.criarContato()

    @Command(command= ["listar-contatos"],
        description="Listar contatos")
    public fun listarContatos() = contatoService.listarTodosContatos()

    @Command(command= ["buscar-contato"],
        description="Buscar contato por id")
    public fun buscarContatoPorId() = contatoService.buscarContatoPorId()

    @Command(command= ["atualizar-contato"],
        description="Atualizar contato")
    public fun atualizarContato() = contatoService.atualizarContato()

    @Command(command= ["deletar-contato"],
        description="Deletar contato")
    public fun deletarContato() = contatoService.deletarContato()
}