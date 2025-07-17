package com.springboot.sms.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.sms.backend.entity.Shift;

public interface ShiftRepository extends JpaRepository<Shift, Long>{
	List<Shift> findByUserId(Long userId);

}
