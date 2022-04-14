package io.github.geancarloslc.smartlion.cadastros.repositorys;

import io.github.geancarloslc.smartlion.cadastros.entities.CaixaItens;
import io.github.geancarloslc.smartlion.cadastros.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaixaItensRepository extends JpaRepository<CaixaItens, String> {
    void deleteCaixaItensById(String id);

}
