package io.github.geancarloslc.smartlion.cadastros.entities;
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

    @Column(name = "qt_produto")
    private Integer qtProduto;

	@Column(name = "vl_unitario")
	private Double vlUnitario;

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

	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	@Override
	public String toString() {
		return "Produto{" +
				"id='" + id + '\'' +
				", deProduto='" + deProduto + '\'' +
				", deMarca='" + deMarca + '\'' +
				", qtProduto=" + qtProduto +
				", vlUnitario=" + vlUnitario +
				", dtAtualizacao=" + dtAtualizacao +
				'}';
	}
}
