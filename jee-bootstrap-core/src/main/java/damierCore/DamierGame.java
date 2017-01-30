package damierCore;

public interface DamierGame {
	
	Couleurs getCell(int column,  int row);
	int getColumnsNumber();
	int getRowsNumber();
	Couleurs getWinner();
	String toString();
	boolean play(int column, int row, int move_colum, int move_row)throws GameException;
}
