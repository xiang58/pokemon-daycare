package com.miniweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.System.out;

import com.miniweb.bean.Pokemon;
import com.miniweb.service.PokemonService;
import com.miniweb.utils.Utils;

/**
 * Servlet implementation class PkmWriteServlet
 */
public class PkmWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PkmWriteServlet() {
        super();
    }
    
    //----------------------------------------------------------------------------------------------

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("Pokemon/List").forward(request, response);
	}

    //----------------------------------------------------------------------------------------------

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PokemonService pkmService = new PokemonService();
		Pokemon pkm = new Pokemon();
		
		int pokedex = Integer.parseInt(request.getParameter("pokedex"));
		int lv = Integer.parseInt(request.getParameter("lv"));
		String name = request.getParameter("name");
		String type1 = request.getParameter("type1");
		String type2 = request.getParameter("type2");
		String gender = request.getParameter("gender");
		String nickname = request.getParameter("nickname");
		String comments = request.getParameter("comments");
		String action = request.getParameter("action");

//		out.println(pkmName);
//		out.println(nickname);
//		out.println(sex);
//		out.println(pkmType);			
				
		if (action.equals("add")) {
			Utils.setAll(pkm, pokedex, lv, name, type1, type2, gender, nickname, comments);
			out.println(pkmService.insert(pkm).getName() + " has been added to database.");
		}
		else {
			int id = Integer.parseInt(request.getParameter("pkm-id"));
			pkm.setId(id);
			Utils.setAll(pkm, pokedex, lv, name, type1, type2, gender, nickname, comments);
			out.println("Pokemon: " + pkmService.update(pkm).getName());
			out.println("has been updated.");
		}
		
		request.getRequestDispatcher("Pokemon/List").forward(request, response);
	}

}
