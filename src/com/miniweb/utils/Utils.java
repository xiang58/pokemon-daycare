package com.miniweb.utils;

import com.miniweb.bean.Pokemon;

public class Utils {
	
	public static void setAll(Pokemon pkm, int pokedex, int lv, String name, 
			String type1, String type2, String gender, String nickname, String comments) {
		pkm.setPokedex(pokedex);
		pkm.setLv(lv);
		pkm.setName(name);
		pkm.setType1(type1);
		pkm.setType2(type2);
		pkm.setGender(gender);
		pkm.setNickname(nickname);
		pkm.setComments(comments);
	}
	
}
