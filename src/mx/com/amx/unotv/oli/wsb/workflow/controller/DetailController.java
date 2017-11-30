/**
 * 
 */
package mx.com.amx.unotv.oli.wsb.workflow.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.amx.unotv.oli.wsb.workflow.bo.DetailBO;
import mx.com.amx.unotv.oli.wsb.workflow.controller.exception.ControllerException;
import mx.com.amx.unotv.oli.wsb.workflow.model.Item;

/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("detail")
public class DetailController {

	@Autowired
	DetailBO detailBO;

	/** The logger. */
	private static Logger logger = Logger.getLogger(DetailController.class);

	@RequestMapping(value = "/save_item", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int saveItem(@RequestBody Item item) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- saveItem -----");
		logger.debug("--- DTO :"+item.toString());

		try {

			return detailBO.saveItem(item);

		} catch (Exception e) {
			logger.error(" -- Error  saveNota [ItemsController]:", e);
			throw new ControllerException(e.getMessage());
		}

	}

	@RequestMapping(value = "/expire_item", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int expireItem(@RequestBody Item item) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- expire_item -----");
		logger.debug("--- DTO :"+item.toString());
		try {

			return detailBO.expireItem(item);

		} catch (Exception e) {
			logger.error(" -- Error  expire_item [ItemsController]:", e);
			throw new ControllerException(e.getMessage());
		}

	}

	@RequestMapping(value = "/review_item", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public Item reviewItem(@RequestBody Item item) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- review_item -----");
		logger.debug("--- DTO :"+item.toString());
		try {

			return detailBO.reviewItem(item);

		} catch (Exception e) {
			logger.error(" -- Error  review_item [ItemsController]:", e);
			throw new ControllerException(e.getMessage());
		}

	}
	
	@RequestMapping(value = "/item", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public Item item() throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- item -----");

		return new Item();

	}

}
