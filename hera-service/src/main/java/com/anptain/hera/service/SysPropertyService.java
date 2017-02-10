package com.anptain.hera.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anptain.hera.domain.SysProperty;
import com.anptain.hera.repository.SysPropertyRepository;
import com.anptain.hera.service.model.SysPropertyVo;

@Service
@Transactional
public class SysPropertyService {
	@Autowired
	private SysPropertyRepository sysPropertyRepository;

	public SysProperty save(SysPropertyVo vo) {
		SysProperty sysProperty = new SysProperty();
		BeanUtils.copyProperties(sysProperty, vo);
		return sysPropertyRepository.save(sysProperty);
	}
}