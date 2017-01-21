public interface DamierGame {
	
	public void play(Couleurs color, int column) throws GameException;
	Couleurs getCell(int column,  int row);
	int getColumnsNumber();
	int getRowsNumber();
	Couleurs getWinner();
	 String toString();
	boolean isTheRightMoveTodo(Couleurs color, int column);
}
