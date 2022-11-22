package ar.edu.unlam.pb2;

import java.util.*;

public class Alarma {

	private Integer id;
	private String codigoActivacion;
	private String codigoConfiguracion;
	private String nombre;
	private Set<Usuario> usuariosValidos;
	private Set<Accion> accionesRealizadas;
	private Set<Sensor> sensores;

	public Alarma(Integer id, String codigoActivacion, String codigoConfiguracion, String nombre) {
		this.id = id;
		this.codigoActivacion = codigoActivacion;
		this.codigoConfiguracion = codigoConfiguracion;
		this.nombre = nombre;
		this.usuariosValidos = new HashSet<>();
		this.accionesRealizadas = new TreeSet<>();
		this.sensores = new HashSet<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoActivacion() {
		return codigoActivacion;
	}

	public void setCodigoActivacion(String codigoActivacion) {
		this.codigoActivacion = codigoActivacion;
	}

	public String getCodigoConfiguracion() {
		return codigoConfiguracion;
	}

	public void setCodigoConfiguracion(String codigoConfiguracion) {
		this.codigoConfiguracion = codigoConfiguracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Usuario> getUsuariosValidos() {
		return usuariosValidos;
	}

	public void setUsuariosValidos(Set<Usuario> usuariosValidos) {
		this.usuariosValidos = usuariosValidos;
	}

	public Set<Accion> getAccionesRealizadas() {
		return accionesRealizadas;
	}

	public void setAccionesRealizadas(Set<Accion> accionesRealizadas) {
		this.accionesRealizadas = accionesRealizadas;
	}

	public Set<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(Set<Sensor> sensores) {
		this.sensores = sensores;
	}

	public void agregarUsuario(Usuario uc) {
		this.usuariosValidos.add(uc);

	}

	public void agregarSensor(Sensor sensor) throws SensorDuplicado {
		if(buscarSensor(sensor)){
			this.sensores.add(sensor);
		}
		
	}
	
	public Boolean buscarSensor(Sensor s) throws SensorDuplicado {
		if(sensores.contains(s)){
			throw new SensorDuplicado("Este sensor ya se agrego");
			
		}
		return true;
	}

}
