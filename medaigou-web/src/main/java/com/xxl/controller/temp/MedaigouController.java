package com.xxl.controller.temp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xxl.medaigou.facade.TempRemote;
import common.controller.BaseController;
import common.temp.vo.TempOrderVo;
import common.utils.SemAppUtils;

@Controller
@RequestMapping("/meDaigouController")
public class MedaigouController extends BaseController {

	public static Log logger = LogFactory.getLog(MedaigouController.class);
	public static Log dbLogger = SemAppUtils.getDBLog(MedaigouController.class);

	@Autowired
	public TempRemote tempRemote;
	
	@RequestMapping("/")
	public String defaultMethod(HttpServletRequest request, HttpServletResponse response) {
		
		return "medaigou";
	}
	
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,TempOrderVo vo) {
		response.setContentType("text/json;charset=UTF-8");
		
		
	}
	
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/json;charset=UTF-8");
		
	}

}