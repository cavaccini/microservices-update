package spring.boot.microservices.product.services.exceptions;

public class DatabaseErrorException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DatabaseErrorException(String msg) {
		super(msg);
	}
}
