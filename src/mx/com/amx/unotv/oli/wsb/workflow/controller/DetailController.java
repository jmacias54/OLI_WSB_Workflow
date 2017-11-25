/**
 * 
 */
package mx.com.amx.unotv.oli.wsb.workflow.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.amx.unotv.oli.wsb.workflow.controller.exception.ControllerException;



/**
 * @author Jesus A. Macias Benitez
 *
 */


@Controller
@RequestMapping("detail")
public class DetailController {
	
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(DetailController.class);
	
	
	@RequestMapping(value = "/save_item", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int saveItem() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- saveItem -----");

	
		try {

			return 0 ; //detailBO.saveItem(item);

		} catch (Exception e) {
			logger.error(" -- Error  saveNota [ItemsController]:", e);
			throw new ControllerException(e.getMessage());
		}


	}
	
	
	@RequestMapping(value = "/expire_item", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int expireItem() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- expire_item -----");

		int res = 0;
		try {

			// res = detailBO.expireItem(item);

		} catch (Exception e) {
			logger.error(" -- Error  expire_item [ItemsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}
	
	
	@RequestMapping(value = "/review_item", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int reviewItem() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- review_item -----");

		int res = 0;
		try {

			//res = detailBO.reviewItem(item);

		} catch (Exception e) {
			logger.error(" -- Error  review_item [ItemsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}

}
