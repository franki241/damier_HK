package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import utils.GameEntry;

public interface DamierGameDao {

	//static void insertGameEntry(GameEntry game) throws DAOException {}
	public GameEntry insertGameEntry(HttpServletRequest request) throws  IllegalArgumentException, DAOException;
	GameEntry findById(long id)  throws DAOException;
	List<GameEntry> list() throws DAOException;
}
