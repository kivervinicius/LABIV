package helloWorld;
  
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cliente")
public class ClienteController extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<String> nomes = new ArrayList<String>();
		nomes.add("Maria");
		nomes.add("João");
		nomes.add("José");
		nomes.add("Arnaldo");
		nomes.add("Bianca");
		Collections.sort(nomes);
		
		/*LISTA DE OBJETOS*/
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente(1, "Maria", 3000.0, new Date(1999,10,2)));
		clientes.add(new Cliente(2, "João", 300.0, new Date()));
		clientes.add(new Cliente(3, "José", 1400.0, new Date()));
		clientes.add(new Cliente(4, "Arnaldo", 5000.0, new Date()));
		clientes.add(new Cliente(5, "Bianca", 2000.0, new Date()));
		
		req.setAttribute("lista", nomes);
		req.setAttribute("clientes", clientes);
		req.setAttribute("quantidade", nomes.size());
		
		RequestDispatcher view = req.getRequestDispatcher("/cliente.jsp");
		view.forward(req, resp);
		
		//http://localhost:8080/helloWorld/cliente

	}
}

