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

import com.teste.hospede.entitie.Hospede;

@DataJpaTest
class HospedeRepositoryTest {

	@Autowired
	private HospedeRepository hospedeRepository;

	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Hospede hospede1 = new Hospede (null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
		
	
		Hospede saveHospede = hospedeRepository.save(hospede1);
		
		assertNotNull(saveHospede);
		assertTrue(saveHospede.getId() > 0);
		
	}	

	@DisplayName("Testando get para todos hospedes")
	@Test
	void testGetAllRepository() {
		
		Hospede hospede1 = new Hospede(null, "Joaquim", "joaquim@gmail.com", "(00)0000-0000");

		Hospede hospede2 = new Hospede(null, "Cainan Fidelis Pinto", "cainanpinto@gmail.com", "(00)0000-0000");

		hospedeRepository.save(hospede1);
		hospedeRepository.save(hospede2);

		List<Hospede> hospedeList = hospedeRepository.findAll();
	
	}

	@DisplayName("Testando get by id")
		@Test
		void testGetById() {
			
			Hospede hospede1 = new Hospede(null, "Cainan Fidelis Pinto", "cainanpinto@gmail.com", "(00) 0000-0000");
			
			hospedeRepository.save(hospede1);
			
			Hospede saveHospede = hospedeRepository.findById(hospede1.getId()).get();
			
			assertNotNull(saveHospede);
			assertEquals(hospede1.getId(), saveHospede.getId());
	}
	@DisplayName("Testando o update")
		@Test
		void testUpdateHospede() {
			
			Hospede hospede1 = new Hospede (null, "Cainan Fidelis Pinto", "cainanpinto@gmail.com", "(00) 0000-0000");
			
			hospedeRepository.save(hospede1);
			
			Hospede saveHospede = hospedeRepository.findById(hospede1.getId()).get();
			hospede1.setNome("Wellington Fernandes");
			hospede1.setEmail("fernandeswellington@gmail.com");
			
			Hospede updateHospede = hospedeRepository.save(saveHospede);
					
			assertNotNull(updateHospede);
			assertEquals("Wellington Fernandes", updateHospede.getNome());
			assertEquals("fernandeswellington@gmail.com", updateHospede.getEmail());
	}
	@DisplayName("testando o delete")
	@Test
	void testDeleteHospede() {

		Hospede hospede1 = new Hospede(null, "Julio Victor", "Victorjulio@gmail.com", "(00) 0000-0000");

		hospedeRepository.save(hospede1);

		hospedeRepository.deleteById(hospede1.getId());

		Optional<Hospede> hospedeOptional = hospedeRepository.findById(hospede1.getId());

		assertTrue(hospedeOptional.isEmpty());

	}
}


