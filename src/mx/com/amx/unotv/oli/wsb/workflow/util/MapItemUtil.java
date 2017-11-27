/**
 * 
 */
package mx.com.amx.unotv.oli.wsb.workflow.util;


import mx.com.amx.unotv.oli.wsb.workflow.model.Item;
import mx.com.amx.unotv.oli.wsb.workflow.model.NNota;

/**
 * @author Jesus A. Macias Benitez
 *
 */


public class MapItemUtil {

	
	public NNota MapItemToNota(Item item) {
		
		NNota nota = new NNota();
		
		
		nota.setClGaleria(item.getCl_galeria());
		nota.setClRtfContenido(item.getCl_rft_contenido());
		nota.setFcAutor(item.getFc_autor());
		nota.setFcDescripcion(item.getFc_descripcion());
		nota.setFcFriendlyUrl(item.getFc_friendly_url());
		nota.setFcIdCategoria(item.getFc_id_categoria());
		nota.setFcIdClassVideo(item.getFc_id_class_video());
	
		nota.setFcIdContenido(item.getFc_id_contenido());
		nota.setFcIdContentOoyala(item.getFc_id_content_ooyala());
		nota.setFcIdPlayerOoyala(item.getFc_id_player_ooyala());
		nota.setFcIdYoutube(item.getFc_id_youtube());
		nota.setFcImagen(item.getFc_imagen());
		nota.setFcKeywords(item.getFc_keywords());
		nota.setFcPieImagen(item.getFc_pie_imagen());
		nota.setFcTipoNota(item.getFc_id_tipo_nota());
		nota.setFcTitulo(item.getFc_titulo());
		nota.setFcUrlAutor(item.getFc_url_autor());
		nota.setFdFechaPublicacion(item.getFc_fecha_publicacion());
		nota.setFiBanOtros(item.getFi_ban_otros());
		
		
		
		return nota ;
		
	}
}
