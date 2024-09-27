# Crud Mongo DB - Kotlin - Spring Boot Cli

Desafio: Criar um pequeno aplicativo para cadastrar telefones de contatos

### Estrutura do Documento MongoDB

```java
@Document("contatos") 
data class Contato(
        @Id
        val id:ObjectId=ObjectId.get(),
        val nome:String?,
        val sobrenome:String?,
        val telefone:String?,
        val email:String?)
```

### Funcionalidades

* Criar contato
* Listar contatos
* Buscar contato por ID
* Atualizar contato
* Deletar contato

### Configurações

    /resources/application.yml
    
    Alterar dados do mongo

    data:
      mongodb:
        host: localhost
        port: 27017
        database: agenda

### Requisitos

    gradle 8 + | java 21 | IntelliJ IDE


### Executando Cli

Executar Função Main em CrudProjetoApplication
```java
    fun main(args:Array<String>) {
    runApplication<CrudProjetoApplication> (*args)
}
```

Exemplo de execução:

    shell:>help
    AVAILABLE COMMANDS
    
    Built-In Commands
    help: Display help about available commands
    stacktrace: Display the full stacktrace of the last error.
    clear: Clear the shell screen.
    quit, exit: Exit the shell.
    history: Display or save the history of previously run commands
    version: Show version info
    script: Read and execute commands from a file.
    
    Customer Commands
    buscar-contato: Buscar contato por id
    listar-contatos: Listar contatos
    criar-contato: Criar um novo contato
    deletar-contato: Deletar contato
    atualizar-contato: Atualizar contato
    
    
    
    shell:>listar-contatos
    Contato(id=66f5b9b6ea9f6e2b6ca0d179, nome=Pedo, sobrenome=Miguel, telefone=(82) 94834-3493, email=pedoMiguel@gmail.com)
    Contato(id=66f617ef810bb36b0aeb1c06, nome=Pedro, sobrenome=Jose, telefone=(81) 98483-4834, email=pedroJose@gmail.com)
