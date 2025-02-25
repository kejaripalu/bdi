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

import id.go.kejaripalu.bdi.domain.RegisterKegiatanIntelijenPamstra;
import id.go.kejaripalu.bdi.dto.RegisterKegiatanIntelijenPamstraRequest;
import id.go.kejaripalu.bdi.dto.RegisterKegiatanIntelijenPamstraResponse;
import id.go.kejaripalu.bdi.service.RegisterKegiatanIntelijenPamstraService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("${app.api-url}")
@CrossOrigin("${app.origin-url}")
public class RegisterKegiatanIntelijenPamstraController {

	private final RegisterKegiatanIntelijenPamstraService kegiatanIntelijenService;
	
	@PostMapping("/kegiatan-pamstra")
	public ResponseEntity<Void> create(
			@Valid @RequestBody RegisterKegiatanIntelijenPamstraRequest request) {
		kegiatanIntelijenService.create(request);
		return ResponseEntity.created(URI.create("/api/v1/kegiatan-pamstra")).build();
	}
	
	@PutMapping("/kegiatan-pamstra/{ids}")
	public ResponseEntity<Void> update(
			@PathVariable String ids,
			@Valid @RequestBody RegisterKegiatanIntelijenPamstraRequest request) {
		kegiatanIntelijenService.update(ids, request);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/kegiatan-pamstra/{ids}/detail")
	public ResponseEntity<RegisterKegiatanIntelijenPamstraResponse> findById(@PathVariable String ids) {
		return ResponseEntity.ok().body(kegiatanIntelijenService.findByIds(ids));
	}

	@GetMapping("/kegiatan-pamstra")
	public ResponseEntity<Page<RegisterKegiatanIntelijenPamstra>> findAll(
			@RequestParam(required = true, defaultValue = "0") Integer pages,
			@RequestParam(required = true, defaultValue = "20") Integer sizes,
			@RequestParam(required = true) String startDate,
			@RequestParam(required = true) String endDate) {
		return ResponseEntity.ok().body(kegiatanIntelijenService.findAll(startDate, endDate, pages, sizes));
	}
	
	@GetMapping("/kegiatan-pamstra/search")
	public ResponseEntity<Page<RegisterKegiatanIntelijenPamstra>> findBySearch(
			@RequestParam(required = true, defaultValue = "0") Integer pages,
			@RequestParam(required = true, defaultValue = "20") Integer sizes,
			@RequestParam(required = true) String value,
			@RequestParam(required = true) String startDate,
			@RequestParam(required = true) String endDate) {
		return ResponseEntity.ok().body(kegiatanIntelijenService.findBySearching(
				startDate, endDate, value, pages, sizes));
	}
	
	@DeleteMapping("/kegiatan-pamstra/{ids}")
	public ResponseEntity<Void> delete(@PathVariable String ids) {
		kegiatanIntelijenService.delete(ids);
		return ResponseEntity.accepted().build();
	}
	
}
