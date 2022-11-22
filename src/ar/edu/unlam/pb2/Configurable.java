package ar.edu.unlam.pb2;

public interface Configurable {
	
	public void agregarUsuarioAAlarma(Central centralAlarma, Alarma nuevaAlarma, Usuario uc, String codConfiguracion) throws CodigoDeAlarmaIncorrectoException;

	public void agregarSensorALaAlarma(Alarma alarma, Sensor sensorAAgregar) throws SensorDuplicado ;

	Boolean activarSensor(Alarma alarma, String codConfiguracion)
			throws CodigoDeAlarmaIncorrectoException, SensorDesactivado;
}
