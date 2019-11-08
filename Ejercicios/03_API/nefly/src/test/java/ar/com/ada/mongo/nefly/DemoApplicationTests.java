package ar.com.ada.mongo.nefly;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ada.mongo.nefly.entities.Episodio;
import ar.com.ada.mongo.nefly.entities.Serie;
import ar.com.ada.mongo.nefly.entities.Temporada;
import ar.com.ada.mongo.nefly.services.SerieService;
import ar.com.ada.mongo.nefly.services.SerieService.SerieValidationType;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void verificarSerie() {
		SerieService service = new SerieService();

		Serie serie = new Serie();
		

		SerieValidationType validationType = service.verificarSerie(serie);
		
		assertEquals(SerieValidationType.SERIE_DATOS_INVALIDOS, validationType);

	}

	@Test
	void verificarSerieTempDuplicada() {
		SerieService service = new SerieService();

		Serie serie = new Serie();
		serie.setNombre("Breaking Bad");
		serie.setAño(2008);
		serie.setGenero("Drama");
		Temporada temporada = new Temporada();

		temporada.setNumeroTemporada(3);

		serie.getTemporadas().add(temporada);
		
		Episodio e = new Episodio();

		temporada.getEpisodios().add(e);
		
		Temporada temporada2 = new Temporada();

		temporada2.setNumeroTemporada(3);
		
		serie.getTemporadas().add(temporada2);
		
		e = new Episodio();

		temporada2.getEpisodios().add(e);
		

		SerieValidationType serieValidationType = service.verificarSerie(serie);
		
		assertEquals(SerieValidationType.TEMPORADA_DUPLICADA, serieValidationType);

	}

}
