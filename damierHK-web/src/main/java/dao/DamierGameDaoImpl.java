package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.sql.PreparedStatement;
import java.sql.Connection;

import utils.GameEntry;
import static dao.DAOUtilitaire.*;

public class DamierGameDaoImpl implements DamierGameDao {
	private DAOFactory daoFactory; 
	private static final String SQL_SELECT= "SELECT id, winningColor FROM GameEntry ORDER BY id ";
	private static final String SQL_SELECT_BY_ID= "SELECT id, winningColor FROM GameEntry WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO GameEntry (id,winningColor) VALUES (?, ?)";
	private static final String ID_GAME = "id";
	private static final String WINNER_COLOR = "winnerColor";
			
	DamierGameDaoImpl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	}
	
	/* Impl�mentation de la m�thode d�finie dans l'interface DamierGameDao */
    @Override
    public GameEntry findById(long id ) throws DAOException {
        return findById( SQL_SELECT_BY_ID, id );
    }

	public void insertGameEntry(GameEntry game) throws  IllegalArgumentException, DAOException {
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet result = null;
		    try {
		        /* R�cup�ration d'une connexion depuis la Factory */
		        connexion = (Connection) daoFactory.getConnection();
		        preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, game.getId(),  game.getWinnerColor() );
		        int statut = preparedStatement.executeUpdate();
		        /* Analyse du statut retourn� par la requ�te d'insertion */
		        if ( statut == 0 ) {
		            throw new DAOException( "�chec de la cr�ation de jeu, aucune ligne ajout�e dans la table." );
		        }
		        /* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
		        result = preparedStatement.getGeneratedKeys();
		        if ( result.next() ) {
		            /* Puis initialisation de la propri�t� id du bean GameEntry avec sa valeur */
		            game.setId( result.getLong( 1 ) );
		        } else {
		            throw new DAOException( "�chec de la cr�ation de jeu en base, aucun ID auto-g�n�r� retourn�." );
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        fermeturesSilencieuses( result, preparedStatement, connexion );
		    }
		}
	
	public GameEntry insertGameEntry(HttpServletRequest request) throws  IllegalArgumentException, DAOException {
	    String id = request.getParameter(ID_GAME);
	    String winnerColor = request.getParameter(WINNER_COLOR);
	    
	    GameEntry game = new GameEntry();
	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        DamierGameDao.insertGameEntry(game);
	    }catch(DAOException e){
	    	e.printStackTrace();
	    }
	    return game;
	}	
	private GameEntry findById( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        GameEntry game = null;

        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            /*
             * Pr�paration de la requ�te avec les objets pass�s en arguments
             * (ici, uniquement un id) et ex�cution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de donn�es retourn�e dans le ResultSet */
            if ( resultSet.next() ) {
                game = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return game;
    }
	public List<GameEntry> list() throws DAOException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<GameEntry> games = new ArrayList<GameEntry>();
		try {
			connection = daoFactory.getConnection();
		    preparedStatement = connection.prepareStatement(SQL_SELECT);
		    resultSet = preparedStatement.executeQuery();
		    while ( resultSet.next() ) {
		    	games.add( map( resultSet ) );
		        }
		} catch (SQLException e) {throw new DAOException(e);
		        } finally {
		            fermeturesSilencieuses( resultSet, preparedStatement, connection );
		        }

		return games;
		}
	/*
	 * Simple m�thode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des jeux (un
	 * ResultSet) et un bean GameEntry.
	 */
	private static GameEntry map( ResultSet resultSet ) throws SQLException {
		GameEntry game = new GameEntry();
		game.setId( resultSet.getLong( "id" ) );
		game.setWinnerColor(resultSet.getString( "winnerColor" ) );
	   
	    return game;
	}
}
