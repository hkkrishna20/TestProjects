package com.rankingEnZymes.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rankingEnZymes.model.UserBean;
import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;

@Repository
public interface FinalCAZvRepository extends CrudRepository<FinalCAZvType, String>{

      public List<FinalCAZvType> findAllByOrderByGenomecodeDesc();
      public List<FinalCAZvType> findAllByOrderByGenomecodeAsc();
      
      public List<FinalCAZvType> findAllByOrderByTotalenzymesDesc();
      public List<FinalCAZvType> findAllByOrderByTotalenzymesAsc();
	public Iterable findAll();
}