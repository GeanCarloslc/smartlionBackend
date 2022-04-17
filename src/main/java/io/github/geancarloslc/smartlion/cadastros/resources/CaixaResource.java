package io.github.geancarloslc.smartlion.cadastros.resources;



import io.github.geancarloslc.smartlion.cadastros.DAO.CaixaDAO;
import io.github.geancarloslc.smartlion.cadastros.DAO.ProdutoDAO;
import io.github.geancarloslc.smartlion.cadastros.entities.CaixaItens;
import io.github.geancarloslc.smartlion.cadastros.entities.Categoria;
import io.github.geancarloslc.smartlion.cadastros.entities.Produto;
import io.github.geancarloslc.smartlion.cadastros.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caixa")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CaixaResource {

    private final CaixaDAO caixaDAO;

    @PostMapping("/finalizaPedidoCaixa")
    public ResponseEntity<CaixaItens> finalizaPedidoCaixa(@RequestBody List<CaixaItens> listaItensCaixa ) {
            try {
                 CaixaItens caixaItens = caixaDAO.finalizaPedidoCaixa(listaItensCaixa);
                 return new ResponseEntity<>(caixaItens, HttpStatus.CREATED);
            }catch (UserNotFoundException e){
                return null;
            }
    }


}
