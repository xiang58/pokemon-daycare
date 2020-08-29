package com.miniweb.bean;

public class Pokemon {
	
	private int id;
	private int pokedex;     // 0 < pokedex < 893
	private int lv;			 // 0 < lv < 101
	private String name;
	private String type1;
	private String type2;
	private String gender;   // M, F, or ?
	private String nickname;
	private String comments;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPokedex() {
		return pokedex;
	}

	public void setPokedex(int pokedex) {
		this.pokedex = pokedex;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType1() {
		return type1;
	}
	
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	public String getType2() {
		return type2;
	}
	
	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getComments() {
		return comments;
	}
	

	public void setComments(String comments) {
		this.comments = comments;
	}
	

	@Override
	public String toString() {
		return id + "/" + pokedex + "/" + lv + "/" 
				+ name + "/" + type1 + "/" + type2 
				+ "/" + gender + "/" + nickname 
				+ "/" + comments;
	}

}
