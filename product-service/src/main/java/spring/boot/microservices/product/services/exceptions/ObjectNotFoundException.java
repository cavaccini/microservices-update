package spring.boot.microservices.product.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(Object id) {
		super("Object not found. Id: "  + id);
	}
}
