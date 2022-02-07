package spring.boot.microservices.category.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(Object id) {
		super("Not found id: " + id);
	}

	
}
