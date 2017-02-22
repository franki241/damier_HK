package utils;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "GAME_ENTRY")
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
	@Column(name = "WINNER_COLOR", nullable = false, length = 45)
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
	@Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue
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
