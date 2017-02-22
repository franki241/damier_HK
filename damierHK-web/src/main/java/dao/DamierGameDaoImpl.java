package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	//private static final String SQL_INSERT = "INSERT INTO GameEntry (id,winningColor) VALUES (?, ?)";
	private static final String SQL_INSERT = "INSERT INTO GameEntry VALUES (?, ?)";
	private static final String ID_GAME = "id";
	private static final String WINNER_COLOR = "winnerColor";
			
	DamierGameDaoImpl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	}
	
	/* Implémentation de la méthode définie dans l'interface DamierGameDao */
    @Override
    public GameEntry findById(long id ) throws DAOException {
        return findById( SQL_SELECT_BY_ID, id );
    }

	/**public void insertGameEntry(GameEntry game) throws  IllegalArgumentException, DAOException {
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet result = null;
		    try {
		        /* Récupération d'une connexion depuis la Factory 
		        connexion = (Connection) daoFactory.getConnection();
		        //preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, game.getId(),  game.getWinnerColor() );
		        preparedStatement = connexion.prepareStatement(SQL_INSERT, new String[] {ID_GAME});
		        String winnerColor = request.getParameter(PARAM_WINNER_COLOR);
		    	//Long id = Long.parseLong(idGame); 
		        preparedStatement.setInt(1, winnerColor);
		        int statut = preparedStatement.executeUpdate();
		        /* Analyse du statut retourné par la requête d'insertion 
		        if ( statut == 0 ) {
		            throw new DAOException( "Echec de la création de jeu, aucune ligne ajoutée dans la table." );
		        }
		        /* Récupération de l'id auto-généré par la requête d'insertion 
		        result = preparedStatement.getGeneratedKeys();
		        if ( result.next() ) {
		            /* Puis initialisation de la propriété id du bean GameEntry avec sa valeur 
		            game.setId( result.getLong( 1 ) );
		            game.setWinnerColor(result.getString(2));
		            connexion.commit();
		        } else {
		            throw new DAOException( "Echec de la création de jeu en base, aucun ID auto-généré retourn�." );
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        fermeturesSilencieuses( result, preparedStatement, connexion );
		    }
		}
	 * @return **/
	
	public GameEntry insertGameEntry(HttpServletRequest request) throws  IllegalArgumentException, DAOException {
		 Connection connexion = null;
		 PreparedStatement preparedStatement = null;
		 ResultSet result = null;
		 GameEntry game = new GameEntry();
		/*Récupération de l'id et de la couleur gagnante dans l'url*/   
		 if (request.getParameter(ID_GAME) != null && request.getParameter(WINNER_COLOR) != null){
			 String id = request.getParameter(ID_GAME);
			 String winnerColor = request.getParameter(WINNER_COLOR);
			 /*Création d'une nouvelle instance de l'entité GameEntry et set des valeurs*/
			 Long idGame = Long.parseLong(id);
			 game.setId(idGame);
			 game.setWinnerColor(winnerColor);
			 //GameEntry game = new GameEntry(idGame, winnerColor);
			 try {
			        /* Récupération d'une connexion depuis la Factory */
			    	connexion = (Connection) daoFactory.getConnection();
			        preparedStatement = connexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			        preparedStatement.setString(2, winnerColor);
			        int statut = preparedStatement.executeUpdate();
			        /* Analyse du statut retourné par la requête d'insertion */
			        if ( statut == 0 ) {
			            throw new DAOException( "Echec de la création de jeu, aucune ligne ajoutée dans la table." );
			        }
			        /* Récupération de l'id auto-généré par la requête d'insertion */
			        result = preparedStatement.getGeneratedKeys();
			        if ( result.next() ) {
			            /* Puis initialisation de la propriété id du bean GameEntry avec sa valeur */
			            game.setId( result.getLong( 1 ) );
			            //game.setWinnerColor(result.getString(2));
			           
			        } else {
			            throw new DAOException( "Echec de la création de jeu en base, aucun ID auto-généré retourné." );
			        }
			       // connexion.commit();
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			        fermeturesSilencieuses( result, preparedStatement, connexion );
			    }
			    /*
			    }catch(DAOException e){
			    	e.printStackTrace();
			    	return game;
			    */ 
			}
		return game;		 
	}	
	private GameEntry findById( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        GameEntry game = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
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
	 * Simple méthode utilitaire permettant de faire la correspondance (le
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
