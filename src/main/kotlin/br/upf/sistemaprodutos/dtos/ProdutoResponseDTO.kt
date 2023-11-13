package br.upf.sistemaprodutos.dtos

import java.time.LocalDateTime

data class ProdutoResponseDTO(
    val id: Long?,
    val nome: String,
    val descricao: String,
    val preco: Double,
    val quantidadeEstoque: Int,
    val categoria: String,
    val dataFabricacao: LocalDateTime,
    val dataValidade: LocalDateTime
)
