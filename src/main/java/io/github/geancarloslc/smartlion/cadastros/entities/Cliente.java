package io.github.geancarloslc.smartlion.cadastros.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "de_cliente")
    private String deCliente;

    @Column(name = "nu_cpf_cnpj")
    private String nuCpfCnpj;

    @Column(name = "is_pessoa_juridica")
    private Boolean isPessoaJuridica;

    @Column(name = "nu_cep")
    private String nuCep;

    @Column(name = "de_pais")
    private String dePais;

    @Column(name = "de_estado")
    private String deEstado;

    @Column(name = "de_cidade")
    private String deCidade;

    @Column(name = "de_bairro")
    private String deBairro;

    @Column(name = "de_rua")
    private String deRua;

    @Column(name = "de_referencia")
    private String deReferencia;

    @Column(name = "nu_telefone")
    private String nuTelefone;

    @Column(name = "de_obs")
    private String deObs;

    @Column(name = "dt_atualizacao")
    private Date dtAtualizacao;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeCliente() {
		return deCliente;
	}

	public void setDeCliente(String deCliente) {
		this.deCliente = deCliente;
	}

	public String getNuCpfCnpj() {
		return nuCpfCnpj;
	}

	public void setNuCpfCnpj(String nuCpfCnpj) {
		this.nuCpfCnpj = nuCpfCnpj;
	}

	public Boolean getPessoaJuridica() {
		return isPessoaJuridica;
	}

	public void setPessoaJuridica(Boolean pessoaJuridica) {
		isPessoaJuridica = pessoaJuridica;
	}

	public String getNuCep() {
		return nuCep;
	}

	public void setNuCep(String nuCep) {
		this.nuCep = nuCep;
	}

	public String getDePais() {
		return dePais;
	}

	public void setDePais(String dePais) {
		this.dePais = dePais;
	}

	public String getDeEstado() {
		return deEstado;
	}

	public void setDeEstado(String deEstado) {
		this.deEstado = deEstado;
	}

	public String getDeCidade() {
		return deCidade;
	}

	public void setDeCidade(String deCidade) {
		this.deCidade = deCidade;
	}

	public String getDeBairro() {
		return deBairro;
	}

	public void setDeBairro(String deBairro) {
		this.deBairro = deBairro;
	}

	public String getDeRua() {
		return deRua;
	}

	public void setDeRua(String deRua) {
		this.deRua = deRua;
	}

	public String getDeReferencia() {
		return deReferencia;
	}

	public void setDeReferencia(String deReferencia) {
		this.deReferencia = deReferencia;
	}

	public String getNuTelefone() {
		return nuTelefone;
	}

	public void setNuTelefone(String nuTelefone) {
		this.nuTelefone = nuTelefone;
	}

	public String getDeObs() {
		return deObs;
	}

	public void setDeObs(String deObs) {
		this.deObs = deObs;
	}

	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	@Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", deCliente='" + deCliente + '\'' +
                ", nuCpfCnpj='" + nuCpfCnpj + '\'' +
                ", isPessoaJuridica=" + isPessoaJuridica +
                ", nuCep='" + nuCep + '\'' +
                ", dePais='" + dePais + '\'' +
                ", deEstado='" + deEstado + '\'' +
                ", deCidade='" + deCidade + '\'' +
                ", deBairro='" + deBairro + '\'' +
                ", deRua='" + deRua + '\'' +
                ", deReferencia='" + deReferencia + '\'' +
                ", nuTelefone='" + nuTelefone + '\'' +
                ", deObs='" + deObs + '\'' +
                ", dtAtualizacao=" + dtAtualizacao +
                '}';
    }


    
}
