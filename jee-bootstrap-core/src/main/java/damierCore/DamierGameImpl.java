package damierCore;

import java.util.ArrayList;
import java.util.List;

public class DamierGameImpl implements DamierGame {

	public static final int COLUMNS_NUMBER = 10;
	public static final int ROWS_NUMBER = 10;
	public static final int NUMBER_OF_CHIPS_BY_ROW = 5;
	public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";

	List<List<Couleurs>> plateau = new ArrayList<>(COLUMNS_NUMBER);

	public DamierGameImpl() {
		initPions();
	}
	
	// itinialise les pions en plaçants 20 pions noirs en bas du plateau et 20 pions blancs 
	private void initPions() {
		for (int i = 0; i < COLUMNS_NUMBER; i++) {
			ArrayList<Couleurs> row = new ArrayList<>();
			plateau.add(row);
			for (int j = 0; j < ROWS_NUMBER; j++) {
				if (( (j%2 == 0 && i%2 != 0) || (j%2 != 0 && i % 2 == 0)) && j<4){
					row.add(Couleurs.BLACK);
				} else if ( ((j%2 == 0 && i%2 != 0)|| (j%2 != 0 && i%2 == 0)) && j>5) {
					row.add(Couleurs.WHITE);
				 } else {
					row.add(null);
				 }	
			}
		}
	}
	
	/* booléen 
	 *  renvoie true si le pion est déplacé 
	 */
	@Override
	public boolean play(int column, int row, int move_column, int move_row) throws GameException {
		Couleurs color = getCell(column, row);
		ArrayList<Couleurs> empty_row = new ArrayList<>();
		empty_row.add(null);
			if (getCell(move_column, move_row) == null) {
		        plateau.set(row,empty_row);
				plateau.get(move_row).set(move_row, color);
				 //set(row, null);
//              remove(current_column);
//				ArrayList<Couleurs> row = new ArrayList<>();
//				plateau.add(row);
//				row.add(color);
				return true;
			}
//si case non vide
		  if (getCell(move_column, move_row) != null) {
			  throw new GameException(OUTSIDE_OF_BOARD_ERROR);
		
		   }
	      return false;
	}
// retourne la couleur d'un pion s'il est dans une case

	@Override
	public Couleurs getCell(int i, int j) {
		if (i < 0 || i >= getColumnsNumber()) {
			return null;
		}
		List<Couleurs> column = plateau.get(j);
		return column.get(i);
	}

	@Override
	public int getColumnsNumber() {
		return COLUMNS_NUMBER;
	}

	@Override
	public int getRowsNumber() {
		return ROWS_NUMBER;
	}

	@Override
	public Couleurs getWinner() {
		return null;
	}

//affiche le damier
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<ROWS_NUMBER;i++) {
			for(int j=0;j<COLUMNS_NUMBER;j++) {
				if(Couleurs.WHITE.equals(getCell(i,j))) {
					sb.append("W");
				} else if(Couleurs.BLACK.equals(getCell(i,j))) {
					sb.append("B");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
