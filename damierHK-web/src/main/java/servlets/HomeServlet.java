package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.DAOFactory;
import dao.DamierGameDao;

@WebServlet(name = "HomeServlet", urlPatterns = {"/damierHK-web"})
public class HomeServlet extends HttpServlet{

	private static final long serialVersionUID = -238839261935542776L;
		public static final String CONF_DAO_FACTORY = "daofactory";
	    public static final String VUE              = "/jsp/websource.jsp";

	    private DamierGameDao damierDao;

	    public void init() throws ServletException {
	        /* Récupération d'une instance de notre DAO damier  game */
	        this.damierDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY )).getDamierGameDao();
	    }

	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	    			doPost(request, response);
	    	/* Affichage de la page du damier */
	        //this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	    	//response.sendRedirect(request.getContextPath()+ VUE);
	    			request.getRequestDispatcher("/jsp/websource.jsp").forward(request, response);
	    }
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	          
		 try{
				damierDao.insertGameEntry(request);
			} catch(DAOException e){
				e.printStackTrace();
			}
	            /* Traitement de la requête et récupération du bean en résultant */
	            //DamierGameDaoImpl game = insertGameEntry( request );

	            /* Stockage du bean dans l'objet request */
	            //request.setAttribute( ATT, game );
	            //this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	    }
}

