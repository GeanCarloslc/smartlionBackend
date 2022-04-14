package io.github.geancarloslc.smartlion.cadastros.entities;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "caixa")
public class Caixa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "de_produto")
    private String deProduto;

	@Column(name = "dt_atualizacao")
	private Date dtAtualizacao;

	public Integer getId() {
		return id;
	}

	public String getDeProduto() {
		return deProduto;
	}

	public void setDeProduto(String deProduto) {
		this.deProduto = deProduto;
	}

	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}
}
