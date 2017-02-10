package com.anptain.hera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.anptain.hera.domain.SysProperty;

@Repository
public interface SysPropertyRepository extends JpaRepository<SysProperty, Long>, JpaSpecificationExecutor<SysProperty> {
}
