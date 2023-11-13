package br.upf.sistemaprodutos.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val descricao: String,
    val preco: Double,
    val quantidadeEstoque: Int,
    val categoria: String,
    val dataFabricacao: LocalDateTime,
    val dataValidade: LocalDateTime,
    ) {
}
