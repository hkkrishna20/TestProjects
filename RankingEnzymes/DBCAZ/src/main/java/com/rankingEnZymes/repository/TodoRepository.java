/*package com.rankingEnZymes.repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;

interface TodoRepository extends Repository<FinalCAZvType, String> {

	public Optional<FinalCAZvType> findByTitleAndDescriptionOpt(String title, String description);

	@Query("SELECT t FROM FinalCAZvType t where t.title = ?1 AND t.description = ?2")
	public Optional<FinalCAZvType> findByTitleAndDescription(String title, String description);

	@Query(value = "SELECT * FROM FinalCAZvType t where t.title = ?0 AND t.description = ?1", nativeQuery = true)
	public Optional<FinalCAZvType> findByTitleAndDescriptionO(String title, String description);

	@Async
	@Query("SELECT t.title FROM Todo t where t.id = :id")
	Future<String> findTitleByIdW(@Param("id") Long id);

	@Async
	@Query("SELECT t.title FROM Todo t where t.id = :id")
	Future<Optional<String>> findTitleById(@Param("id") Long id);

	@Async
	Future<FinalCAZvType> findById(Long id);

	@Async
	Future<Optional<FinalCAZvType>> findByIds(Long id);

	@Async
	Future<List<FinalCAZvType>> findByTitleT(String title);

	@Async
	Future<Stream<FinalCAZvType>> findByTitleS(String title);

	@Query("SELECT t.title FROM Todo t where t.id = :id")
	String findTitleByIdN(@Param("id") Long id);

	@Query("SELECT t.title FROM Todo t where t.id = :id")
	Optional<String> findTitleByIdM(@Param("id") Long id);

	FinalCAZvType findByIdTT(Long id);

	Optional<FinalCAZvType> findByIdR(Long id);

	}
*/