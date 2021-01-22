package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PedidoCabecera
 *
 */
@Entity

public class PedidoCabecera implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String estadoActual;
	private String estadoSiguiente;
	
	@ManyToOne
	@JoinColumn
	private Persona persona;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoCabecera")
	private List<PedidoDetalle> pedidoDetalle = new ArrayList<PedidoDetalle>();
	
	public PedidoCabecera() {
		super();
	}
	
	
	public PedidoCabecera(int id, String estadoActual, String estadoSiguiente, Persona persona) {
		this.setId(id);
		this.setEstadoActual(estadoActual);
		this.setEstadoSiguiente(estadoSiguiente);
		this.setPersona(persona);
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}

	public String getEstadoSiguiente() {
		return estadoSiguiente;
	}

	public void setEstadoSiguiente(String estadoSiguiente) {
		this.estadoSiguiente = estadoSiguiente;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<PedidoDetalle> getPedidoDetalle() {
		return pedidoDetalle;
	}

	public void setPedidoDetalle(List<PedidoDetalle> pedidoDetalle) {
		this.pedidoDetalle = pedidoDetalle;
	}
	
	public void addPedidoDetalle(PedidoDetalle pedidoDetalle) {
		this.pedidoDetalle.add(pedidoDetalle);
	}
   
}
