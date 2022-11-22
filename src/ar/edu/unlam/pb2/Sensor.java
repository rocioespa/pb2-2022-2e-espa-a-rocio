package ar.edu.unlam.pb2;

import java.util.Objects;

public class Sensor {
	
	private Integer idNumerico;
	private Boolean estado;
	
	public Sensor(Integer idNumerico, Boolean estado) {
		this.idNumerico = idNumerico;
		this.estado = estado;
	}

	public Integer getIdNumerico() {
		return idNumerico;
	}

	public void setIdNumerico(Integer idNumerico) {
		this.idNumerico = idNumerico;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado, idNumerico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		return Objects.equals(estado, other.estado) && Objects.equals(idNumerico, other.idNumerico);
	}

	

}
