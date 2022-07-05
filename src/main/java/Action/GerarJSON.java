package Action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

import Dao.LocalDAO;
import Modelo.Local;
import Util.JPAUtil;

@WebServlet("/GerarJSON")
public class GerarJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long id = (Long) request.getAttribute("id");
		EntityManager em = JPAUtil.getEntityManager();
		LocalDAO DAO = new LocalDAO(em);
		Local local = DAO.pesquisar(id);
		String cidade = local.getCidade();
		int temperatura = local.getTemperatura();
		
		JSONObject my_obj = new JSONObject();
		my_obj.put("Cidade", cidade);
		my_obj.put("Temperatura", temperatura);
		String json = my_obj.toString();

		
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

}
