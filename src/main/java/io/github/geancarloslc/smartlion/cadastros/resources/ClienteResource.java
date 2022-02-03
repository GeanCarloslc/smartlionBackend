package io.github.geancarloslc.smartlion.cadastros.resources;


import io.github.geancarloslc.smartlion.cadastros.DAO.ClienteDAO;
import io.github.geancarloslc.smartlion.cadastros.entities.Cliente;
import io.github.geancarloslc.smartlion.cadastros.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClienteResource {

    private final ClienteDAO clienteDAO;

//    @GetMapping("/populaClientes")
//    public ResponseEntity<List<Cliente>> getAllClientes () {
//        try {
//            List<Cliente> clientes = clienteController.findAllClientes();
//            return new ResponseEntity<>(clientes, HttpStatus.OK);
//        }catch (UserNotFoundException e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/pesquisaFiltrosClientes")
    public ResponseEntity<List<Cliente>> pesquisaFiltrosClientes(@RequestBody Cliente clienteFiltro) {
        try {
            List<Cliente> clientes = clienteDAO.filtroClientes(clienteFiltro);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        }catch (UserNotFoundException e){
            return null;
        }
    }

    @PostMapping("/salvarCliente")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
            try {
                Cliente newCliente = clienteDAO.addCliente(cliente);
                return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
            }catch (UserNotFoundException e){
                return null;
            }
    }

    @DeleteMapping("/excluirCliente/{id}")
    public ResponseEntity<?> excluirCliente(@PathVariable("id") Integer id) {
        try{
            clienteDAO.excluirCliente(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (UserNotFoundException e){
            return null;
        }
    }
}
