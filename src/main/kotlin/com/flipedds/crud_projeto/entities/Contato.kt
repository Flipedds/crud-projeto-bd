package com.flipedds.crud_projeto.entities

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("contatos")
data class Contato(
    @Id
    val id: ObjectId = ObjectId.get(),
    val nome: String?,
    val sobrenome: String?,
    val telefone: String?,
    val email: String?
)
