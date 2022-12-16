package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.IdCard;

public interface IdCardDao extends JpaRepository<IdCard, Integer>{
	
	@Query("select i from IdCard i where i.adharcard.aadharNo=?1")
	public Optional<IdCard> getMemberByAdharNo(Long adharNo);
	
	@Query("select i from IdCard i where i.panCard.panNo=?1")
	public Optional<IdCard> getMemberByPanCardNo(String pancard);
	
}
