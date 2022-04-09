package io.github.geancarloslc.smartlion.cadastros.DAO;

import io.github.geancarloslc.smartlion.cadastros.entities.Categoria;
import io.github.geancarloslc.smartlion.cadastros.entities.Produto;
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
public class ProdutoDAO {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    private final ProdutoRepository produtoRepository;

	public Produto addProduto(Produto produto) {

        produto.setDtAtualizacao(new Date());
        return produtoRepository.save(produto);
    }

    public List<Produto> filtroProdutos(Produto produtoFiltro) {

        Integer qtRestritions = 0;
        String sQuerySelect = "from Produto ";
        String sQuery = "";

        if (produtoFiltro.getId() != null && !produtoFiltro.getId().equals("")){
            qtRestritions ++;
            sQuery += "where lower(id) LIKE  lower('" + produtoFiltro.getId().trim() + "%');";
        }

        if (produtoFiltro.getDeProduto() != null && !produtoFiltro.getDeProduto().equals("")){
            qtRestritions ++;
            sQuery += "where lower(deProduto) LIKE  lower('" + produtoFiltro.getDeProduto().trim() + "%');";
        }

        if (produtoFiltro.getDeMarca() != null && !produtoFiltro.getDeMarca().equals("")){
            qtRestritions ++;
            sQuery += "where lower(deMarca) LIKE  lower('" + produtoFiltro.getDeMarca().trim() + "%');";
        }


            sQuery = validaQuery(sQuery, qtRestritions);
            sQuerySelect += sQuery;
            Query query = getSession().createQuery(sQuerySelect);
            List<Produto> lista = query.getResultList();

        return lista;
    }

    public Produto pesquisaProduto(String codigoProduto) {

        Integer qtRestritions = 0;
        String sQuerySelect = "from Produto ";
        String sQuery = "";

        if (codigoProduto != null && !codigoProduto.equals("")){
            qtRestritions ++;
            sQuery += "where lower(id) = '" + codigoProduto.trim() + "'";
        }

        sQuerySelect += sQuery;
        Query query = getSession().createQuery(sQuerySelect);
        List<Produto> resultList = query.getResultList();

        if(resultList != null){
            Produto produto = resultList.get(0);
            return produto;
        } else {
            return null;
        }

    }

    public String validaQuery(String query, Integer qtRestritions){
        if(qtRestritions > 1){
            int qtCharFirstQuery = query.indexOf(";");
            String firstQuery = query.substring(0, qtCharFirstQuery);

            qtCharFirstQuery++;
            StringBuffer queryBuffer = new StringBuffer(query);
            queryBuffer.delete(0, qtCharFirstQuery);
            query = queryBuffer.toString();
            query = query.replace(";", " ");
            query = query.replace("where", " and ");

            return firstQuery + " " + query;
        } else {
            query = query.replace(";", " ");
            return query;
        }
    }

    public void excluirProduto(String id){
        produtoRepository.deleteProdutoById(id);
    }

    public List<Categoria> populaCategoria(){
        Query query = getSession().createQuery("from Categoria");
        List<Categoria> listaCategorias = query.getResultList();

        return listaCategorias;
    }
}

