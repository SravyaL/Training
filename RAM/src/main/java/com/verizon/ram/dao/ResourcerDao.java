package com.verizon.ram.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verizon.ram.model.Resourcer;

public interface ResourcerDao extends JpaRepository<Resourcer, Long> {
	
Resourcer findByRid(long rid);
}
