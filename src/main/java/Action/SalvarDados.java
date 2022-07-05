package Action;



import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.Service;
import org.hibernate.service.spi.InjectService;

import Dao.LocalDAO;
import Modelo.Local;
import Util.JPAUtil;

public class SalvarDados implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		EntityManager em = JPAUtil.getEntityManager();
		LocalDAO DAO = new LocalDAO(em);
		
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		Local local = new Local(estado, cidade);
		
		
		
		em.getTransaction().begin();
		DAO.cadastrar(local);
		em.getTransaction().commit();
		em.close();
		Long id = local.getId();
		request.setAttribute("id", id);
		return "send:GerarJSON";
	}

}
