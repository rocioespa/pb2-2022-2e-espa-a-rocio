package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

	@Test
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() {
		Central centralAlarma = new Central();
		Alarma nuevaAlarma = new Alarma(1, "activado", "a-1", "primera alarma");
		UsuarioAdministrador administrador = new UsuarioAdministrador(1, "candela");
		
		administrador.agregarAlarma(nuevaAlarma, centralAlarma);
		
		assertEquals(1, centralAlarma.getAlarmas().size());
	}
	
	@Test
	public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() throws CodigoDeAlarmaIncorrectoException {
		Central centralAlarma = new Central();
		Alarma nuevaAlarma = new Alarma(1, "activado", "a-1", "primera alarma");
		UsuarioAdministrador administrador = new UsuarioAdministrador(1, "candela");
		UsuarioConfigurador uc = new UsuarioConfigurador(2,"rocio");
		
		administrador.agregarAlarma(nuevaAlarma, centralAlarma);
		administrador.agregarUsuarioALaCentral(centralAlarma,uc);
		administrador.agregarUsuarioAAlarma(centralAlarma,nuevaAlarma,uc,"a-1");
		
		assertEquals(1, centralAlarma.getUsuarios().size());
		assertEquals(1, nuevaAlarma.getUsuariosValidos().size());
		
	}
	
	@Test (expected=CodigoDeAlarmaIncorrectoException.class)
	public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlarmaIncorrectoException() throws CodigoDeAlarmaIncorrectoException {
		Central centralAlarma = new Central();
		Alarma nuevaAlarma = new Alarma(1, "activado", "a-1", "primera alarma");
		UsuarioAdministrador administrador = new UsuarioAdministrador(1, "candela");
		UsuarioConfigurador uc = new UsuarioConfigurador(2,"rocio");
		
		administrador.agregarAlarma(nuevaAlarma, centralAlarma);
		administrador.agregarUsuarioALaCentral(centralAlarma,uc);
		administrador.agregarUsuarioAAlarma(centralAlarma,nuevaAlarma,uc,"b-2");
	}
	
	@Test (expected=SensorDuplicado.class)
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnaSensorDuplicadoException() throws CodigoDeAlarmaIncorrectoException, SensorDuplicado {
		Central centralAlarma = new Central();
		Alarma nuevaAlarma = new Alarma(1, "activado", "a-1", "primera alarma");
		UsuarioAdministrador administrador = new UsuarioAdministrador(1, "candela");
		UsuarioConfigurador uc = new UsuarioConfigurador(2,"rocio");
		Sensor sensor = new Sensor(1,false);
		Sensor sensor1 = new Sensor(1,false);
		
		administrador.agregarAlarma(nuevaAlarma, centralAlarma);
		administrador.agregarUsuarioALaCentral(centralAlarma,uc);
		administrador.agregarUsuarioAAlarma(centralAlarma,nuevaAlarma,uc,"a-1");
		
		uc.agregarSensorALaAlarma(nuevaAlarma, sensor);
		uc.agregarSensorALaAlarma(nuevaAlarma, sensor1);
	}

	@Test (expected = AlarmaDesactivada.class)
	public void queNoSePuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado() throws CodigoDeAlarmaIncorrectoException, SensorDuplicado, SensorDesactivado, AlarmaDesactivada {
		Central centralAlarma = new Central();
		Alarma nuevaAlarma = new Alarma(1, "activado", "a-1", "primera alarma");
		UsuarioAdministrador administrador = new UsuarioAdministrador(1, "candela");
		UsuarioConfigurador uc = new UsuarioConfigurador(2,"rocio");
		UsuarioActivador ua = new UsuarioActivador(3,"lola");
		Sensor sensor = new Sensor(1,false);
		Sensor sensor1 = new Sensor(2,false);
		Sensor sensor3 = new Sensor(3,false);
		
		administrador.agregarAlarma(nuevaAlarma, centralAlarma);
		administrador.agregarUsuarioALaCentral(centralAlarma,uc);
		administrador.agregarUsuarioAAlarma(centralAlarma,nuevaAlarma,uc,"a-1");
		administrador.agregarUsuarioALaCentral(centralAlarma,ua);
		administrador.agregarUsuarioAAlarma(centralAlarma,nuevaAlarma,ua,"a-1");
		
		uc.agregarSensorALaAlarma(nuevaAlarma, sensor);
		uc.agregarSensorALaAlarma(nuevaAlarma, sensor1);
		uc.agregarSensorALaAlarma(nuevaAlarma, sensor3);
		ua.activarAlarma(nuevaAlarma, "activado", uc);
	}
}
