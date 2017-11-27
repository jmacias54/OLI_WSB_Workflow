/**
 * 
 */
package mx.com.amx.unotv.oli.wsb.workflow.ws;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import mx.com.amx.unotv.oli.wsb.workflow.model.HNota;
import mx.com.amx.unotv.oli.wsb.workflow.model.NNota;
import mx.com.amx.unotv.oli.wsb.workflow.ws.exception.HNotaCallWSException;





/**
 * @author Jesus A. Macias Benitez
 *
 */
public class HNotaCallWS {
	
	private static Logger logger = Logger.getLogger(NNotaCallWS.class);

	private RestTemplate restTemplate;
	private String URL_WS_BASE = "";
	private String URL_WS_HNOTA = "/hNota";
	private HttpHeaders headers = new HttpHeaders();
	private final Properties props = new Properties();

	public HNotaCallWS() {
		super();
		restTemplate = new RestTemplate();
		ClientHttpRequestFactory factory = restTemplate.getRequestFactory();

		if (factory instanceof SimpleClientHttpRequestFactory) {
			((SimpleClientHttpRequestFactory) factory).setConnectTimeout(15 * 1000);
			((SimpleClientHttpRequestFactory) factory).setReadTimeout(15 * 1000);
			System.out.println("Inicializando rest template 1");
		} else if (factory instanceof HttpComponentsClientHttpRequestFactory) {
			((HttpComponentsClientHttpRequestFactory) factory).setReadTimeout(15 * 1000);
			((HttpComponentsClientHttpRequestFactory) factory).setConnectTimeout(15 * 1000);
			System.out.println("Inicializando rest template 2");
		}

		restTemplate.setRequestFactory(factory);
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			props.load(this.getClass().getResourceAsStream("/general.properties"));
		} catch (Exception e) {
			logger.error("[ HNotaCallWS ::init]Error al iniciar y cargar arhivo de propiedades." + e.getMessage());

		}
		String ambiente = props.getProperty("ambiente");
		URL_WS_BASE = props.getProperty(ambiente + ".url.ws.base");
		
	}
	
	
	public int insert(NNota nota) throws HNotaCallWSException {

		int res = 0;
		String metodo = "/insert";
		String URL_WS = URL_WS_BASE + URL_WS_HNOTA + metodo;

		logger.info("--- insertNota --- [ HNotaCallWS ] --- ");
		logger.info("--- URL : " + URL_WS);

		try {
			

			res = restTemplate.postForObject(URL_WS, nota, Integer.class);

			logger.info(" Registros obtenidos --> " + res);

		} catch (RestClientResponseException rre) {
			logger.error("RestClientResponseException insertNota [ HNotaCallWS ]: " + rre.getResponseBodyAsString());
			logger.error("RestClientResponseException insertNota[ HNotaCallWS ]: ", rre);
			throw new HNotaCallWSException(rre.getResponseBodyAsString());
		} catch (Exception e) {
			logger.error("Exception insertNota  [ HNotaCallWS ]: ", e);
			throw new HNotaCallWSException(e.getMessage());
		}

		return res;

	}
	
	
	public int update(NNota nota) throws HNotaCallWSException {

		int res = 0;
		String metodo = "/update";
		String URL_WS = URL_WS_BASE + URL_WS_HNOTA + metodo;

		logger.info("--- updateNota --- [ HNotaCallWS ] --- ");
		logger.info("--- URL : " + URL_WS);

		try {
			logger.info("URL_WS: " + URL_WS);

			res = restTemplate.postForObject(URL_WS, nota, Integer.class);

			logger.info(" Registros obtenidos --> " + res);

		} catch (RestClientResponseException rre) {
			logger.error("RestClientResponseException updateNota [ HNotaCallWS ]: " + rre.getResponseBodyAsString());
			logger.error("RestClientResponseException updateNota[ HNotaCallWS ]: ", rre);
			throw new HNotaCallWSException(rre.getResponseBodyAsString());
		} catch (Exception e) {
			logger.error("Exception updateNota  [ HNotaCallWS ]: ", e);
			throw new HNotaCallWSException(e.getMessage());
		}

		return res;

	}
	
	
	
	public int delete(String  friendlyURL) throws HNotaCallWSException {

		int res = 0;
		String metodo = "/delete/";
		String URL_WS = URL_WS_BASE + URL_WS_HNOTA + metodo +friendlyURL;

		logger.info("--- delete --- [ HNotaCallWS ] --- ");
		logger.info("--- URL : " + URL_WS);

		try {
			logger.info("URL_WS: " + URL_WS);

			HttpEntity<String> entity = new HttpEntity<String>("Accept=application/json; charset=utf-8", headers);
			res = restTemplate.postForObject(URL_WS, entity, Integer.class);

			logger.info(" Registros obtenidos --> " + res);

		} catch (RestClientResponseException rre) {
			logger.error("RestClientResponseException delete [ HNotaCallWS ]: " + rre.getResponseBodyAsString());
			logger.error("RestClientResponseException delete[ HNotaCallWS ]: ", rre);
			throw new HNotaCallWSException(rre.getResponseBodyAsString());
		} catch (Exception e) {
			logger.error("Exception delete  [ HNotaCallWS ]: ", e);
			throw new HNotaCallWSException(e.getMessage());
		}

		return res;

	}
	
	
	public HNota findByFriendlyURL(String friendlyURL) throws HNotaCallWSException {

		
		String URL_WS = URL_WS_BASE + URL_WS_HNOTA ;

		logger.info("--- findByFriendlyURL --- [ HNotaCallWS ] --- ");
		logger.info("--- URL : " + URL_WS);

		HNota nota = null;

		try {
			logger.info("URL_WS: " + URL_WS);
			HttpEntity<String> entity = new HttpEntity<String>("Accept=application/json; charset=utf-8", headers);
			nota = restTemplate.postForObject(URL_WS + "/" + friendlyURL, entity, HNota.class);

			if(nota != null)
			logger.info(" Registros obtenidos --> " + nota.toString());

		} catch (NullPointerException npe) {
			
			return null;
		}catch (RestClientResponseException rre) {
			logger.error("RestClientResponseException findByFriendlyURL [ HNotaCallWS ]: " + rre.getResponseBodyAsString());
			logger.error("RestClientResponseException  findByFriendlyURL [ HNotaCallWS ]: ", rre);
			throw new HNotaCallWSException(rre.getResponseBodyAsString());
		} catch (Exception e) {
			logger.error("Exception findByFriendlyURL   [ HNotaCallWS ]: ", e);
			throw new HNotaCallWSException(e.getMessage());
		}

		return nota;
	}
	

}
