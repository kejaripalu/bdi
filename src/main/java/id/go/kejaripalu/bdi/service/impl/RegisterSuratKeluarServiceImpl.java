package id.go.kejaripalu.bdi.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.go.kejaripalu.bdi.domain.JenisSurat;
import id.go.kejaripalu.bdi.domain.RegisterSuratKeluar;
import id.go.kejaripalu.bdi.dto.RegisterSuratKeluarCreateRequest;
import id.go.kejaripalu.bdi.repository.RegisterSuratKeluarRepository;
import id.go.kejaripalu.bdi.service.RegisterSuratKeluarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class RegisterSuratKeluarServiceImpl implements RegisterSuratKeluarService {
	
	private RegisterSuratKeluarRepository suratKeluarRepository;

	@Override
	@Transactional
	public Page<RegisterSuratKeluar> findSuratMasuk(String startDate, String endDate, String stringJenisSurat,
			Integer pages, Integer sizes) {
		JenisSurat jenisSurat = JenisSurat.BIASA;
		if (stringJenisSurat.equals("R")) {
			jenisSurat = JenisSurat.RAHASIA;
		}
		
		Date start = null;
		Date end = null;
		try {
			start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		Pageable pageRequest = PageRequest.of(pages, sizes);
		Page<RegisterSuratKeluar> pageSuratKeluar = suratKeluarRepository.findSuratKeluar(start, end, jenisSurat, pageRequest);
		return pageSuratKeluar;
	}

	@Override
	public void createSuratMasuk(RegisterSuratKeluarCreateRequest request) {
		RegisterSuratKeluar suratKeluar = new RegisterSuratKeluar();
		suratKeluar.setTanggalSurat(request.getTanggalSurat());
		suratKeluar.setNomorSurat(request.getNomorSurat());
		suratKeluar.setKepada(request.getKepada());
		suratKeluar.setPerihal(request.getPerihal());
		suratKeluar.setLampiran(request.getLampiran());
		suratKeluar.setKeterangan(request.getKeterangan());
		suratKeluar.setJenisSurat(request.getJenisSurat());
		
		log.info("Surat Keluar Request: " + suratKeluar);
		suratKeluarRepository.save(suratKeluar);
		log.info("Saved Surat Keluar: " + suratKeluar);
	}

}
