package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.LiveasyModel;

@Repository
public interface LiveasyRepository extends JpaRepository<LiveasyModel , Integer>{
	
	@Transactional
	@Modifying
	@Query(value="update liveasy_loads set comment = ?1 , date=?2,loading_point=?3,no_of_trucks=?4,product_type=?5,truck_type=?6,unloading_point=?7,weight=?8 where shipper_id = ?9",nativeQuery=true)
	int update(String comment,Date date,String loading_point,int no_of_trucks,String product_type,String truck_type,String unloading_point,int weight , int shipper_id);
}
