package ar.edu.unlam.pb2;

public class Accion {
	
	private Integer id;
	private Alarma nuevAlarma;
	private Usuario usuario;
	private String fecha;
	private TipoOperacion tipo;
	
	public Accion(Integer id, Alarma nuevAlarma, Usuario usuario, String fecha, TipoOperacion tipo) {
		super();
		this.id = id;
		this.nuevAlarma = nuevAlarma;
		this.usuario = usuario;
		this.fecha = fecha;
		this.tipo = tipo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Alarma getNuevAlarma() {
		return nuevAlarma;
	}
	public void setNuevAlarma(Alarma nuevAlarma) {
		this.nuevAlarma = nuevAlarma;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public TipoOperacion getTipo() {
		return tipo;
	}
	public void setTipo(TipoOperacion tipo) {
		this.tipo = tipo;
	}

}
