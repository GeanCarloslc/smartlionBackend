package io.github.geancarloslc.smartlion.cadastros.entities;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "caixa_itens")
public class CaixaItens implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "id_caixa")
    private Integer idCaixa;

    @Column(name = "id_produto")
    private String idProduto;

	@Column(name = "qt_produto")
	private Double qtProduto;

	@Formula("(select a.de_produto from produtos a where a.id = id_produto)")
	private String deProduto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(Integer idCaixa) {
		this.idCaixa = idCaixa;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Double getQtProduto() {
		return qtProduto;
	}

	public void setQtProduto(Double qtProduto) {
		this.qtProduto = qtProduto;
	}

	public String getDeProduto() {
		return deProduto;
	}

	public void setDeProduto(String deProduto) {
		this.deProduto = deProduto;
	}
}
