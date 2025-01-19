package id.go.kejaripalu.bdi.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.go.kejaripalu.bdi.domain.RegisterKegiatanIntelijenPamstra;
import id.go.kejaripalu.bdi.dto.RegisterKegiatanIntelijenPamstraRequest;
import id.go.kejaripalu.bdi.dto.RegisterKegiatanIntelijenPamstraResponse;
import id.go.kejaripalu.bdi.exception.NotFoundException;
import id.go.kejaripalu.bdi.repository.RegisterKegiatanIntelijenPamstraRepository;
import id.go.kejaripalu.bdi.service.RegisterKegiatanIntelijenPamstraService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class RegisterKegiatanIntelijenPamstraServiceImpl implements RegisterKegiatanIntelijenPamstraService {
	
	private final RegisterKegiatanIntelijenPamstraRepository repository;

	@Override
	@Transactional
	public void create(RegisterKegiatanIntelijenPamstraRequest request) {
		RegisterKegiatanIntelijenPamstra kegiatanIntelijen = new RegisterKegiatanIntelijenPamstra();
		kegiatanIntelijen.setSektor(request.getSektor());
		kegiatanIntelijen.setNamaKegiatan(request.getNamaKegiatan());
		kegiatanIntelijen.setSumberDana(request.getSumberDana());
		kegiatanIntelijen.setInstansi(request.getInstansi());
		kegiatanIntelijen.setPaguAnggaran(request.getPaguAnggaran());
		kegiatanIntelijen.setNomorSuratPermohonan(request.getNomorSuratPermohonan());
		kegiatanIntelijen.setTanggalSuratPermohonan(request.getTanggalSuratPermohonan());
		kegiatanIntelijen.setTempatPemaparan(request.getTempatPemaparan());
		kegiatanIntelijen.setTanggalPemaparan(request.getTanggalPemaparan());
		kegiatanIntelijen.setTelaahanIntelijen(request.getTelaahanIntelijen());
		kegiatanIntelijen.setTindakLanjut(request.getTindakLanjut());
		kegiatanIntelijen.setTindakLanjutKeterangan(request.getTindakLanjutKeterangan());
		kegiatanIntelijen.setNomorSprintWalpam(request.getNomorSprintWalpam());
		kegiatanIntelijen.setTanggalSprintWalpam(request.getTanggalSprintWalpam());
		kegiatanIntelijen.setNamaPetugasPelaksana(request.getNamaPetugasPelaksana());
		kegiatanIntelijen.setNilaiKontrak(request.getNilaiKontrak());
		kegiatanIntelijen.setHasilPelaksanaan(request.getHasilPelaksanaan());
		kegiatanIntelijen.setHasilPelaksanaanKeterangan(request.getHasilPelaksanaanKeterangan());
		kegiatanIntelijen.setNomorKertasKerja(request.getNomorKertasKerja());
		kegiatanIntelijen.setTanggalKertasKerja(request.getTanggalKertasKerja());
		kegiatanIntelijen.setKeterangan(request.getKeterangan());
		kegiatanIntelijen.setUrlFile(request.getUrlFile());
		
		repository.save(kegiatanIntelijen);
		log.info("✔️ Successfully saved!!! ദ്ദി(ᵔᗜᵔ)  Register Kegiatan Pamstra Intelijen!!!");
	}

	@Override
	@Transactional
	public void update(String ids, RegisterKegiatanIntelijenPamstraRequest request) {
		RegisterKegiatanIntelijenPamstra kegiatanIntelijen = repository.findByIdsAndDeletedFalse(ids)
				.orElseThrow(() -> new NotFoundException("ID_NOT_FOUND"));
		kegiatanIntelijen.setSektor(
				request.getSektor() == null ? 
						kegiatanIntelijen.getSektor() : request.getSektor());
		kegiatanIntelijen.setNamaKegiatan(
				request.getNamaKegiatan() == null || request.getNamaKegiatan().isBlank() ? 
						kegiatanIntelijen.getNamaKegiatan() : request.getNamaKegiatan());
		kegiatanIntelijen.setSumberDana(
				request.getSumberDana() == null || request.getSumberDana().isBlank() ? 
						kegiatanIntelijen.getSumberDana() : request.getSumberDana());
		kegiatanIntelijen.setInstansi(
				request.getInstansi() == null || request.getInstansi().isBlank() ? 
						kegiatanIntelijen.getInstansi() : request.getInstansi());
		kegiatanIntelijen.setPaguAnggaran(
				request.getPaguAnggaran() == null ? 
						kegiatanIntelijen.getPaguAnggaran() : request.getPaguAnggaran());
		kegiatanIntelijen.setNomorSuratPermohonan(
				request.getNomorSuratPermohonan() == null || request.getNomorSuratPermohonan().isBlank() ? 
						kegiatanIntelijen.getNomorSuratPermohonan() : request.getNomorSuratPermohonan());
		kegiatanIntelijen.setTanggalSuratPermohonan(
				request.getTanggalSuratPermohonan() == null ? 
						kegiatanIntelijen.getTanggalSuratPermohonan() : request.getTanggalSuratPermohonan());
		kegiatanIntelijen.setTempatPemaparan(request.getTempatPemaparan());
		kegiatanIntelijen.setTanggalPemaparan(request.getTanggalPemaparan());
		kegiatanIntelijen.setTelaahanIntelijen(request.getTelaahanIntelijen());
		kegiatanIntelijen.setTindakLanjut(request.getTindakLanjut());
		kegiatanIntelijen.setTindakLanjutKeterangan(request.getTindakLanjutKeterangan());
		kegiatanIntelijen.setNomorSprintWalpam(request.getNomorSprintWalpam());
		kegiatanIntelijen.setTanggalSprintWalpam(request.getTanggalSprintWalpam());
		kegiatanIntelijen.setNamaPetugasPelaksana(request.getNamaPetugasPelaksana());
		kegiatanIntelijen.setNilaiKontrak(request.getNilaiKontrak());
		kegiatanIntelijen.setHasilPelaksanaan(request.getHasilPelaksanaan());
		kegiatanIntelijen.setHasilPelaksanaanKeterangan(request.getHasilPelaksanaanKeterangan());
		kegiatanIntelijen.setNomorKertasKerja(request.getNomorKertasKerja());
		kegiatanIntelijen.setTanggalKertasKerja(request.getTanggalKertasKerja());
		kegiatanIntelijen.setKeterangan(request.getKeterangan());
		kegiatanIntelijen.setUrlFile(request.getUrlFile());
		
		repository.save(kegiatanIntelijen);
		log.info("✔️ Successfully updated!!! ദ്ദി(ᵔᗜᵔ) Register Kegiatan Intelijen Pamstra!!!");
	}

	@Override
	@Transactional
	public Page<RegisterKegiatanIntelijenPamstra> findAll(String start, String end, Integer pages, Integer sizes) {	
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
		} catch (ParseException e) {
			log.error("💀 " + e.getMessage());
		}
		
		Pageable pageRequest = PageRequest.of(pages, sizes);
		Page<RegisterKegiatanIntelijenPamstra> pagesKegiatanIntelijen = repository.findAllKegiatan(
				startDate, endDate, pageRequest);
		
		return pagesKegiatanIntelijen;
	}

	@Override
	@Transactional
	public Page<RegisterKegiatanIntelijenPamstra> findBySearching(String start, String end, String value, Integer pages,
			Integer sizes) {
		
		log.info("🔎 Value for searching: " + value);
		if (value.isBlank() || value.isEmpty() || value.equals("")) {
			log.warn("💀 Isi text pencarian kosong...");
			return null;
		}
		
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		
		Pageable pageRequest = PageRequest.of(pages, sizes);
		Page<RegisterKegiatanIntelijenPamstra> pageKegiatan = repository.findBySearching(
				startDate, endDate, value, pageRequest);
		
		return pageKegiatan;
	}

	@Override
	@Transactional
	public RegisterKegiatanIntelijenPamstraResponse findByIds(String ids) {
		RegisterKegiatanIntelijenPamstra kegiatanIntelijen = repository.findByIdsAndDeletedFalse(ids)
				.orElseThrow(() -> new NotFoundException("ID_NOT_FOUND"));
		
		RegisterKegiatanIntelijenPamstraResponse response = new RegisterKegiatanIntelijenPamstraResponse();
		response.setIds(kegiatanIntelijen.getIds());
		response.setSektor(kegiatanIntelijen.getSektor());
		response.setNamaKegiatan(kegiatanIntelijen.getNamaKegiatan());
		response.setSumberDana(kegiatanIntelijen.getSumberDana());
		response.setInstansi(kegiatanIntelijen.getInstansi());
		response.setPaguAnggaran(kegiatanIntelijen.getPaguAnggaran());
		response.setNomorSuratPermohonan(kegiatanIntelijen.getNomorSuratPermohonan());
		response.setTanggalSuratPermohonan(kegiatanIntelijen.getTanggalSuratPermohonan());
		response.setTempatPemaparan(kegiatanIntelijen.getTempatPemaparan());
		response.setTanggalPemaparan(kegiatanIntelijen.getTanggalPemaparan());
		response.setTelaahanIntelijen(kegiatanIntelijen.getTelaahanIntelijen());
		response.setTindakLanjut(kegiatanIntelijen.getTindakLanjut());
		response.setTindakLanjutKeterangan(kegiatanIntelijen.getTindakLanjutKeterangan());
		response.setNomorSprintWalpam(kegiatanIntelijen.getNomorSprintWalpam());
		response.setTanggalSprintWalpam(kegiatanIntelijen.getTanggalSprintWalpam());
		response.setNamaPetugasPelaksana(kegiatanIntelijen.getNamaPetugasPelaksana());
		response.setNilaiKontrak(kegiatanIntelijen.getNilaiKontrak());
		response.setHasilPelaksanaan(kegiatanIntelijen.getHasilPelaksanaan());
		response.setHasilPelaksanaanKeterangan(kegiatanIntelijen.getHasilPelaksanaanKeterangan());
		response.setNomorKertasKerja(kegiatanIntelijen.getNomorKertasKerja());
		response.setTanggalKertasKerja(kegiatanIntelijen.getTanggalKertasKerja());
		response.setKeterangan(kegiatanIntelijen.getKeterangan());
		response.setUrlFile(kegiatanIntelijen.getUrlFile());
		
		return response;
	}

	@Override
	@Transactional
	public void delete(String ids) {
		RegisterKegiatanIntelijenPamstra kegiatanIntelijen = repository.findByIdsAndDeletedFalse(ids)
				.orElseThrow(() -> new NotFoundException("ID_NOT_FOUND"));
		
		kegiatanIntelijen.setDeleted(true);
		kegiatanIntelijen.setNomorSprintWalpam(kegiatanIntelijen.getIds() + " | " + kegiatanIntelijen.getNomorSprintWalpam());
		kegiatanIntelijen.setNomorSuratPermohonan(kegiatanIntelijen.getIds() + " | " + kegiatanIntelijen.getNomorSuratPermohonan());
		kegiatanIntelijen.setNomorKertasKerja(kegiatanIntelijen.getIds() + " | " + kegiatanIntelijen.getNomorKertasKerja());
		repository.save(kegiatanIntelijen);
		log.info("✔️ Soft Delete Successfully!!! ദ്ദി(ᵔᗜᵔ) RKI Pamstra!!!");
	}

}
