package id.go.kejaripalu.bdi.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 5271730151041242294L;

	public BadRequestException(String message) {
		super(message);
		log.error(message);
	}	

}
