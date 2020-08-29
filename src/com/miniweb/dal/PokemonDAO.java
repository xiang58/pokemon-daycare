package com.miniweb.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniweb.bean.Pokemon;
import com.miniweb.utils.DbCon;

/*
ALTER SESSION SET PLSCOPE_SETTINGS = 'IDENTIFIERS:NONE';

CREATE TABLE Pokemons (
    pkm_id NUMBER(4) PRIMARY KEY,
    pokedex NUMBER(4) NOT NULL CHECK(pokedex > 0 AND pokedex < 893),
    pkm_lv NUMBER(3) NOT NULL CHECK(pkm_lv > 0 AND pkm_lv < 101),
    pkm_name VARCHAR2(30) NOT NULL,
    pkm_type1 VARCHAR2(15) NOT NULL,
    pkm_type2 VARCHAR2(15),
    gender CHAR(1) DEFAULT '?' NOT NULL 
        CHECK(gender = 'M' OR gender = 'F' OR gender = '?'),
    nickname VARCHAR2(50),
    comments VARCHAR2(1000)
);

CREATE SEQUENCE pkm_id_seq;

CREATE OR REPLACE TRIGGER pokemons_tr
BEFORE INSERT ON Pokemons
FOR EACH ROW 
    BEGIN
        SELECT pkm_id_seq.NEXTVAL
        INTO :NEW.pkm_id FROM dual;
    END;
/

INSERT INTO Pokemons (
    pokedex, pkm_lv, pkm_name, pkm_type1, pkm_type2, gender, nickname, comments
) VALUES (
    1, 5, 'Bulbasaur', 'Grass', 'Poison', 
    'F', 'Alice', 'Green little plant?'
);

INSERT INTO Pokemons (
    pokedex, pkm_lv, pkm_name, pkm_type1, pkm_type2, gender, nickname, comments
) VALUES (
    4, 5, 'Charmander', 'Fire', NULL, 
    'M', 'Charlie', 'Feels warm.'
);

INSERT INTO Pokemons (
    pokedex, pkm_lv, pkm_name, pkm_type1, pkm_type2, gender, nickname, comments
) VALUES (
    7, 5, 'Squirtle', 'Water', NULL, 
    'M', 'Bob', 'He lieks watering Bulbasaur.'
);

COMMIT;
*/

public class PokemonDAO {
	
	private static String TABLE = "Pokemons";

	//-----------------------------------------------------------------------------------------

	public Pokemon insert(Pokemon pkm) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "INSERT INTO " + TABLE + 
					" (pokedex, pkm_lv, pkm_name, pkm_type1, "
					+ "pkm_type2, gender, nickname, comments)"
					+ " VALUES (?,?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(qry);
			setAll(st, null, pkm, 'w');
			st.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			DbCon.closeConnection();
		}
		
		return pkm;
	}
	
	//-----------------------------------------------------------------------------------------

	public Pokemon update(Pokemon pkm) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "UPDATE " + TABLE + " SET pokedex = ?,"
					+ " pkm_lv = ?, pkm_name = ?, pkm_type1 = ?,"
					+ " pkm_type2 = ?, gender = ?, nickname = ?,"
					+ " comments = ? WHERE pkm_id = ?";
			
			PreparedStatement st = con.prepareStatement(qry);
			setAll(st, null, pkm, 'w');
			st.setInt(9, pkm.getId());
			st.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			DbCon.closeConnection();
		}
		
		return pkm;
	}
	
	//-----------------------------------------------------------------------------------------

	public Pokemon getById(int id) {
		Connection con = DbCon.getConnection();
		Pokemon pkm = new Pokemon();
		
		try {
			String qry = "SELECT * FROM " + TABLE + " where pkm_id = ?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) 
				setAll(null, rs, pkm, 'r');
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			DbCon.closeConnection();
		}
		
		return pkm;
	}

	//-----------------------------------------------------------------------------------------
	
	public ArrayList<Pokemon> getAllBy(String category, String input) {
		ArrayList<Pokemon> pokemons = new ArrayList<>();
		Connection con = DbCon.getConnection();
		String qry = "SELECT * FROM " + TABLE;
		int pokedex = 0, lv = 0;
		
		switch (category) {
		case "": break;
		case "pokedex":
			pokedex = Integer.parseInt(input);
			qry += " WHERE pokedex = ?";
			break;
		case "lv":
			lv = Integer.parseInt(input);
			qry += " WHERE pkm_lv = ?";
			break;
		case "name":
			qry += " WHERE pkm_name = ?";
			break;
		case "type1":
			qry += " WHERE pkm_type1 = ?";
			break;
		case "type2":
			qry += " WHERE pkm_type2 = ?";
			break;
		case "gender":
			qry += " WHERE gender = ?";
			break;
		case "nickname":
			qry += " WHERE nickname = ?";
			break;
		default:
			throw new IllegalArgumentException("Error: invalid 'category' for 'getAllBy'");
		}
		
		try {
			PreparedStatement st = con.prepareStatement(qry);
			if (pokedex > 0)
				st.setInt(1, pokedex);
			else if (lv > 0)
				st.setInt(1, lv);
			else if (! category.equals(""))
				st.setString(1, input);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Pokemon pkm = new Pokemon();
				setAll(null, rs, pkm, 'r');
				pokemons.add(pkm);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DbCon.closeConnection();
		}
		
		return pokemons;
	}
		
	//-----------------------------------------------------------------------------------------

	private static void setAll(PreparedStatement st, ResultSet rs, Pokemon pkm, char option) 
			throws SQLException {
		if (option == 'w') {
			st.setInt(1, pkm.getPokedex());
			st.setInt(2, pkm.getLv());
			st.setString(3, pkm.getName());
			st.setString(4, pkm.getType1());
			st.setString(5, pkm.getType2());
			st.setString(6, pkm.getGender());
			st.setString(7, pkm.getNickname());
			st.setString(8, pkm.getComments());
		}
		else if (option == 'r') {
			pkm.setId(rs.getInt(1));
			pkm.setPokedex(rs.getInt(2));
			pkm.setLv(rs.getInt(3));
			pkm.setName(rs.getString(4));
			pkm.setType1(rs.getString(5));
			pkm.setType2(rs.getString(6));
			pkm.setGender(rs.getString(7));
			pkm.setNickname(rs.getString(8));
			pkm.setComments(rs.getString(9));
		}
		else throw new IllegalArgumentException("Error: invalid 'option' for 'setAll'");
	}
	
}
