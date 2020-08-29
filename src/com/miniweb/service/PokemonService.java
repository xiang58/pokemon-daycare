package com.miniweb.service;

import java.util.ArrayList;

import com.miniweb.bean.Pokemon;
import com.miniweb.dal.PokemonDAO;

public class PokemonService {

	private static PokemonDAO dao;
	
	public PokemonService() {
		dao = new PokemonDAO();
	}
	
	//------------------------------------------
	
	public Pokemon insert(Pokemon pkm) {
		return dao.insert(pkm);
	}
	
	public Pokemon update(Pokemon pkm) {
		return dao.update(pkm);
	}
	
	public Pokemon getById(int id) {
		return dao.getById(id);
	}
	
	public ArrayList<Pokemon> getAllBy(String category, String input) {
		return dao.getAllBy(category, input);
	}
	
}
