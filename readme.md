# Crud Mongo DB - Kotlin - Spring Boot Cli

Desafio: Criar um pequeno aplicativo para cadastrar telefones de contatos

## Estrutura do Documento MongoDB

```java
@Document("contatos") data

class Contato(
        @Id
        val id:ObjectId=ObjectId.get(),
        val nome:String?,
        val sobrenome:String?,
        val telefone:String?,
        val email:String?)
```

## Configurações

/resources/application.yml

    spring:
      application:
        name: crud_projeto
        data:
          mongodb:
           host: localhost
           port: 27017
           database: agenda

## Executando Cli
    gradle 8 +
    java 21

```java
    fun main(args:Array<String>) {
    runApplication<CrudProjetoApplication> (*args)
}
```