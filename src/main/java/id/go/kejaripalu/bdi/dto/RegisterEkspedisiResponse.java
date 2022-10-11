package id.go.kejaripalu.bdi.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import id.go.kejaripalu.bdi.domain.JenisSurat;
import lombok.Data;

@Data
public class RegisterEkspedisiResponse {
	
	private String id;
	
	private String nomorSurat;

    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date tanggalSurat;
    
    private String kepada;
    
    private String perihal;
    
    private String lampiran;
    
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date tanggalTandaTerima;
    
    @JsonFormat(pattern="HH:mm", timezone="GMT+8")
	private Date jamTandaTerima;
	
	private String namaDanParaf;
	
	private String keterangan;
	
	private String urlFile;
	
	private JenisSurat jenisSurat;

}
