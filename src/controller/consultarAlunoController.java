package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;

@WebServlet("/consultarAlunoController")
public class consultarAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public consultarAlunoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String nomeAluno = request.getParameter("nomeAluno");
		try {
			ArrayList<Aluno> alunos = new Aluno().consultarAluno(nomeAluno);
			request.setAttribute("alunos", alunos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultarAluno.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
