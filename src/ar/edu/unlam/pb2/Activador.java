package ar.edu.unlam.pb2;

public interface Activador {
	

	boolean desactivarAlarma(Alarma alarma, String codigoActivacionAlarma, Usuario configurador);

	Boolean activarAlarma(Alarma alarma, String codigoActivacionAlarma, UsuarioConfigurador configurador) throws CodigoDeAlarmaIncorrectoException, SensorDesactivado, AlarmaDesactivada;

}
