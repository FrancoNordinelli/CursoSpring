package mx.com.gm.domain;

import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name="usuario")
public class Usuario {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Rol> roles;
}
