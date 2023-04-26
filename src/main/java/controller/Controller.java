package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select","/update","/delete"})

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans atleta = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/main")) {
			atletas(request, response);
		} else if (action.equals("/insert")) {
			novoAtleta(request, response);
		} else if (action.equals("/select")) {
			listarAtleta(request, response);
		} else if (action.equals("/update")) {
			editarAtleta(request, response);
		} else if (action.equals("/delete")) {
			removerAtleta(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void atletas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarAtletas();
		request.setAttribute("atletas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);

	}

	protected void novoAtleta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		atleta.setNome(request.getParameter("nome"));
		atleta.setCategoria(request.getParameter("categoria"));
		atleta.setTotal(request.getParameter("total"));

		atleta.salvar();
		System.out.println("teste1");

		response.sendRedirect("main");

	}

	protected void listarAtleta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idcon = request.getParameter("idcon");
		atleta.setIdcon(idcon);
		
		dao.selecionarAtleta(atleta);
		
		request.setAttribute("idcon", atleta.getIdcon());
		request.setAttribute("nome", atleta.getNome());
		request.setAttribute("categoria", atleta.getCategoria());
		request.setAttribute("total", atleta.getTotal());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		
	}
	
	
	protected void editarAtleta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		atleta.setIdcon(request.getParameter("idcon"));
		System.out.println(request.getParameter("idcon"));
		atleta.setNome(request.getParameter("nome"));
		atleta.setCategoria(request.getParameter("categoria"));
		atleta.setTotal(request.getParameter("total"));
		
		dao.alterarAtleta(atleta);
		
		response.sendRedirect("main");
	}
	
	
	protected void removerAtleta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idcon = request.getParameter("idcon");
		atleta.setIdcon(idcon);
		dao.deletarAtleta(atleta);
		response.sendRedirect("main");
	
	}
	
}