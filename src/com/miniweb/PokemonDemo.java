package com.miniweb;

import static java.lang.System.out;
import java.util.ArrayList;

import com.miniweb.bean.Pokemon;
import com.miniweb.dal.PokemonDAO;
import com.miniweb.utils.Utils;

public class PokemonDemo {
	
	private static PokemonDAO dao = new PokemonDAO();

	public static void main(String[] args) {
		/** Test method 'insert' */
//		out.println("Testing 'insert'...");
//		Pokemon pkm = new Pokemon();
//		Utils.setAll(pkm, 12, 22, "Butterfree", "Bug", "Flying", "M", null, null);
//		Pokemon newPkm = dao.insert(pkm);
//		out.println(newPkm.getName() + " added successfully!");
		
		/** Test method 'getById' & 'update' */
//		out.println("Testing 'getById' & 'update'...");
//		Pokemon pkmToUpdate = dao.getById(4);
//		out.println("Pokemon you want to update: ");
//		out.println(pkmToUpdate);
//		Utils.setAll(pkmToUpdate, 19, 6, "Rattata", "Normal", null, "F", "Minnie", "Cute little mouse.");
//		Pokemon updatedPkm = dao.update(pkmToUpdate);
//		out.println("After update, the pokemon becomes: ");
//		out.println(updatedPkm);
		
		/** Test method 'getAllBy' */
//		out.println("Testing 'getAllBy'...");
//		ArrayList<Pokemon> pokemons = dao.getAllBy("", "");
//		for (Pokemon pkm : pokemons)
//			out.println(pkm);
		
//		out.println("Testing 'getAllBy(pokedex)'...");
//		out.println("Charmanders: ");
//		ArrayList<Pokemon> charmanders = dao.getAllBy("pokedex", "4");
//		for (Pokemon charmander : charmanders)
//			out.println(charmander);
		
//		out.println("Testing 'getAllBy(lv)'...");
//		out.println("Pokemons whose levels is 5: ");
//		ArrayList<Pokemon> pokemons = dao.getAllBy("lv", "5");
//		for (Pokemon pkm : pokemons)
//			out.println(pkm);
		
//		out.println("Testing 'getAllBy(name)'...");
//		out.println("Squirtles: ");
//		ArrayList<Pokemon> squirtles = dao.getAllBy("name", "Squirtle");
//		for (Pokemon squirtle : squirtles)
//			out.println(squirtle);
		
//		out.println("Testing 'getAllBy(type1)'...");
//		out.println("Pokemons with type1 Fire: ");
//		ArrayList<Pokemon> firePkms = dao.getAllBy("type1", "Fire");
//		for (Pokemon firePkm : firePkms)
//			out.println(firePkm);
		
//		out.println("Testing 'getAllBy(type2)'...");
//		out.println("Pokemons with type2 Poison: ");
//		ArrayList<Pokemon> poisonPkms = dao.getAllBy("type2", "Poison");
//		for (Pokemon poisonPkm : poisonPkms)
//			out.println(poisonPkm);
		
//		out.println("Testing 'getAllBy(gender)'...");
//		out.println("Female pokemons: ");
//		ArrayList<Pokemon> femalePkms = dao.getAllBy("gender", "F");
//		for (Pokemon femalePkm : femalePkms)
//			out.println(femalePkm);
		
//		out.println("Testing 'getAllBy(nickname)'...");
//		out.println("Pokemons whose nickname is Bob: ");
//		ArrayList<Pokemon> pkms = dao.getAllBy("nickname", "Bob");
//		for (Pokemon pkm : pkms)
//			out.println(pkm);
	}

}
