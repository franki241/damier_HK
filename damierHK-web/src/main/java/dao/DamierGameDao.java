package dao;

import java.util.List;

import utils.GameEntry;

public interface DamierGameDao {

	static void insertGameEntry(GameEntry game) throws DAOException {}
	GameEntry findById(long id)  throws DAOException;
	List<GameEntry> list() throws DAOException;
}
