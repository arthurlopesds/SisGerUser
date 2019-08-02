package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Cliente;
import br.com.service.ClienteService;

@WebServlet(urlPatterns= {"/cliente","/clienteServlet","/clienteController"})
public class ClienteServlet extends HttpServlet{
		
	ClienteService clienteService;

	
		public ClienteServlet() {
			System.out.println("Construindo Servlet");
		}
		
		@Override
		public void init() throws ServletException {
			clienteService = new ClienteService();
			System.out.println("Inicializando Servlet");
		}
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("Chamando Service");
			super.service(req, resp);
		
		}
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				String i = req.getParameter("i");
				if (i!= null & i!="") {
					clienteService.excluir(Integer.parseInt(i));
				}
			
				String status = req.getParameter("status");
				System.out.println(status);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
				req.setAttribute("lista", clienteService.getTodosclientes());
				if (status!=null) {
					req.setAttribute("listaStatus", clienteService.buscar(status));
					req.setAttribute("statusBusca", clienteService.statusBusc(status));
					
				}
				
				
		
				dispatcher.forward(req, resp);
		}
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
			
			String login = req.getParameter("login");
			String senha = req.getParameter("senha");
			String statusCad = req.getParameter("statusCad");
			System.out.println("ESSE É O STATUS:"+ statusCad);
			
			Cliente cli = new Cliente("","","");
			cli.setLogin(login);
			cli.setSenha(senha);
			cli.setStatus(statusCad);
			
			clienteService.cadastrar(cli);
				
			//BUSCA
			
			String status = req.getParameter("status");
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
			req.setAttribute("msg", "Cadastrado Realizado com Sucesso!");
			req.setAttribute("lista", clienteService.getTodosclientes());
			
		
			dispatcher.forward(req, resp);
			//resp.sendRedirect("cliente");
			
			//resp.setCharacterEncoding("UTF-8");
			//resp.getWriter().print("Chamou pelo metodo Post enviando o email " + email);
			//System.out.println("Chamou o metodo do Post");
		}
		
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().print("Chamou pelo método Delete");
		}
		
		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().print("Chamou pelo método PUT");
		}
		
		@Override
		public void destroy() {
			System.out.println("O servlet está sendo destruído..");
			super.destroy();
		}
		
		
}
