import java.io.IOException;

import ui.UI;


public class App {
	
	 public static void main(String[] args) {
	    	UI view  = new UI();

	        try {
	            view.run();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
