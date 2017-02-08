package com.anptain.hera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.anptain.hera.domain.SysPropertie;
import com.anptain.hera.domain.User;

@Repository
public interface SysPropertieRepository extends JpaRepository<SysPropertie, Long>, JpaSpecificationExecutor<SysPropertie> {
	User findByUsername(String username);
}
