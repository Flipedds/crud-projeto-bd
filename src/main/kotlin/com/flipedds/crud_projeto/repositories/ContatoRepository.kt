package com.flipedds.crud_projeto.repositories

import com.flipedds.crud_projeto.entities.Contato
import org.springframework.data.mongodb.repository.MongoRepository

interface ContatoRepository: MongoRepository<Contato, String> {
}