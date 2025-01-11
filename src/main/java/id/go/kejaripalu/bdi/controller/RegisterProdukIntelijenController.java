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

import id.go.kejaripalu.bdi.domain.RegisterProdukIntelijen;
import id.go.kejaripalu.bdi.dto.RegisterProdukIntelijenRequest;
import id.go.kejaripalu.bdi.dto.RegisterProdukIntelijenResponse;
import id.go.kejaripalu.bdi.service.RegisterProdukIntelijenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("${app.api-url}")
@CrossOrigin("${app.origin-url}")
public class RegisterProdukIntelijenController {

    private RegisterProdukIntelijenService produkIntelijenService;

    @GetMapping("/prodin")
    public ResponseEntity<Page<RegisterProdukIntelijen>> findProdukIntelijen(
            @RequestParam(required = true, defaultValue = "0") Integer pages,
            @RequestParam(required = true, defaultValue = "20") Integer sizes,
            @RequestParam(required = true) String startDate,
            @RequestParam(required = true) String endDate) {
        return ResponseEntity.ok().body(produkIntelijenService.findProdukIntelijen(startDate, endDate, pages, sizes));
    }

    @GetMapping("/prodin/{id}/detail")
    public ResponseEntity<RegisterProdukIntelijenResponse> findProdukIntelijenById(@PathVariable String id) {
        return ResponseEntity.ok().body(produkIntelijenService.findProdukIntelijenById(id));
    }

    @GetMapping("/prodin/search")
    public ResponseEntity<Page<RegisterProdukIntelijen>> findProdukIntelijenBySearch(
            @RequestParam(required = true, defaultValue = "0") Integer pages,
            @RequestParam(required = true, defaultValue = "20") Integer sizes,
            @RequestParam(required = true) String value,
            @RequestParam(required = true) String startDate,
            @RequestParam(required = true) String endDate) {
        return ResponseEntity.ok().body(produkIntelijenService.findProdukIntelijenBySearching(
                startDate, endDate, value, pages, sizes));
    }
    
    @PostMapping("/prodin")
    public ResponseEntity<Void> createNewProdukIntelijen(@Valid @RequestBody RegisterProdukIntelijenRequest request) {
        produkIntelijenService.createProdukIntelijen(request);
        return ResponseEntity.created(URI.create("/api/v1//produk-intelijen")).build();
    }
    
    @PutMapping("/prodin/{id}")
    public ResponseEntity<Void> updateProdukIntelijen(@PathVariable String id,
                                                      @RequestBody @Valid RegisterProdukIntelijenRequest request) {
        produkIntelijenService.updateProdukIntelijen(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/prodin/{id}")
    public ResponseEntity<Void> deleteProdukIntelijen(@PathVariable String id) {
        produkIntelijenService.deleteProdukIntelijen(id);
        return ResponseEntity.accepted().build();
    }

}
