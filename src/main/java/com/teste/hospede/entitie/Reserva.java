package com.teste.hospede.entitie;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column (name = "CheckInData", nullable = false,  length = 255)
	private LocalDate CheckInData;
	
	@NotNull
	@Column (name = "CheckOutData", nullable = false,  length = 255)
	private LocalDate CheckOutData;

	@ManyToOne
	@JoinColumn(name = "id_quarto", nullable = false)
	private Quarto quarto;
	
	@ManyToOne 
	@JoinColumn(name = "id_hospede", nullable = false)
	private Hospede hospede;
}
