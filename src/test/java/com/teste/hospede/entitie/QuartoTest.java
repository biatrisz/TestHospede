package com.teste.hospede.entitie;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuartoTest {

	private Quarto quarto;

	@BeforeEach
	void setUp() {
		quarto = new Quarto(1L, "232", "Solteiro");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testGetSetId() {
		// Act
		quarto.setId(2L);
		// Assert
		assertEquals(2L, quarto.getId());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo num")
	void testGetSetNum() {
		// Act
		quarto.setNum("232");
		// Assert
		assertEquals("232", quarto.getNum());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo tipo")
	void testGetSetTipo() {
		// Act
		quarto.setTipo("Solteiro");
		// Assert
		assertEquals("Solteiro", quarto.getTipo());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testquartoConstructor() {
		Quarto novoquarto = new Quarto(3L,"232", "Solteiro");
		assertAll("novoquarto",
				()-> assertEquals(3L, novoquarto.getId()),
				()-> assertEquals("232", novoquarto.getNum()),
				()-> assertEquals("Solteiro", novoquarto.getTipo()));
		
}
}