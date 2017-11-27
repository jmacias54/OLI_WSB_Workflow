/**
 * 
 */
package mx.com.amx.unotv.oli.wsb.workflow.model;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class Item {

	private String fc_id_contenido;
	private String fc_id_categoria;
	private String fc_id_tipo_nota;
	private String fc_id_class_video;
	private String fc_titulo;	
	private String fc_descripcion;
	private String fc_friendly_url;
	private String fc_autor;
	private String fc_url_autor;
	private String fc_imagen;
	private String fc_pie_imagen;
	private String cl_galeria;
	private String cl_rft_contenido;
	private String fc_id_youtube;
	private String fc_id_content_ooyala;
	private String fc_id_player_ooyala;
	private String fc_pcode_ooyala;
	private String fc_keywords;	
	private String portal_cn;
	private String portal_uid;	
	private String fc_fecha_publicacion;	
	private String fi_ban_otros;
	
	
	public String getFc_id_contenido() {
		return fc_id_contenido;
	}
	public void setFc_id_contenido(String fc_id_contenido) {
		this.fc_id_contenido = fc_id_contenido;
	}
	public String getFc_id_categoria() {
		return fc_id_categoria;
	}
	public void setFc_id_categoria(String fc_id_categoria) {
		this.fc_id_categoria = fc_id_categoria;
	}
	public String getFc_id_tipo_nota() {
		return fc_id_tipo_nota;
	}
	public void setFc_id_tipo_nota(String fc_id_tipo_nota) {
		this.fc_id_tipo_nota = fc_id_tipo_nota;
	}
	public String getFc_id_class_video() {
		return fc_id_class_video;
	}
	public void setFc_id_class_video(String fc_id_class_video) {
		this.fc_id_class_video = fc_id_class_video;
	}
	public String getFc_titulo() {
		return fc_titulo;
	}
	public void setFc_titulo(String fc_titulo) {
		this.fc_titulo = fc_titulo;
	}
	public String getFc_descripcion() {
		return fc_descripcion;
	}
	public void setFc_descripcion(String fc_descripcion) {
		this.fc_descripcion = fc_descripcion;
	}
	public String getFc_friendly_url() {
		return fc_friendly_url;
	}
	public void setFc_friendly_url(String fc_friendly_url) {
		this.fc_friendly_url = fc_friendly_url;
	}
	public String getFc_autor() {
		return fc_autor;
	}
	public void setFc_autor(String fc_autor) {
		this.fc_autor = fc_autor;
	}
	public String getFc_url_autor() {
		return fc_url_autor;
	}
	public void setFc_url_autor(String fc_url_autor) {
		this.fc_url_autor = fc_url_autor;
	}
	public String getFc_imagen() {
		return fc_imagen;
	}
	public void setFc_imagen(String fc_imagen) {
		this.fc_imagen = fc_imagen;
	}
	public String getFc_pie_imagen() {
		return fc_pie_imagen;
	}
	public void setFc_pie_imagen(String fc_pie_imagen) {
		this.fc_pie_imagen = fc_pie_imagen;
	}
	public String getCl_galeria() {
		return cl_galeria;
	}
	public void setCl_galeria(String cl_galeria) {
		this.cl_galeria = cl_galeria;
	}
	public String getCl_rft_contenido() {
		return cl_rft_contenido;
	}
	public void setCl_rft_contenido(String cl_rft_contenido) {
		this.cl_rft_contenido = cl_rft_contenido;
	}
	public String getFc_id_youtube() {
		return fc_id_youtube;
	}
	public void setFc_id_youtube(String fc_id_youtube) {
		this.fc_id_youtube = fc_id_youtube;
	}
	public String getFc_id_content_ooyala() {
		return fc_id_content_ooyala;
	}
	public void setFc_id_content_ooyala(String fc_id_content_ooyala) {
		this.fc_id_content_ooyala = fc_id_content_ooyala;
	}
	public String getFc_id_player_ooyala() {
		return fc_id_player_ooyala;
	}
	public void setFc_id_player_ooyala(String fc_id_player_ooyala) {
		this.fc_id_player_ooyala = fc_id_player_ooyala;
	}
	public String getFc_keywords() {
		return fc_keywords;
	}
	public void setFc_keywords(String fc_keywords) {
		this.fc_keywords = fc_keywords;
	}
	public String getFc_fecha_publicacion() {
		return fc_fecha_publicacion;
	}
	public void setFc_fecha_publicacion(String fc_fecha_publicacion) {
		this.fc_fecha_publicacion = fc_fecha_publicacion;
	}
	public String getFi_ban_otros() {
		return fi_ban_otros;
	}
	public void setFi_ban_otros(String fi_ban_otros) {
		this.fi_ban_otros = fi_ban_otros;
	}	
	public String getPortal_cn() {
		return portal_cn;
	}
	public void setPortal_cn(String portal_cn) {
		this.portal_cn = portal_cn;
	}
	public String getPortal_uid() {
		return portal_uid;
	}
	public void setPortal_uid(String portal_uid) {
		this.portal_uid = portal_uid;
	}	
	public String getFc_pcode_ooyala() {
		return fc_pcode_ooyala;
	}
	public void setFc_pcode_ooyala(String fc_pcode_ooyala) {
		this.fc_pcode_ooyala = fc_pcode_ooyala;
	}
	/**/
	public String toString() {	
		String NEW_LINE = System.getProperty("line.separator");
		StringBuffer result=new StringBuffer();
		result.append(" [Begin of Class] " + NEW_LINE);
		result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		result.append(" fc_id_contenido: _" + this.getFc_id_contenido() + "_" + NEW_LINE);
		result.append(" fc_id_categoria: _" + this.getFc_id_categoria() + "_" + NEW_LINE);
		result.append(" fc_id_tipo_nota: _" + this.getFc_id_tipo_nota() + "_" + NEW_LINE);
		result.append(" fc_id_class_video: _" + this.getFc_id_class_video() + "_" + NEW_LINE);
		result.append(" fc_titulo: _" + this.getFc_titulo() + "_" + NEW_LINE);
		result.append(" fc_descripcion: _" + this.getFc_descripcion() + "_" + NEW_LINE);
		result.append(" fc_friendly_url: _" + this.getFc_friendly_url() + "_" + NEW_LINE);
		result.append(" fc_autor: _" + this.getFc_autor() + "_" + NEW_LINE);
		result.append(" fc_url_autor: _" + this.getFc_url_autor() + "_" + NEW_LINE);
		result.append(" fc_imagen: _" + this.getFc_imagen() + "_" + NEW_LINE);
		result.append(" fc_pie_imagen: _" + this.getFc_pie_imagen() + "_" + NEW_LINE);
		result.append(" cl_galeria: _" + this.getCl_galeria() + "_" + NEW_LINE);
		result.append(" cl_rft_contenido: _" + this.getCl_rft_contenido() + "_" + NEW_LINE);
		result.append(" fc_id_youtube: _" + this.getFc_id_youtube() + "_" + NEW_LINE);
		result.append(" fc_id_content_ooyala: _" + this.getFc_id_content_ooyala() + "_" + NEW_LINE);
		result.append(" fc_id_player_ooyala: _" + this.getFc_id_player_ooyala() + "_" + NEW_LINE);
		result.append(" fc_pcode_ooyala: _" + this.getFc_pcode_ooyala() + "_" + NEW_LINE);
		result.append(" fc_keywords" + this.getFc_keywords() + "_" + NEW_LINE);
		result.append(" fc_fecha_publicacion: _" + this.getFc_fecha_publicacion() + "_" + NEW_LINE);
		result.append(" fi_ban_otros: _" + this.getFi_ban_otros() + "_" + NEW_LINE);
		result.append(" portal_cn: _" + this.getPortal_cn() + "_" + NEW_LINE);
		result.append(" portal_uid: _" + this.getPortal_uid() + "_" + NEW_LINE);		
		result.append("}");
		NEW_LINE = null;

		return result.toString();
	}
	
}
