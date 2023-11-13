package br.upf.sistemaprodutos.converters

import br.upf.sistemaprodutos.dtos.ProdutoDTO
import br.upf.sistemaprodutos.dtos.ProdutoRequestDTO
import br.upf.sistemaprodutos.dtos.ProdutoResponseDTO
import br.upf.sistemaprodutos.model.Produto
import org.springframework.stereotype.Component

@Component
class ProdutoConverter {
    fun toProduto (dto: ProdutoDTO) : Produto = with(dto) {
        return Produto(
            nome = nome,
            descricao = descricao,
            preco = preco,
            quantidadeEstoque = quantidadeEstoque,
            categoria = categoria,
            dataFabricacao = dataFabricacao,
            dataValidade = dataValidade
        )
    }

    fun toProdutoResponseDTO(produto: Produto) : ProdutoResponseDTO = with(produto) {
        return ProdutoResponseDTO(
            id = id,
            nome = nome,
            descricao = descricao,
            preco = preco,
            quantidadeEstoque = quantidadeEstoque,
            categoria = categoria,
            dataFabricacao = dataFabricacao,
            dataValidade = dataValidade
        )
    }

}