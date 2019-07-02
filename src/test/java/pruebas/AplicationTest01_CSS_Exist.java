package pruebas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 
 * @author Marian Drozd 02/07/2019 18:46
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AplicationTest01_CSS_Exist.class })
@AutoConfigureMockMvc
public class AplicationTest01_CSS_Exist {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnCssFile() throws Exception {

		this.mockMvc.perform(get("resources/css/estilos.css")).andDo(print()).andExpect(status().isOk());
		// Si quieres que falle, cambia el nombre del CSS
	}
	
	@Test
    public void contextLoads() throws Exception {
    	//Deberia fallar aposta
    	assertThat(true).isTrue();
    }

}
