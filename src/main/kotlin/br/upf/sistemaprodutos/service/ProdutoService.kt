package br.upf.sistemaprodutos.service

import br.upf.sistemaprodutos.converters.ProdutoConverter
import br.upf.sistemaprodutos.dtos.ProdutoDTO
import br.upf.sistemaprodutos.dtos.ProdutoRequestDTO
import br.upf.sistemaprodutos.dtos.ProdutoResponseDTO
import br.upf.sistemaprodutos.exceptions.NotFoundException
import br.upf.sistemaprodutos.model.Produto
import br.upf.sistemaprodutos.repository.ProdutoRepository
import org.springframework.stereotype.Service

private const val EVENTO_NOT_FOUND_MESSAGE = "Produto não encontrado!"

@Service
class ProdutoService (private val repository: ProdutoRepository,
    private val converter: ProdutoConverter,
    ) {

    fun listar(): List<ProdutoResponseDTO> {
        return repository.findAll()
            .map(converter::toProdutoResponseDTO)
    }

    fun buscarPorId(id: Long): ProdutoResponseDTO {
        val produto = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE)}
        return converter.toProdutoResponseDTO(produto)
    }

    fun cadastra(dto: ProdutoDTO) : ProdutoResponseDTO {
        return converter.toProdutoResponseDTO(
          repository.save(converter.toProduto(dto))
        )
    }

    fun atualiza(id: Long, dto: Produto) : ProdutoResponseDTO {
        val produto = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                descricao = dto.descricao,
                preco = dto.preco,
                quantidadeEstoque = dto.quantidadeEstoque
            )
        return converter.toProdutoResponseDTO(repository.save(produto))
    }

    fun deleta(id: Long) {
        repository.deleteById(id)
    }
}