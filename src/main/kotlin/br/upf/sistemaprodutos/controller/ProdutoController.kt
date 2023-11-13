package br.upf.sistemaprodutos.controller

import br.upf.sistemaprodutos.dtos.ProdutoDTO
import br.upf.sistemaprodutos.dtos.ProdutoRequestDTO
import br.upf.sistemaprodutos.dtos.ProdutoResponseDTO
import br.upf.sistemaprodutos.service.ProdutoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/produtos")
class ProdutoController (val service: ProdutoService) {

    @GetMapping
    fun listar(): List<ProdutoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ProdutoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastra(@RequestBody @Valid dto: ProdutoDTO,
                 uriBuilder: UriComponentsBuilder
    ) : ResponseEntity<ProdutoResponseDTO> {
        val produtoResponse = service.cadastra(dto)
        val uri = uriBuilder.path("/produtos/${produtoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(produtoResponse)
    }

    @PutMapping("/{id}")
    fun atualiza(@PathVariable id: Long,
                  @RequestBody @Valid dto: ProdutoDTO
    ) : ProdutoResponseDTO {
        return service.atualiza(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deleta(id)
    }
}


