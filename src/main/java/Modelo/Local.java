package Modelo;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "temp")
public class Local {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String estado;
	private String cidade;
	private int temperatura = 0;
	Random r = new Random();

	
	public Local() {
		
	}
	
	public Local(String estado, String cidade) {
		this.estado = estado;
		this.cidade = cidade;
		this.temperatura = r.nextInt(40);
	}
	public Long getId() {
		return id;
	}

	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public int getTemperatura() {
		return temperatura;
	}
	
}
