package com.anptain.hera.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anptain.hera.repository.SysPropertyRepository;
import com.anptain.hera.service.SysPropertyService;
import com.anptain.hera.service.model.ResultVo;
import com.anptain.hera.service.model.SysPropertyVo;
import com.anptain.hera.web.model.SimplePageable;

@Controller
@RequestMapping("/sysManage")
public class SysManageController extends AbstractController {
	private static Logger LOG = LoggerFactory.getLogger(SysManageController.class);
	@Autowired
	private SysPropertyRepository sysPropertyRepository;
	@Autowired
	private SysPropertyService sysPropertyService;

	@RequestMapping(value = "/property")
	public String sysProperty(Integer p, Integer s, Model model) {
		model.addAttribute("sysProperty", sysPropertyRepository.findAll(SimplePageable.defaultPage(p, s)));
		return "sysManage/sysProperty";
	}

	@ResponseBody
	@RequestMapping(value = "/add_property")
	public ResultVo addSysProperty(SysPropertyVo vo) {
		try {
			sysPropertyService.save(vo);
			return ResultVo.createSuccessResp();
		} catch (Exception e) {
			LOG.error("添加系统属性异常", e);
			return ResultVo.createExceptionResp();
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/del_property")
	public ResultVo delSysProperty(Long id) {
		try {
			sysPropertyRepository.delete(id);
			return ResultVo.createSuccessResp();
		} catch (Exception e) {
			LOG.error("添加系统属性异常", e);
			return ResultVo.createExceptionResp();
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit_property")
	public ResultVo editSysProperty(Long id) {
		try {
			sysPropertyRepository.delete(id);
			return ResultVo.createSuccessResp();
		} catch (Exception e) {
			LOG.error("添加系统属性异常", e);
			return ResultVo.createExceptionResp();
		}
	}
}
