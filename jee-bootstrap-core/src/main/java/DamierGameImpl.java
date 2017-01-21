import java.util.ArrayList;
import java.util.List;

public class DamierGameImpl implements DamierGame{

	public static final int COLUMNS_NUMBER = 10;
	public static final int ROWS_NUMBER = 10;
	public static final int NUMBER_OF_CHIPS_BY_ROW = 5 ;
	public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
	
	List<List<Couleurs>> plateau = new ArrayList<>(COLUMNS_NUMBER);
	//ArrayList<Couleurs> plateau =  new ArrayList<>(COLUMNS_NUMBER);
	
	public DamierGameImpl() {
		///initPions();
    }
// initialise le plateau de jeu	
	
	/**public boolean initPlateau(){
		boolean is_plateau_init = false;
		for (int i = 0; i < COLUMNS_NUMBER; i++) {
    		for(int j = 0; j < ROWS_NUMBER; j++){
				//une case noire sur deux
    			if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
    				plateau.add(new ArrayList<Couleurs>(j).set(j, Couleurs.BLACK));
    				//plateau.get(j).set(i, PlateauCouleur.BLACK);
    				//plateau.add(PlateauCouleur.BLACK);
    				//plateau.add(new ArrayList<PlateauCouleur>().set(j, PlateauCouleur.BLACK);
                }
                else{ // une case blanche sur deux
                    /*ajouterCase(PionCouleur.WHITE);
                	plateau.add(new ArrayList<PlateauCouleur>(j));
                 	plateau.get(j).set(i, PlateauCouleur.WHITE);
                 	
                	plateau.add(new ArrayList<Couleurs>(j).set(j, Couleurs.WHITE));
                }
    		}
        }
		is_plateau_init = true;
		return is_plateau_init;
	}
   
 // itinialise les pions en plaçants 20 pions noirs en bas du plateau et 20 pions blancs en haut
    public void initPions(){
    	for(int i = 0; i<ROWS_NUMBER; i++){
    		if(i%2!=0){
    			//plateau.add(new ArrayList<Couleurs>());
    		}
    	}
     }**/
	
	@Override
	public void play(Couleurs color, int column) throws GameException {
		boolean canPlayRight = isTheRightMoveTodo(color, column);
		boolean canPlayLeft = isTheLeftMoveTodo(color, column);
		/**if(canPlayRight == true){
			   List<Couleurs> col = plateau.get(column);
			   col.add(color);
		} else if(canPlayLeft == true){
			List<Couleurs> col = plateau.get(column);
			   col.add(color);
		}**/
	}
	
/* booléen qui renvoit true si le pion à bouger 
* est noir et que la cellule suivante à droite sur la diagonale est vide
*/
	@Override
	public boolean isTheRightMoveTodo(Couleurs color, int column){
		int i = plateau.indexOf(column);
		int nextBlackRow = i - 1;
		int nexBlackColumn = column - 1;
		if((i%2 == 0 && column%2 == 0) && color.toString() == "BLACK"){
                  if(getCell(nexBlackColumn,nextBlackRow) != null){
				      column -= column;
				      i -= i;
				      i = plateau.indexOf(column);
				      plateau.add(new ArrayList<Couleurs>());
				    return true;	
			      }
	     }
	 //pas de pion noir en dehors du plateau vers la droite (en bas à gauche vu de face)
			if(nexBlackColumn < 0 ){
				throw new GameException(OUTSIDE_OF_BOARD_ERROR);
			}
		return false;
	}
	/* booléen qui renvoit true si le pion à bouger 
	* est noir et que la cellule à gauche suivante sur la diagonale est vide
	*/	
	public boolean isTheLeftMoveTodo(Couleurs color, int column){
		plateau.toString();
		int i = plateau.indexOf(column);
		int nextBlackRow = i + 1;
		int nexBlackColumn = column - 1;
			if((i%2 == 0 && column%2 == 0) && color.toString() == "BLACK"){
				 if(getCell(nexBlackColumn,nextBlackRow) != null){
				column -= column;
				i += i;
				i = plateau.indexOf(column);
				plateau.add(new ArrayList<Couleurs>());
				return true;
				 }	
			} //pas de pion noir en dehors du plateau vers la gauche (en bas à droite vu de face)
			if(nexBlackColumn > getColumnsNumber() ){
				throw new GameException(OUTSIDE_OF_BOARD_ERROR);
			}
		return false;
	}

	//retourne la couleur d'un pion s'il est dans une case

    @Override
    public Couleurs getCell(int i, int j) {
        if (i < 0 || i >= getColumnsNumber()) {
            return null;
        }
        List<Couleurs> column = plateau.get(i);
        return j < column.size() && j >= 0 ? column.get(j) : null;
}
	       // List<Couleurs> column = new ArrayList<Couleurs>();
	       /** if (j < 0 || j >= column.size()) {
	            return column.get(j) ;
	        }
	       return null;
	       **/
	
	@Override
	public int getColumnsNumber() {
	  return COLUMNS_NUMBER;
	}

	@Override
	public int getRowsNumber() {
	
		return  ROWS_NUMBER;
	}

	@Override
	public Couleurs getWinner() {
		return null;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
    int pair =0;
    for (int i = getRowsNumber() - 1; i >= 0; i--) {
        sb.append("|");
        for (int j = 0; j < getColumnsNumber(); j++) {
        	/*Les pions BLACK*/
        	Couleurs test = getCell(j, i);
        	if(i%2==0 && i<4){
        	if(pair%2==0){
        	test = Couleurs.BLACK;
        	}
        	}else if(i%2!=0 && i<4){
            	if(pair%2!=0){
                	test = Couleurs.BLACK;
                }	
        	}
        	/*Les pions WHITE*/
        	if(i%2==0 && i>5){
        	if(pair%2==0){
        	test = Couleurs.WHITE;
        	}
        	}else if(i%2!=0 && i>5){
            	if(pair%2!=0){
                	test = Couleurs.WHITE;
                }	
        	}
        	pair++;
            if (test == Couleurs.BLACK) {
                sb.append("O");
            }else if (test == Couleurs.WHITE) {//}else if (getCell(j, i) == PionCouleur.WHITE) { 
                sb.append("X");
            } else {
                sb.append(" ");
            }
            sb.append("|");
        }
        sb.append("\n");
    }
    for (int i = 0; i < getRowsNumber() * 2 + 3; i++) {
        sb.append("-");
    }
    return sb.toString();
}

}
