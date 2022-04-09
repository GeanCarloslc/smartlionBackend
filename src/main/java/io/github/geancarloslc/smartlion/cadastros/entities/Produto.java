package io.github.geancarloslc.smartlion.cadastros.entities;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {

    @Id
    private String id;

    @Column(name = "de_produto")
    private String deProduto;

    @Column(name = "de_marca")
    private String deMarca;

	@Column(name = "cd_categoria")
	private String cdCategoria;

	@Column(name = "qt_produto")
    private Integer qtProduto;

	@Column(name = "vl_unitario")
	private Double vlUnitario;

	@Column(name = "im_produto")
	private String imProduto;

	@Formula("(select a.de_categoria from categorias a where a.id = cd_categoria)")
	private String deCategoria;

	@Column(name = "dt_atualizacao")
	private Date dtAtualizacao;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeProduto() {
		return deProduto;
	}

	public void setDeProduto(String deProduto) {
		this.deProduto = deProduto;
	}

	public String getDeMarca() {
		return deMarca;
	}

	public void setDeMarca(String deMarca) {
		this.deMarca = deMarca;
	}

	public Integer getQtProduto() {
		return qtProduto;
	}

	public void setQtProduto(Integer qtProduto) {
		this.qtProduto = qtProduto;
	}

	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public Double getVlUnitario() {
		return vlUnitario;
	}

	public String getCdCategoria() {
		return cdCategoria;
	}

	public void setCdCategoria(String cdCategoria) {
		this.cdCategoria = cdCategoria;
	}

	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	public String getDeCategoria() {
		return deCategoria;
	}

	public void setDeCategoria(String deCategoria) {
		this.deCategoria = deCategoria;
	}

	public String getImProduto() {
		return imProduto;
	}

	public void setImProduto(String imProduto) {
		this.imProduto = imProduto;
	}

	@Override
	public String toString() {
		return "Produto{" +
				"id='" + id + '\'' +
				", deProduto='" + deProduto + '\'' +
				", deMarca='" + deMarca + '\'' +
				", cdCategoria='" + cdCategoria + '\'' +
				", qtProduto=" + qtProduto +
				", vlUnitario=" + vlUnitario +
				", dtAtualizacao=" + dtAtualizacao +
				'}';
	}
}
