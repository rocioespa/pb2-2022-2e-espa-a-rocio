package ar.edu.unlam.pb2;

import java.util.List;

public class UsuarioAdministrador extends Usuario implements Configurable,Activador{

	public UsuarioAdministrador(Integer dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}

	public void agregarAlarma(Alarma nuevaAlarma, Central centralAlarma) {
		centralAlarma.agregarAlarmaALaCentral(nuevaAlarma);
		
	}
	
	public void agregarUsuarioALaCentral(Central centralAlarma, Usuario uc) {
		centralAlarma.agregarUsuarioALaCentral(uc);
		
	}


	public void agregarUsuarioAAlarma(Central centralAlarma, Alarma nuevaAlarma, Usuario uc, String codConfiguracion) throws CodigoDeAlarmaIncorrectoException {
		if(centralAlarma.buscarAlarmaPorId(nuevaAlarma)) {
			if(centralAlarma.buscarUsuarioPorDni(uc)) {
				if(nuevaAlarma.getCodigoConfiguracion().equals(codConfiguracion)) {
					nuevaAlarma.agregarUsuario(uc);
				}else {
					throw new CodigoDeAlarmaIncorrectoException("El codigo de configuracion es incorrecto");
				}
				
			}
		}
	}



	@Override
	public void agregarSensorALaAlarma(Alarma alarma, Sensor sensorAAgregar) throws SensorDuplicado {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean desactivarAlarma(Alarma alarma, String codigoActivacionAlarma, Usuario configurador) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean activarAlarma(Alarma alarma, String codigoActivacionAlarma, UsuarioConfigurador configurador)
			throws CodigoDeAlarmaIncorrectoException, SensorDesactivado, AlarmaDesactivada {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean activarSensor(Alarma alarma, String codConfiguracion)
			throws CodigoDeAlarmaIncorrectoException, SensorDesactivado {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
