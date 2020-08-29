package com.miniweb.controller;

import java.io.IOException;
import java.util.ArrayList;
import static java.lang.System.out;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniweb.bean.Pokemon;
import com.miniweb.service.PokemonService;

/**
 * Servlet implementation class PkmReadServlet
 */
public class PkmReadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PkmReadServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PokemonService pkmService = new PokemonService();
		String idStr = request.getParameter("id");
		
		if (idStr != null) {
			int id = Integer.parseInt(idStr);
			Pokemon pkm = pkmService.getById(id);
			HttpSession session = request.getSession();
			session.setAttribute("pkm", pkm);
			request.getRequestDispatcher("../pkmPages/update.jsp").forward(request, response);
		} 
		else {
			ArrayList<Pokemon> pokemons = new ArrayList<>();
			String category = request.getParameter("category");
			String input = request.getParameter("filter-by");
			
			if (category == null)
				pokemons = pkmService.getAllBy("", "");
			else
				pokemons = pkmService.getAllBy(category, input);
			
//			for (Pokemon pkm : pokemons)
//				out.println(pkm);
			
			HttpSession session = request.getSession();
			session.setAttribute("pokemons", pokemons);
//			request.getRequestDispatcher("../pkmPages/displayAll.jsp").forward(request, response);
//			out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath() + "/pkmPages/displayAll.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
