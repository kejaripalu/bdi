package id.go.kejaripalu.bdi.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RegisterTelaahanIntelijenRequest implements Serializable {
	
	private static final long serialVersionUID = -8261098799660665667L;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date tanggal;
	
	@NotBlank
	private String nomor;

	@NotBlank
	private String pembuat;
	
	@NotBlank
	private String perihal;
	
	private String lampiran;
	
	private String tindakLanjut;
	
	private String keterangan;
	
	private String urlFile;
	
}
