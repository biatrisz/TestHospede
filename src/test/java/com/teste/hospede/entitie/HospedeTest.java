package com.teste.hospede.entitie;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospedeTest {
	private Hospede hospede;
	@BeforeEach
	void setUp() {
		hospede = new Hospede(1L, "justin bieber", "justin@bieber.com", "(00)0000-0009");
	}
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testGetSetId() {
		//Act
		hospede.setId(2L);
		//Assert
		assertEquals(2L,hospede.getId());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testGetSetNome () {
		//Act
		hospede.setNome("Selena gomes");
		//Assert
		assertEquals("Selena gomes", hospede.getNome());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testGetSetEmail () {
		//Act
		hospede.setEmail("selenahgomesy@gmail.com");
		//Assert
		assertEquals("selenahgomesy@gmail.com", hospede.getEmail());

	}@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testGetSetTelefone () {
		//Act
		hospede.setTelefone("(99) 9434-43434");
		//Assert
		assertEquals("(99) 9434-43434", hospede.getTelefone());
	}
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testHospedeConstructor() {
		Hospede novoHospede = new Hospede(3L,"lana", "lanadelrey@gmail.com", "(12) 4234-4324");
		assertAll("novoHospede",()-> assertEquals(3L, novoHospede.getId()),
				()-> assertEquals("lana", novoHospede.getNome()),
				()-> assertEquals("lanadelrey@gmail.com", novoHospede.getEmail()),
				()-> assertEquals("(12) 4234-4324", novoHospede.getTelefone()));
}
}