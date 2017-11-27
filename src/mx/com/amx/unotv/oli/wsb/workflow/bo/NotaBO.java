/**
 * 
 */
package mx.com.amx.unotv.oli.wsb.workflow.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.oli.wsb.workflow.bo.exception.NotaBOException;
import mx.com.amx.unotv.oli.wsb.workflow.model.NNota;
import mx.com.amx.unotv.oli.wsb.workflow.ws.HNotaCallWS;
import mx.com.amx.unotv.oli.wsb.workflow.ws.NNotaCallWS;
import mx.com.amx.unotv.oli.wsb.workflow.model.HNota;
import mx.com.amx.unotv.oli.wsb.workflow.bo.NotaBO;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class NotaBO {
	
	@Autowired
	NNotaCallWS nNotaCallWS;
	@Autowired
	HNotaCallWS hNotaCallWS;

	private static Logger logger = Logger.getLogger(NotaBO.class);
	
	
	
	public int saveOrUpdate(NNota nota) throws NotaBOException {
		logger.debug(" --- saveOrUpdate [ NotaBO ] --- ");
		int res = 0;

		try {

			if (validateIfExistHNota(nota.getFcFriendlyUrl())) {

				res = update(nota);

			} else {

				res = insert(nota);

			}

		} catch (Exception e) {
			logger.error("Exception  saveOrUpdate [ NotaBO  ] : " + e.getMessage());
			throw new NotaBOException(e.getMessage());
		}

		return res;
	}


	public int saveOrUpdate(NNota nota, String tags) throws NotaBOException {
		logger.debug(" --- saveOrUpdate [ NotaBO ] --- ");

		int res = 0;

		return res;
	}
	
	
	
	public boolean validateIfExistNNota(String friendlyURL) throws NotaBOException {
		logger.debug(" --- validateIfExistNNota [ NotaBO ] --- ");
		NNota res = null;

		try {
			res = nNotaCallWS.findByFriendlyURL(friendlyURL);
		} catch (Exception e) {
			logger.error("--- Exception  validateIfExistNNota [ NotaBO  ] : " + e.getMessage());
			throw new NotaBOException(e.getMessage());
		}
		return ((res == null) ? false : true);
	}

	public boolean validateIfExistHNota(String friendlyURL) throws NotaBOException {
		logger.debug(" --- validateIfExistHNota [ NotaBO ] --- ");
		HNota res = null;

		try {
			res = hNotaCallWS.findByFriendlyURL(friendlyURL);
		} catch (Exception e) {
			logger.error("--- Exception  validateIfExistHNota [ NotaBO  ] : " + e.getMessage());
			throw new NotaBOException(e.getMessage());
		}
		return ((res == null) ? false : true);
	}

	
	
	private int insert(NNota nota) throws NotaBOException {
		logger.debug(" ---private insert [ NotaBO ] --- ");

		int res = 0;

		try {

			res = nNotaCallWS.insert(nota);
			if (res > 0) {
				res = hNotaCallWS.insert(nota);
			}

		} catch (Exception e) {
			logger.error("--- Exception private insert [ NotaBO  ] : " + e.getMessage());
			throw new NotaBOException(e.getMessage());
		}

		return res;
	}
	
	
	private int update(NNota nota) throws NotaBOException {
		logger.debug(" ---private update [ NotaBO ] --- ");

		int res = 0;

		try {

			if (validateIfExistNNota(nota.getFcFriendlyUrl())) {

				res = nNotaCallWS.update(nota);
			} else {/* si no existe informacion en NNota , inserta */

				res = nNotaCallWS.insert(nota);
			}

			/*
			 * si se inserto o actualizo informacion en NNota , Inserta informacion en HNota
			 */
			if (res > 0) {
				res = hNotaCallWS.update(nota);
			}

		} catch (Exception e) {
			logger.error("--- Exception private update [ NotaBO  ] : " + e.getMessage());
			throw new NotaBOException(e.getMessage());
		}

		return res;
	}
	
	
	public int reviewItem(NNota nota) throws NotaBOException {
		logger.debug(" --- reviewItem [ NotaBO ] --- ");
		int res = 0;

		try {

			
			res = saveOrUpdate(nota);

		} catch (Exception e) {

			logger.error("Exception  reviewItem [ NotaBO  ] : " + e.getMessage());
			throw new NotaBOException(e.getMessage());
		}

		return res;
	}
	
	
	public int expireItem(NNota  nota) throws NotaBOException {
		logger.debug(" --- expireItem [ NotaBO ] --- ");
		int res = 0;
		String friendlyURL = "";
		try {

			friendlyURL = nota.getFcFriendlyUrl();
			res = nNotaCallWS.delete(friendlyURL);
			if (res > 0) {
				
				res = hNotaCallWS.delete(friendlyURL);
			}

		} catch (Exception e) {
			logger.error("Exception  expireItem [ NotaBO  ] : " + e.getMessage());
			throw new NotaBOException(e.getMessage());
		}

		return res;
	}
}
