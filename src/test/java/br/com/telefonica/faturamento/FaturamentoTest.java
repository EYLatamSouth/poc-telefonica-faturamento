package br.com.telefonica.faturamento;

import br.com.telefonica.faturamento.api.controller.BillingControllerHexagonal;
import br.com.telefonica.faturamento.api.model.Faturamento;
import br.com.telefonica.faturamento.api.repository.BillingRepositoryFaturamentoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import net.minidev.json.JSONObject;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@CamelSpringBootTest
@Disabled
public class FaturamentoTest {
	@MockBean
	@Autowired
	BillingRepositoryFaturamentoImpl dataServiceMock;

	@Autowired
	BillingControllerHexagonal billingControllerHexagonal;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() throws Exception {
		assertThat(billingControllerHexagonal).isNotNull();
	}

	@Test
	public void testFindAllBillings() throws Exception {
		Faturamento faturamento = new Faturamento();
		faturamento.setBilling_data_pgto("2022-01-01");
		faturamento.setBilling_id(1);
		faturamento.setBilling_status("3");
		faturamento.setCustomer_id(2);
		faturamento.setBilling_vencimento("2022-01-31");
		faturamento.setBilling_valor_fatura("122.56");
		List<Faturamento> faturamentos = new ArrayList<>();
		faturamentos.add(faturamento);
		when(dataServiceMock.findAll()).thenReturn(faturamentos);
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/billings", String.class)).contains("\"billing_id\":1");
		verify(dataServiceMock, times(1)).findAll();
	}

	@Test
	public void testFindBillingById() throws Exception {
		Integer billing_id = 999999999;
		Faturamento faturamento = new Faturamento();
		faturamento.setBilling_data_pgto("2022-05-01");
		faturamento.setBilling_id(billing_id);
		faturamento.setBilling_status("1");
		faturamento.setCustomer_id(5);
		faturamento.setBilling_vencimento("2022-05-31");
		faturamento.setBilling_valor_fatura("142.71");
		when(dataServiceMock.findOrFail(billing_id)).thenReturn(faturamento);
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/billings/" + billing_id, String.class)).contains("\"billing_id\":" + billing_id);
		verify(dataServiceMock, times(1)).findOrFail(billing_id);
	}

	@Test
	public void testDeleteBilling() throws Exception {
		Integer billing_id = 999999999;
		doNothing().when(dataServiceMock).deleteBilling(billing_id);
		HttpEntity<String> entity = new HttpEntity<>(null, new HttpHeaders());
		ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:" + port + "/billings/" + billing_id, HttpMethod.DELETE, entity, String.class);
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		verify(dataServiceMock, times(1)).deleteBilling(billing_id);
	}

	@Test
	public void testSaveBilling() throws Exception {
		JSONObject billingDetailsRequestJson = new JSONObject();
		billingDetailsRequestJson.put("billing_id", "189");
		billingDetailsRequestJson.put("customer_id", "1");
		billingDetailsRequestJson.put("billing_vencimento", "2022-01-31");
		billingDetailsRequestJson.put("billing_status", "2");
		billingDetailsRequestJson.put("billing_data_pgto", "2022-01-31");
		billingDetailsRequestJson.put("billing_valor_fatura", "1465.78");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> request =
				new HttpEntity<String>(billingDetailsRequestJson.toString(), headers);
		Faturamento faturamento = new Faturamento();
		faturamento.setBilling_data_pgto("2022-05-01");
		faturamento.setBilling_id(189);
		faturamento.setBilling_status("1");
		faturamento.setCustomer_id(5);
		faturamento.setBilling_vencimento("2022-05-31");
		faturamento.setBilling_valor_fatura("142.71");
		when(dataServiceMock.save(faturamento)).thenReturn(faturamento);

		ResponseEntity<String> createdUserDetailsEntity = restTemplate.postForEntity("http://localhost:" + port + "/billings/", request, String.class);
		assertThat(createdUserDetailsEntity.getStatusCode().name()).isEqualTo("CREATED");
		verify(dataServiceMock, times(1)).save(any(Faturamento.class));
	}

	@Test
	public void testEditBilling() throws Exception {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Faturamento faturamento = new Faturamento();
		faturamento.setBilling_data_pgto("2022-05-01");
		faturamento.setBilling_id(183);
		faturamento.setBilling_status("1");
		faturamento.setCustomer_id(5);
		faturamento.setBilling_vencimento("2022-05-31");
		faturamento.setBilling_valor_fatura("149.7");

		when(dataServiceMock.updateBilling(faturamento, 183)).thenReturn(faturamento);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity(ow.writeValueAsString(faturamento), headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/billings/183", HttpMethod.PUT, entity, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		verify(dataServiceMock, times(1)).updateBilling(any(Faturamento.class), eq(183));
	}
}
