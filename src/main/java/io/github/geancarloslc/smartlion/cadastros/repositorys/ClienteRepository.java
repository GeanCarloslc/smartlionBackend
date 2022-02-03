package io.github.geancarloslc.smartlion.cadastros.repositorys;

import io.github.geancarloslc.smartlion.cadastros.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    void deleteClienteById(Integer id);

}
