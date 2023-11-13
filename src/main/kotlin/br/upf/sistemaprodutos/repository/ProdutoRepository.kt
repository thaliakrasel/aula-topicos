package br.upf.sistemaprodutos.repository

import br.upf.sistemaprodutos.model.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import javax.sound.sampled.Port

@Repository
interface ProdutoRepository : JpaRepository<Produto, Long> {

}