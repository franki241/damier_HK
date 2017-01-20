import java.util.ArrayList;
import java.util.List;

public class DamierGameImpl implements DamierGame{

	public static final int COLUMNS_NUMBER = 10;
	public static final int ROWS_NUMBER = 10;
	public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
	
	List<List<PlateauCouleur>> plateau = new ArrayList<>(COLUMNS_NUMBER);
	
	public DamierGameImpl() {
        initBoard();
    }
//initialise le plateau de jeu
    private void initBoard() {
    	for (int i = 0; i < COLUMNS_NUMBER; i++) {
    		for(int j = 0; j < ROWS_NUMBER; j++){
    			//une case noire sur deux
    			if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
    				plateau.add(new ArrayList<PlateauCouleur>(j));
    				plateau.get(j).set(i, PlateauCouleur.BLACK);
    				//plateau.add(new ArrayList<PlateauCouleur>().set(j, PlateauCouleur.BLACK);
                }
                else{//une case blanche sur deux
                    //ajouterCase(PionCouleur.WHITE);
                	plateau.add(new ArrayList<PlateauCouleur>(j));
                 	plateau.get(j).set(i, PlateauCouleur.WHITE);	
                }
    		}
        }
    }
   
	
	@Override
	public void play(PionCouleur color, int column) throws GameException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PionCouleur getCell(int column, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnsNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowsNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PionCouleur getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

}
