package io.github.geancarloslc.smartlion.cadastros.repositorys;

import io.github.geancarloslc.smartlion.cadastros.entities.Caixa;
import io.github.geancarloslc.smartlion.cadastros.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaixaRepository extends JpaRepository<Caixa, String> {
    void deleteCaixaById(String id);

}
