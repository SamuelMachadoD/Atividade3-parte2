package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Acao;


@WebServlet("/principal")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "Action."+paramAcao;
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao =(Acao)classe.newInstance();
			nome = acao.executa(request, response);
		} catch (Exception e) {
			
			throw new ServletException(e);
		}
		
		String[] tipo = nome.split(":");
		if(tipo[0].equals("foward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipo[1]);
			rd.forward(request, response);
		}else if (tipo[0].equals("send")){
			request.getRequestDispatcher(tipo[1]).include(request, response);
		}else {
			response.sendRedirect(tipo[1]);
		}
	}
}
