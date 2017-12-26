package mx.com.amx.unotv.oli.wsb.workflow.model;

import java.io.Serializable;

/**
 * The persistent class for the oli_mx_h_nota database table.
 * 
 */

public class HNota implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fcIdContenido;

	private String clGaleria;
	private String clRtfContenido;
	private String fcAutor;
	private String fcDescripcion;
	private String fcFriendlyUrl;
	private String fcIdCategoria;
	private String fcIdClassVideo;
	private String fcIdContentOoyala;
	private String fcIdPlayerOoyala;
	private String fcIdTipoNota;
	private String fcIdYoutube;
	private String fcImagen;
	private String fcKeywords;
	private String fcPieImagen;
	private String fcTitulo;
	private String fcUrlAutor;
	private String fdFechaModificacion;
	private String fdFechaPublicacion;
	private String fiBanOtros;

	public HNota() {
	}

	
	
	/**
	 * @param fcIdContenido
	 * @param clGaleria
	 * @param clRtfContenido
	 * @param fcAutor
	 * @param fcDescripcion
	 * @param fcFriendlyUrl
	 * @param fcIdCategoria
	 * @param fcIdClassVideo
	 * @param fcIdContentOoyala
	 * @param fcIdPlayerOoyala
	 * @param fcIdTipoNota
	 * @param fcIdYoutube
	 * @param fcImagen
	 * @param fcKeywords
	 * @param fcPieImagen
	 * @param fcTitulo
	 * @param fcUrlAutor
	 * @param fdFechaModificacion
	 * @param fdFechaPublicacion
	 * @param fiBanOtros
	 */
	public HNota(String fcIdContenido, String clGaleria, String clRtfContenido, String fcAutor, String fcDescripcion,
			String fcFriendlyUrl, String fcIdCategoria, String fcIdClassVideo, String fcIdContentOoyala,
			String fcIdPlayerOoyala, String fcIdTipoNota, String fcIdYoutube, String fcImagen, String fcKeywords,
			String fcPieImagen, String fcTitulo, String fcUrlAutor, String fdFechaModificacion,
			String fdFechaPublicacion, String fiBanOtros) {
		super();
		this.fcIdContenido = fcIdContenido;
		this.clGaleria = clGaleria;
		this.clRtfContenido = clRtfContenido;
		this.fcAutor = fcAutor;
		this.fcDescripcion = fcDescripcion;
		this.fcFriendlyUrl = fcFriendlyUrl;
		this.fcIdCategoria = fcIdCategoria;
		this.fcIdClassVideo = fcIdClassVideo;
		this.fcIdContentOoyala = fcIdContentOoyala;
		this.fcIdPlayerOoyala = fcIdPlayerOoyala;
		this.fcIdTipoNota = fcIdTipoNota;
		this.fcIdYoutube = fcIdYoutube;
		this.fcImagen = fcImagen;
		this.fcKeywords = fcKeywords;
		this.fcPieImagen = fcPieImagen;
		this.fcTitulo = fcTitulo;
		this.fcUrlAutor = fcUrlAutor;
		this.fdFechaModificacion = fdFechaModificacion;
		this.fdFechaPublicacion = fdFechaPublicacion;
		this.fiBanOtros = fiBanOtros;
	}



	public String getFcIdContenido() {
		return this.fcIdContenido;
	}

	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}

	public String getClGaleria() {
		return this.clGaleria;
	}

	public void setClGaleria(String clGaleria) {
		this.clGaleria = clGaleria;
	}

	public String getClRtfContenido() {
		return this.clRtfContenido;
	}

	public void setClRtfContenido(String clRtfContenido) {
		this.clRtfContenido = clRtfContenido;
	}

	public String getFcAutor() {
		return this.fcAutor;
	}

	public void setFcAutor(String fcAutor) {
		this.fcAutor = fcAutor;
	}

	public String getFcDescripcion() {
		return this.fcDescripcion;
	}

	public void setFcDescripcion(String fcDescripcion) {
		this.fcDescripcion = fcDescripcion;
	}

	public String getFcFriendlyUrl() {
		return this.fcFriendlyUrl;
	}

	public void setFcFriendlyUrl(String fcFriendlyUrl) {
		this.fcFriendlyUrl = fcFriendlyUrl;
	}

	public String getFcIdCategoria() {
		return this.fcIdCategoria;
	}

	public void setFcIdCategoria(String fcIdCategoria) {
		this.fcIdCategoria = fcIdCategoria;
	}

	public String getFcIdClassVideo() {
		return this.fcIdClassVideo;
	}

	public void setFcIdClassVideo(String fcIdClassVideo) {
		this.fcIdClassVideo = fcIdClassVideo;
	}

	public String getFcIdContentOoyala() {
		return this.fcIdContentOoyala;
	}

	public void setFcIdContentOoyala(String fcIdContentOoyala) {
		this.fcIdContentOoyala = fcIdContentOoyala;
	}

	public String getFcIdPlayerOoyala() {
		return this.fcIdPlayerOoyala;
	}

	public void setFcIdPlayerOoyala(String fcIdPlayerOoyala) {
		this.fcIdPlayerOoyala = fcIdPlayerOoyala;
	}

	public String getFcIdTipoNota() {
		return this.fcIdTipoNota;
	}

	public void setFcIdTipoNota(String fcIdTipoNota) {
		this.fcIdTipoNota = fcIdTipoNota;
	}

	public String getFcIdYoutube() {
		return this.fcIdYoutube;
	}

	public void setFcIdYoutube(String fcIdYoutube) {
		this.fcIdYoutube = fcIdYoutube;
	}

	public String getFcImagen() {
		return this.fcImagen;
	}

	public void setFcImagen(String fcImagen) {
		this.fcImagen = fcImagen;
	}

	public String getFcKeywords() {
		return this.fcKeywords;
	}

	public void setFcKeywords(String fcKeywords) {
		this.fcKeywords = fcKeywords;
	}

	public String getFcPieImagen() {
		return this.fcPieImagen;
	}

	public void setFcPieImagen(String fcPieImagen) {
		this.fcPieImagen = fcPieImagen;
	}

	public String getFcTitulo() {
		return this.fcTitulo;
	}

	public void setFcTitulo(String fcTitulo) {
		this.fcTitulo = fcTitulo;
	}

	public String getFcUrlAutor() {
		return this.fcUrlAutor;
	}

	public void setFcUrlAutor(String fcUrlAutor) {
		this.fcUrlAutor = fcUrlAutor;
	}

	public String getFdFechaModificacion() {
		return this.fdFechaModificacion;
	}

	public void setFdFechaModificacion(String fdFechaModificacion) {
		this.fdFechaModificacion = fdFechaModificacion;
	}

	public String getFdFechaPublicacion() {
		return this.fdFechaPublicacion;
	}

	public void setFdFechaPublicacion(String fdFechaPublicacion) {
		this.fdFechaPublicacion = fdFechaPublicacion;
	}

	public String getFiBanOtros() {
		return this.fiBanOtros;
	}

	public void setFiBanOtros(String fiBanOtros) {
		this.fiBanOtros = fiBanOtros;
	}



	@Override
	public String toString() {
		return "HNota [fcIdContenido=" + fcIdContenido + ", clGaleria=" + clGaleria + ", clRtfContenido="
				+ clRtfContenido + ", fcAutor=" + fcAutor + ", fcDescripcion=" + fcDescripcion + ", fcFriendlyUrl="
				+ fcFriendlyUrl + ", fcIdCategoria=" + fcIdCategoria + ", fcIdClassVideo=" + fcIdClassVideo
				+ ", fcIdContentOoyala=" + fcIdContentOoyala + ", fcIdPlayerOoyala=" + fcIdPlayerOoyala
				+ ", fcIdTipoNota=" + fcIdTipoNota + ", fcIdYoutube=" + fcIdYoutube + ", fcImagen=" + fcImagen
				+ ", fcKeywords=" + fcKeywords + ", fcPieImagen=" + fcPieImagen + ", fcTitulo=" + fcTitulo
				+ ", fcUrlAutor=" + fcUrlAutor + ", fdFechaModificacion=" + fdFechaModificacion
				+ ", fdFechaPublicacion=" + fdFechaPublicacion + ", fiBanOtros=" + fiBanOtros + "]";
	}

}