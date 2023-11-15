package guifx;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HiByeEventHandler implements EventHandler<ActionEvent> {

	// 1) Modify this so that it prints out which button was pressed.
	// 2) Modify this so that it sets the TextField to which button was pressed
	// Hint: this will need access to a TextField
	
	private TextField tf;

	public HiByeEventHandler(TextField tf) {
		this.tf=tf;
	}

	// EventHandler<ActionEvent> requires that we implement the method below
	@Override
	public void handle(ActionEvent event) {
		Button source=(Button)event.getSource();
		System.out.println(source);
		System.out.println(source.getText());
		tf.setText(source.getText());
	}
}
