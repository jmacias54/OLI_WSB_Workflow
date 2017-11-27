/**
 * 
 */
package mx.com.amx.unotv.oli.wsb.workflow.bo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import mx.com.amx.unotv.oli.wsb.workflow.bo.exception.DetailBOException;
import mx.com.amx.unotv.oli.wsb.workflow.bo.NotaBO;
import mx.com.amx.unotv.oli.wsb.workflow.dto.ContentDTO;
import mx.com.amx.unotv.oli.wsb.workflow.dto.ParametrosDTO;
import mx.com.amx.unotv.oli.wsb.workflow.model.Item;
import mx.com.amx.unotv.oli.wsb.workflow.model.NNota;
import mx.com.amx.unotv.oli.wsb.workflow.util.MapItemUtil;
import mx.com.amx.unotv.oli.wsb.workflow.util.PropertiesUtils;
import mx.com.amx.unotv.oli.wsb.workflow.util.Utils;


/**
 * @author Jesus A. Macias Benitez
 *
 */
public class DetailBO {
	
	private static Logger logger = Logger.getLogger(DetailBO.class);
	
	
	@Autowired
	NotaBO notaBO;
	
	@Autowired
	MapItemUtil mapItemUtil;
	
	public int saveItem(Item item) throws DetailBOException {
		logger.debug("*** Inicia saveItem [ DetailBO ] ***");

		ParametrosDTO parametrosDTO = null;
		PropertiesUtils properties = new PropertiesUtils();

		boolean success = false;

		String id_facebook = "";
		String carpetaContenido = "";
		String urlNota = "";
		int res = 0;
		SimpleDateFormat dateFormat;

		NNota nota = null;
		

		// Obtenemos archivo de propiedades
		try {

			parametrosDTO = properties.obtenerPropiedades();

			nota = mapItemUtil.MapItemToNota(item);

			dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			nota.setFdFechaPublicacion(dateFormat.format(new Date()));
			nota.setFdFechaModificacion(dateFormat.format(new Date()));
		
	

			// ruta con dominio wwww.unotv.com ó http://dev-unotv.tmx-internacional.net
			logger.info("Frendy URL: " + nota.getFcFriendlyUrl());
			urlNota = parametrosDTO.getDominio() + "/" + Utils.getRutaContenido(nota);
			logger.info("URL: " + urlNota);

			// Ruta donde se va guardar el html servidor /var/dev-repos/shared_www/pyeongchang/
			carpetaContenido = parametrosDTO.getPathFiles() + Utils.getRutaContenido(nota);
			logger.info("carpetaContenido: " + carpetaContenido);

			// Validamos si la nota contiene video de ooyala
			logger.debug("**TIPO DE NOTA: " + nota.getFcTipoNota());

			try {
				// Guardamos o actualizamos la nota en la base de datos.
				/*
				 * se manda item ya que cuando se inserta la nota en las tablas hnota y nnnota ,
				 * se tienen que insertar en la tabla tags
				 */
				res = notaBO.saveOrUpdate(nota);

			} catch (Exception e) {
				logger.error("--- Exception  saveOrUpdate [ saveItem  ] : " + e.getMessage());
				throw new DetailBOException(e.getMessage());
			}

			if (res > 0) {
				// Guardamos o actualizamos los Tags de la nota

				// Creamos estrcutura de directorios
				success = Utils.createFolders(carpetaContenido);

				if (success)
					success = Utils.createPlantilla(parametrosDTO, nota, carpetaContenido);
				if (success) {
					// Generamos el json del detalle para la app.
					

					
					// Enviamos Push de Instant Article

					ContentDTO contentDTO = new ContentDTO();


					Date parsedDate = dateFormat.parse(nota.getFdFechaPublicacion());
					Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

					contentDTO.setClGaleriaImagenes((nota.getClGaleria() == null) ? "" : nota.getClGaleria());
					contentDTO.setClRtfContenido((nota.getClRtfContenido() == null) ? "" : nota.getClRtfContenido());
					contentDTO.setFcEscribio((nota.getFcAutor() == null) ? "" : nota.getFcAutor());
					contentDTO.setFcIdCategoria((nota.getFcIdCategoria() == null) ? "" : nota.getFcIdCategoria());
				
					contentDTO.setFcIdContenido((nota.getFcIdContenido() == null) ? "" : nota.getFcIdContenido());
					contentDTO.setFcIdPlayerOoyala(
							(nota.getFcIdPlayerOoyala() == null) ? "" : nota.getFcIdPlayerOoyala());
					contentDTO.setFcIdTipoNota((nota.getFcTipoNota() == null) ? "" : nota.getFcTipoNota());
					contentDTO.setFcIdVideoOoyala(
							(nota.getFcIdContentOoyala() == null) ? "" : nota.getFcIdContentOoyala());
					contentDTO.setFcIdVideoYouTube((nota.getFcIdYoutube() == null) ? "" : nota.getFcIdYoutube());
					contentDTO.setFcImgPrincipal((nota.getFcImagen() == null) ? "" : nota.getFcImagen());
					contentDTO.setFcKeywords((nota.getFcKeywords() == null) ? "" : nota.getFcKeywords());
					
		
					contentDTO.setFcNombre((nota.getFcFriendlyUrl() == null) ? "" : nota.getFcFriendlyUrl());
				
					contentDTO.setFdFechaPublicacion(timestamp);
				

					try {
						// id_facebook = facebookCallWS.insertUpdateArticleFB(contentDTO,
						// parametrosDTO);
						logger.debug("id_facebook: " + id_facebook);
					} catch (Exception boe) {
						logger.error("--- Exception  facebookCallWS  [ saveItem  ] : " + boe.getMessage());
						throw new DetailBOException(boe.getMessage());
					}

				}

			}

		} catch (Exception e) {
			logger.error("--- Exception saveItem  [ DetailBO ]: ", e);
			throw new DetailBOException(e.getMessage());
		}

		return res;

	}
	
	
	
	public int expireItem(Item  item) throws DetailBOException {

		int res = 0;
		NNota nota = null;

		ParametrosDTO parametrosDTO = null;
		PropertiesUtils properties = null;

		try {

			properties = new PropertiesUtils();
			parametrosDTO = properties.obtenerPropiedades();
	
			nota = mapItemUtil.MapItemToNota(item);
		

			// Ruta para borrar html
			String carpetaContenido = parametrosDTO.getPathFiles() + Utils.getRutaContenido(nota);
			logger.debug("carpetaContenido: " + carpetaContenido);
			// Borramos html
			boolean delteHTML = Utils.deleteHTML(carpetaContenido);
			logger.debug("Se borro direcorio: " + delteHTML);

			if (delteHTML) {

				res = notaBO.expireItem(nota);

			}

		} catch (Exception e) {
			logger.error(" --- Exception expireItem  [ DetailBO ]: ", e);
			throw new DetailBOException(e.getMessage());
		}
		return res;
	}
	
	
	public Item reviewItem(Item item) throws DetailBOException {

		/*
		int res = 0;
		NNota nota = null;

		try {

			nota = mapItemUtil.MapItemToNota(item);
			res = notaBO.reviewItem(nota, item.getTags());

		} catch (Exception e) {
			logger.error("--- Exception reviewItem  [ DetailBO ]: ", e);
			throw new DetailBOException(e.getMessage());
		}*/  
		return item;
	}
}
