package com.anptain.hera.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anptain.hera.repository.SysPropertieRepository;

@Service
@Transactional
public class SysPropertieService {
	@Autowired
	private SysPropertieRepository sysPropertieRepository;
}