package Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.Service;

public interface Acao {
	String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception;
}
