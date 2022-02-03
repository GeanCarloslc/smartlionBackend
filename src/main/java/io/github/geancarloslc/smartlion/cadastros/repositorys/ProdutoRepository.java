package io.github.geancarloslc.smartlion.cadastros.repositorys;

import io.github.geancarloslc.smartlion.cadastros.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    void deleteProdutoById(String id);

}
