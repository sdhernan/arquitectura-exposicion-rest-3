/**
 * AforeControllerTest.java
 * Fecha de creacion: ${date}
 *
 * Copyright (c) ${year} Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informacion confidencial, propiedad del
 * Procesar S A de C V. Esta informacion confidencial
 * no debera ser divulgada y solo se podra utilizar de acuerdo
 * a los terminos que determine la propia empresa.
 */
package ${package}.${projectName.toLowerCase()}.exposicion.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ${package}.${projectName.toLowerCase()}.servicios.service.AforeService;

/**
 * Clase de prueba para AforeController.
 * 
 * @author SDHERNAN
 */
class AforeControllerTest {

	/** The afore service. */
	@Mock
	private AforeService aforeService;

	/** The afore controller. */
	@InjectMocks
	private AforeController aforeController;

	/** The mock mvc. */
	private MockMvc mockMvc;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(aforeController).build();
	}

	/**
	 * Test get afores.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetAfores() throws Exception {
		when(aforeService.obtenerTodasLasAfores()).thenReturn(Collections.emptyList());
		mockMvc.perform(get("/api/afores")).andExpect(status().isOk());
	}
}
