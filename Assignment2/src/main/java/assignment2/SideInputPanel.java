package assignment2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SideInputPanel extends GridPane implements EventHandler<ActionEvent> {
    private final View view;

    /**
     * Constructs a new GridPane with 2 buttons to select what side the human player wants to play as
     * @param view
     */
    public SideInputPanel(View view) {
        this.view = view;
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);

        view.setMessageLabel("Select your side");

        for (Piece.Type pieceType: Piece.Type.values()) {
            String label = pieceType.getType();

            Button button = new Button(label);
            button.setId(label); // DO NOT MODIFY ID

            // Default styles which can be modified
            button.setPrefSize(500, 100);
            button.setFont(new Font(20));
            button.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

            button.setOnAction(this);

            this.add(button, 0, this.getRowCount());
        }
    }

    /**
     * Handles click of human player side options ('MUSKETEER' or 'GUARD')
     * Calls view.setSide with the appropriate Piece.Type selected
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) { // TODO
        Button clicked = (Button)actionEvent.getSource(); //declare a variable call clicked allow feedback from the frontend to be responsive to the frontend
        String feedbackString = clicked.getText(); // declare a string called feedbackString to hold the String after an element of text is cliecked
        if(feedbackString.equals("Guard")){ // if block to check if the feedbackString is equal to "Guard", if it is, enter the if block
            view.setSide(Piece.Type.GUARD); // set the side view to PIECE.TYPE.GUARD
        }
        else{ // if the condition(s) above a re not met enter the else block
            view.setSide(Piece.Type.MUSKETEER); // set the Side in the view to Piece.Type.MUSKETEER
        }
    }
}

