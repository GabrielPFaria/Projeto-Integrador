package br.org.generation.ambar.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Espaço nome não pode ficar em branco")
	@Size(min = 3, max = 255, message = "O tamanho de nome deve ficar entre 3 e 255")
	private String nome;
	
	@NotBlank(message = "Espaço email não pode ficar em branco")
	@Size(min = 3, max = 255, message = "O tamanho de email deve ficar entre 3 e 255")
	private String email;
	
	@NotBlank(message = "Espaço senha não pode ficar em branco")
	@Size(min = 6, max = 10, message = "O tamanho de senha deve ficar entre 6 e 10")
	private String senha;

	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuarios") 
	private List<Postagens> Postagens;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Postagens> getPostagens() {
		return Postagens;
	}

	public void setPostagens(List<Postagens> postagens) {
		Postagens = postagens;
	}
	
	
}
