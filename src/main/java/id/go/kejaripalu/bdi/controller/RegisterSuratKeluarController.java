package id.go.kejaripalu.bdi.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.go.kejaripalu.bdi.domain.RegisterSuratKeluar;
import id.go.kejaripalu.bdi.dto.RegisterSuratKeluarCreateRequest;
import id.go.kejaripalu.bdi.dto.RegisterSuratKeluarResponse;
import id.go.kejaripalu.bdi.dto.RegisterSuratKeluarUpdateRequest;
import id.go.kejaripalu.bdi.service.RegisterSuratKeluarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("${app.api-url}")
@CrossOrigin("${app.origin-url}")
public class RegisterSuratKeluarController {
	
	private final RegisterSuratKeluarService suratKeluarService;
	
	@GetMapping("/surat-keluar")
	public ResponseEntity<Page<RegisterSuratKeluar>> findSuratKeluar(
			@RequestParam(required = true, defaultValue = "0") Integer pages,
			@RequestParam(required = true, defaultValue = "20") Integer sizes,
			@RequestParam(required = true, defaultValue = "BIASA") String jenisSurat,
			@RequestParam(required = true) String startDate,
			@RequestParam(required = true) String endDate) {
		return ResponseEntity.ok().body(suratKeluarService.findSuratMasuk(startDate, endDate, jenisSurat, pages, sizes));
	}
	
	@PostMapping("/surat-keluar")
	public ResponseEntity<Void> createNewSuratKeluar(@Valid @RequestBody RegisterSuratKeluarCreateRequest request) {
		suratKeluarService.createSuratMasuk(request);
		return ResponseEntity.created(URI.create("/api/v1/surat-keluar")).build();
	}
	
	@GetMapping("/surat-keluar/{ids}/detail")
	public ResponseEntity<RegisterSuratKeluarResponse> findSuratKeluarByIds(@PathVariable String ids) {
		return ResponseEntity.ok().body(suratKeluarService.findSuratMasukByIds(ids));
	}
	
	@PutMapping("/surat-keluar/{ids}")
	public ResponseEntity<Void> updateSuratKeluar(@PathVariable String ids,
			@RequestBody @Valid RegisterSuratKeluarUpdateRequest request) {
		suratKeluarService.updateSuratMasuk(ids, request);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/surat-keluar/{ids}")
	public ResponseEntity<Void> deleteSuratKeluar(@PathVariable String ids) {
		suratKeluarService.deleteSuratKeluar(ids);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/surat-keluar/search")
	public ResponseEntity<Page<RegisterSuratKeluar>> findSuratKeluarBySearch(
			@RequestParam(required = true, defaultValue = "0") Integer pages,
			@RequestParam(required = true, defaultValue = "20") Integer sizes,
			@RequestParam(required = true, defaultValue = "BIASA") String jenisSurat,
			@RequestParam(required = true) String value,
			@RequestParam(required = true) String startDate,
			@RequestParam(required = true) String endDate) {
		return ResponseEntity.ok().body(suratKeluarService.findSuratKeluarBySearching(
				startDate, endDate, value, jenisSurat, pages, sizes));
	}
	
}
