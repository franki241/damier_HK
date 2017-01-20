package test;

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
		// game.init();
		 System.out.println(game);
	 }
	 
}