public interface DamierGame {
	
	public boolean initPlateau();
	public void play(Couleurs color, int column) throws GameException;
	Couleurs getCell(int column,  int row);
	int getColumnsNumber();
	int getRowsNumber();
	Couleurs getWinner();
}
