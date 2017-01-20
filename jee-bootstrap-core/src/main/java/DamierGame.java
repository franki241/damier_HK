public interface DamierGame {
	
	public void play(PionCouleur color, int column) throws GameException;
	PionCouleur getCell(int column,  int row);
	int getColumnsNumber();
	int getRowsNumber();
	PionCouleur getWinner();
}
