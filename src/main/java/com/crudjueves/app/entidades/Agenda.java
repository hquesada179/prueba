package com.crudjueves.app.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="agenda")
public class Agenda {
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long Id;
	
	@NotEmpty
	private String nombre;
	
	private Long telefono;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	
	

}
