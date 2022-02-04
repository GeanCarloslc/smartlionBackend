package io.github.geancarloslc.smartlion.cadastros.resources;



import io.github.geancarloslc.smartlion.cadastros.DAO.ProdutoDAO;
import io.github.geancarloslc.smartlion.cadastros.entities.Categoria;
import io.github.geancarloslc.smartlion.cadastros.entities.Produto;
import io.github.geancarloslc.smartlion.cadastros.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProdutoResource {

    private final ProdutoDAO produtoDAO;

    @GetMapping("/populaCategoria")
    public ResponseEntity<List<Categoria>> populaCategoria () {
        try {
            List<Categoria> categoria = produtoDAO.populaCategoria();
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pesquisaFiltrosProdutos")
    public ResponseEntity<List<Produto>> pesquisaFiltrosProdutos(@RequestBody Produto produtoFiltro) {
        try {
            List<Produto> produtos = produtoDAO.filtroProdutos(produtoFiltro);
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        }catch (UserNotFoundException e){
            return null;
        }
    }

    @PostMapping("/salvarProduto")
    public ResponseEntity<Produto> addProduto(@RequestBody Produto produto) {
            try {
                Produto newProduto = produtoDAO.addProduto(produto);
                return new ResponseEntity<>(newProduto, HttpStatus.CREATED);
            }catch (UserNotFoundException e){
                return null;
            }
    }

    @DeleteMapping("/excluirProduto/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable("id") String id) {
        try{
            produtoDAO.excluirProduto(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (UserNotFoundException e){
            return null;
        }
    }
}
