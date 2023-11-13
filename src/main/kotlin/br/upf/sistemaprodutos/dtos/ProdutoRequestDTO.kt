package br.upf.sistemaprodutos.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class ProdutoRequestDTO(
    @field:NotEmpty(message = "Produto sempre deve ter um nome")
    val nome: String,
    val descricao: String,
    @field:NotNull(message = "Produto sempre deve ter um preço")
    val preco: Double,
    @field:NotNull(message = "Deve ter uma quantidade de estoque")
    val quantidadeEstoque: Int,
    val categoria: String,
    @field:NotNull (message = "Deve ter uma data de fabricação do produto")
    val dataFabricacao: LocalDateTime,
    @field:NotNull (message = "Deve ter uma data de validade do produto")
    val dataValidade: LocalDateTime
)
