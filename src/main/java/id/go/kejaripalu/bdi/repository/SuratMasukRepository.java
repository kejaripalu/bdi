package id.go.kejaripalu.bdi.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.go.kejaripalu.bdi.domain.JenisSurat;
import id.go.kejaripalu.bdi.domain.SuratMasuk;

public interface SuratMasukRepository extends JpaRepository<SuratMasuk, String> {

	@Query("SELECT s FROM SuratMasuk s WHERE s.deleted=false AND s.jenisSurat=:jenisSurat "
			+ "AND s.waktuPenerimaanSurat BETWEEN :startDate AND :endDate "
			+ "ORDER BY s.waktuPenerimaanSurat DESC")
	Page<SuratMasuk> findSuratMasukAll(Date startDate, Date endDate, JenisSurat jenisSurat, Pageable pageable);
		
	Optional<SuratMasuk> findByIdAndDeletedFalse(String id);
	
}
