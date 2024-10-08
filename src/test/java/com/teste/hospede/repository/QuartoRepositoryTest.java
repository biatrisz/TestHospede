package com.teste.hospede.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teste.hospede.entitie.Quarto;

@DataJpaTest
class QuartoRepositoryTest {

	@Autowired
	private QuartoRepository quartoRepository;

	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {

		Quarto quarto1 = new Quarto (null, "234", "solteiro");


		Quarto saveQuarto = quartoRepository.save(quarto1);

		assertNotNull(saveQuarto);
		assertTrue(saveQuarto.getId() > 0);

	}	

	@SuppressWarnings("unused")
	@DisplayName("Testando get para todos quarto")
	@Test
	void testGetAllRepository() {

		Quarto quarto1 = new Quarto(null, "903", "casado");

		Quarto Quarto2 = new Quarto (null, "007", "solteiro");

		quartoRepository.save(quarto1);
		quartoRepository.save(Quarto2);

		List<Quarto> QuartoList = quartoRepository.findAll();

	}

	@DisplayName("Testando get by id")
	@Test
	void testGetById() {

		Quarto quarto1 = new Quarto(null, "002", "casado");

		quartoRepository.save(quarto1);

		Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();

		assertNotNull(saveQuarto);
		assertEquals(quarto1.getId(), saveQuarto.getId());
	}
	@DisplayName("Testando o update")
	@Test
	void testUpdateQuarto() {

		Quarto quarto = new Quarto (null, "876", "solteiro");

		quartoRepository.save(quarto);

		Quarto saveQuarto = quartoRepository.findById(quarto.getId()).get();
		quarto.setNum("998");
		quarto.setTipo("solteiro");

		Quarto updateQuarto = quartoRepository.save(saveQuarto);

		assertNotNull(updateQuarto);
		assertEquals("032", updateQuarto.getNum());
		assertEquals("solteiro", updateQuarto.getTipo());
	}
	@DisplayName("testando o delete")
	@Test
	void testDeleteQuarto() {

		Quarto quarto1= new Quarto(null, "032", "solteiro");

		quartoRepository.save(quarto1);

		quartoRepository.deleteById(quarto1.getId());

		Optional<Quarto> quartoOptional = quartoRepository.findById(quarto1.getId());

		assertTrue(quartoOptional.isEmpty());
	}

}
