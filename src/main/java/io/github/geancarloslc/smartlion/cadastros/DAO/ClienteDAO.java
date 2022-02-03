package io.github.geancarloslc.smartlion.cadastros.DAO;

import io.github.geancarloslc.smartlion.cadastros.entities.Cliente;
import io.github.geancarloslc.smartlion.cadastros.repositorys.ClienteRepository;
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
public class ClienteDAO {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    private final ClienteRepository clienteRepository;

	public Cliente addCliente(Cliente cliente) {

        cliente.setDtAtualizacao(new Date());

//        List<Cliente> lista = getSession().createCriteria(Cliente.class).list(); Buscando todos os dados da class
//        Cliente novo = new Cliente();

//        novo.setDeCliente("Hibernate");
//        getSession().save(novo); Salvando no banco

//        Query query = getSession().createQuery("from Cliente where id = 2");
//       List<Cliente> lista = query.getResultList();// Buscando dados de Query

        return clienteRepository.save(cliente);
    }

    public List<Cliente> filtroClientes(Cliente clienteFiltro) {

        Integer qtRestritions = 0;
        String sQuerySelect = "from Cliente ";
        String sQuery = "";
        if (clienteFiltro.getDeCliente() != null && !clienteFiltro.getDeCliente().equals("")){
            qtRestritions ++;
            sQuery += "where lower(deCliente) LIKE  lower('" + clienteFiltro.getDeCliente().trim() + "%');";
        }

        if (clienteFiltro.getNuCpfCnpj() != null && !clienteFiltro.getNuCpfCnpj().equals("")){
            qtRestritions ++;
            sQuery += "where lower(nuCpfCnpj) LIKE  lower('" + clienteFiltro.getNuCpfCnpj().trim() + "%');";
        }

        if (clienteFiltro.getDePais() != null && !clienteFiltro.getDePais().equals("")){
            qtRestritions ++;
            sQuery += "where lower(dePais) LIKE  lower('" + clienteFiltro.getDePais().trim() + "%');";
        }

        if (clienteFiltro.getDeEstado() != null && !clienteFiltro.getDeEstado().equals("")){
            qtRestritions ++;
            sQuery += "where lower(deEstado) LIKE  lower('" + clienteFiltro.getDeEstado().trim() + "%');";
        }

        if (clienteFiltro.getDeCidade() != null && !clienteFiltro.getDeCidade().equals("")){
            qtRestritions ++;
            sQuery += "where lower(deCidade) LIKE  lower('" + clienteFiltro.getDeCidade().trim() + "%');";
        }

            sQuery = validaQuery(sQuery, qtRestritions);
            sQuerySelect += sQuery;
            Query query = getSession().createQuery(sQuerySelect);
            List<Cliente> lista = query.getResultList();

        return lista;
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

    public void excluirCliente(Integer id){
        clienteRepository.deleteClienteById(id);
    }
}

