package io.github.geancarloslc.smartlion.cadastros.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

    @Id
    private String id;

    @Column(name = "de_categoria")
    private String deCategoria;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeCategoria() {
		return deCategoria;
	}

	public void setDeCategoria(String deCategoria) {
		this.deCategoria = deCategoria;
	}

	@Override
	public String toString() {
		return "Categoria{" +
				"id='" + id + '\'' +
				", deCategoria='" + deCategoria + '\'' +
				'}';
	}
}
