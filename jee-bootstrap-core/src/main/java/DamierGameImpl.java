import java.util.ArrayList;
import java.util.List;

public class DamierGameImpl implements DamierGame{

	public static final int COLUMNS_NUMBER = 10;
	public static final int ROWS_NUMBER = 10;
	public static final int NUMBER_OF_CHIPS_BY_ROW = 5 ;
	public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
	
	List<List<PlateauCouleur>> plateau = new ArrayList<>(COLUMNS_NUMBER);
	
	public DamierGameImpl() {
// initialise le plateau de jeu
    	for (int i = 0; i < COLUMNS_NUMBER; i++) {
    		for(int j = 0; j < ROWS_NUMBER; j++){
    			//une case noire sur deux
    			if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
    				plateau.add(new ArrayList<PlateauCouleur>(j));
    				plateau.get(j).set(i, PlateauCouleur.BLACK);
    				//plateau.add(PlateauCouleur.BLACK);
    				//plateau.add(new ArrayList<PlateauCouleur>().set(j, PlateauCouleur.BLACK);
                }
                else{ // une case blanche sur deux
                    //ajouterCase(PionCouleur.WHITE);
                	plateau.add(new ArrayList<PlateauCouleur>(j));
                 	plateau.get(j).set(i, PlateauCouleur.WHITE);	
                }
    		}
        }
    //	initPions();
    }
   
 // itinialise les pions en plaçants 20 pions noirs en bas du plateau et 20 pions blancs en haut
    private void initPions(){
    	for(int i = 0; i<ROWS_NUMBER; i++){
    		if(i%2!=0){
    			//plateau.add(new ArrayList<PionCouleur>());
    		}
    	}
    }
	
	@Override
	public void play(PionCouleur color, int column) throws GameException {
		
	}

	//retourne la couleur d'un pion s'il est dans une case
	@Override
	public PionCouleur getCell(int i, int j) {
	 if (i < 0 || i >= getColumnsNumber()) {
	            return null;
	        }
	        //List<PionCouleur> column = plateau.get(i);
	//return j < column.size() && j >= 0 ? column.get(j) : null;
	return null;
	}

	@Override
	public int getColumnsNumber() {
	  return COLUMNS_NUMBER;
	}

	@Override
	public int getRowsNumber() {
	
		return  ROWS_NUMBER;
	}

	@Override
	public PionCouleur getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

}
