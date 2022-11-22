package ar.edu.unlam.pb2;

import java.util.*;

public class Central {
	
	List<Usuario> usuarios;
	List<Alarma>alarmas;
	public Central() {
		super();
		this.alarmas = new ArrayList<>();
		this.usuarios = new ArrayList<>();
	}
	
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	public List<Alarma> getAlarmas() {
		return alarmas;
	}



	public void setAlarmas(List<Alarma> alarmas) {
		this.alarmas = alarmas;
	}


	public void agregarAlarmaALaCentral(Alarma nuevaAlarma) {
		// TODO Auto-generated method stub
		this.alarmas.add(nuevaAlarma);
		
	}
	public void agregarUsuarioALaCentral(Usuario uc) {
		this.usuarios.add(uc);
		
	}
	
	public boolean buscarAlarmaPorId(Alarma alarma) {
		for (Alarma al : alarmas) {
			if(alarma.getId().equals(al.getId())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean buscarUsuarioPorDni(Usuario u) {
		for (Usuario usuario : usuarios) {
			if(usuario.getDni().equals(u.getDni())) {
				return true;
			}
		}
		return false;
	}
	

}
