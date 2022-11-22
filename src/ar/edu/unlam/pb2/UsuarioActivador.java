package ar.edu.unlam.pb2;

public class UsuarioActivador extends Usuario implements Activador {

	public UsuarioActivador(Integer dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}



	@Override
	public boolean desactivarAlarma(Alarma alarma, String codigoActivacionAlarma, Usuario configurador) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Boolean activarAlarma(Alarma alarma, String codigoActivacionAlarma, UsuarioConfigurador configurador) throws CodigoDeAlarmaIncorrectoException, SensorDesactivado, AlarmaDesactivada {
		if(alarma.getCodigoActivacion().equals(codigoActivacionAlarma)) {
			if(configurador.activarSensor(alarma, alarma.getCodigoConfiguracion())) {
				return true;
			}else {
				
				throw new AlarmaDesactivada();
			}
		}
		throw new CodigoDeAlarmaIncorrectoException("codigo de alarma de activacion incorrecto");
	}

}
