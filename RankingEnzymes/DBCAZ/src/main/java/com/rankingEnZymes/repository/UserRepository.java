/*package com.rankingEnZymes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;

public interface UserRepository extends JpaRepository<FinalCAZvType, String> {
	 @Query(value = "SELECT * FROM finalcaz WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
	 FinalCAZvType findByEmailAddress(String emailAddress);

}
*/