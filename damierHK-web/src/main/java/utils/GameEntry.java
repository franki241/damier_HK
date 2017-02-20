package utils;

import java.io.Serializable;

public class GameEntry  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3898158084145353158L;
	
	private long id;
	private String winnerColor;

	public GameEntry(long i, String color){
		this.id = i;
		this.winnerColor= color;
	}
	
	public GameEntry() {}

	/**
	 * @return the winnerColor
	 */
	public String getWinnerColor() {
		return winnerColor;
	}
	/**
	 * @param winnerColor the winnerColor to set
	 */
	public void setWinnerColor(String winnerColor) {
		this.winnerColor = winnerColor;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param l the id to set
	 */
	public void setId(long l) {
		this.id = l;
	}
	
	@Override
	public String toString(){
		return "Winner color="+this.winnerColor;
	}
}
