package ar.edu.unlam.pb2;

public class UsuarioConfigurador extends Usuario implements Configurable{

	public UsuarioConfigurador(Integer dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void agregarSensorALaAlarma(Alarma alarma, Sensor sensorAAgregar) throws SensorDuplicado {
		alarma.agregarSensor(sensorAAgregar);
	}


	@Override
	public Boolean activarSensor(Alarma alarma, String codConfiguracion) throws CodigoDeAlarmaIncorrectoException, SensorDesactivado {
		if(alarma.getCodigoConfiguracion().equals(codConfiguracion)) {
			for (Sensor sensores : alarma.getSensores()) {
				if(sensores.getEstado()) {
					return true;
				}else {
					return false;
				}
			}
		}
		throw new CodigoDeAlarmaIncorrectoException("codigo de configuracion incorrecto");
		
	}

	@Override
	public void agregarUsuarioAAlarma(Central centralAlarma, Alarma nuevaAlarma, Usuario uc, String codConfiguracion)
			throws CodigoDeAlarmaIncorrectoException {
		// TODO Auto-generated method stub
		
	}

	

	

}
