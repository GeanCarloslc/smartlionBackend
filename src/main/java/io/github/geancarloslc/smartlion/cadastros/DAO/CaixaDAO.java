package io.github.geancarloslc.smartlion.cadastros.DAO;

import io.github.geancarloslc.smartlion.cadastros.entities.Caixa;
import io.github.geancarloslc.smartlion.cadastros.entities.CaixaItens;
import io.github.geancarloslc.smartlion.cadastros.entities.Categoria;
import io.github.geancarloslc.smartlion.cadastros.entities.Produto;
import io.github.geancarloslc.smartlion.cadastros.repositorys.CaixaItensRepository;
import io.github.geancarloslc.smartlion.cadastros.repositorys.CaixaRepository;
import io.github.geancarloslc.smartlion.cadastros.repositorys.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Repository
@RequiredArgsConstructor
public class CaixaDAO {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    private final CaixaRepository caixaRepository;
    private final CaixaItensRepository caixaItensRepository;

	public CaixaItens finalizaPedidoCaixa(List<CaixaItens> listaItensCaixa) {

        Caixa caixa = new Caixa();
        caixa.setDtAtualizacao(new Date());
        Caixa caixaSalvo = caixaRepository.save(caixa);
        CaixaItens caixaItensSalvos = new CaixaItens();
        for (CaixaItens caixaItens : listaItensCaixa) {
            caixaItens.setIdCaixa(caixaSalvo.getId());
            caixaItensSalvos = caixaItensRepository.save(caixaItens);

        }
        return caixaItensSalvos;
    }

}

