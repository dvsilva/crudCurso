package exception;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ServiceException extends Exception {
	private String message;
	private ServiceExceptionEnum tipo;

	public ServiceException() {

	}

	public ServiceException(String msg) {
		super(msg);
		this.message = msg;
	}

	public ServiceException(ServiceExceptionEnum tipo) {
		this.tipo = tipo;
	}

	public ServiceException(ArrayList listaErrosCurso) {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}

	public ServiceExceptionEnum getTipo() {
		return tipo;
	}

	public void setTipo(ServiceExceptionEnum tipo) {
		this.tipo = tipo;
	}

}
