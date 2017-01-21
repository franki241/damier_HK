import static org.assertj.core.api.Assertions.assertThat;
//import static java.Couleurs.BLACK;

import org.junit.Before;
import org.junit.Test;

public class DamierGameTest {
	
	 private DamierGame game;
	 
	 @Before
	    public void doBefore() throws Exception {
	        game = new DamierGameImpl();
	    }
	 
	 @Test
	   public void itInitializedBoard() throws Exception{
		 //doit afficher le damier initial avec les 40 pions placés
		 //System.out.println(game.toString());
	 }
	 
	 @Test
	    public void aPlayerMayPlayAColumn() throws Exception {
		   game.toString();
		   game.isTheRightMoveTodo(Couleurs.BLACK, 2);
	     //assertThat(game.getCell(1, 5)).isEqualTo(Couleurs.BLACK);
	      System.out.println("Test black move :"+game.toString());
	 }
	 
}
