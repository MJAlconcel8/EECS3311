package assignment2;

import javafx.animation.PauseTransition;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class View {

    ThreeMusketeers model;
    Stage stage;
    BorderPane borderPane;

    ThreeMusketeers.GameMode gameMode;

    Label messageLabel = new Label("");
    Label gameModeLabel = new Label("");
    BoardPanel boardPanel;
    Button undoButton, saveButton, restartButton;
    TextField saveFileNameTextField;
    Label saveFileErrorLabel;

    // must use these strings to update saveFileErrorLabel when saving a board
    static String saveFileSuccess = "Saved board";
    static String saveFileExistsError = "Error: File already exists";
    static String saveFileNotTxtError = "Error: File must end with .txt";

    public View(ThreeMusketeers model, Stage stage) {
        this.model = model;
        this.stage = stage;
        initUI();
    }

    /**
     * Initializes the UI and shows the main menu
     *
     * Contains default alignment and styles which can be modified
     */
    private void initUI() {
        borderPane = new BorderPane();

        // DO NOT MODIFY IDs
        borderPane.setId("BorderPane");  // DO NOT MODIFY ID
        gameModeLabel.setId("GameModeLabel");  // DO NOT MODIFY ID
        messageLabel.setId("MessageLabel"); // DO NOT MODIFY ID

        var threeMusketeersLabel = new Label("Three Musketeers");

        // Default styles which can be modified

        borderPane.setStyle("-fx-background-color: #121212;");

        threeMusketeersLabel.setFont(new Font(30));
        threeMusketeersLabel.setStyle("-fx-text-fill: #e8e6e3");

        gameModeLabel.setText("");
        gameModeLabel.setFont(new Font(20));
        gameModeLabel.setStyle("-fx-text-fill: #e8e6e3");

        messageLabel.setFont(new Font(20));
        messageLabel.setStyle("-fx-text-fill: #e8e6e3");

        VBox labels = new VBox(threeMusketeersLabel, gameModeLabel);
        labels.setAlignment(Pos.TOP_CENTER);
        borderPane.setTop(labels);

        showMainMenu();

        var scene = new Scene(borderPane, 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Updates the view to show the Main menu
     */
    private void showMainMenu(){
        ModeInputPanel modeInputPanel = new ModeInputPanel(this);

        VBox vBox = new VBox(20, messageLabel, modeInputPanel);
        vBox.setAlignment(Pos.CENTER);

        borderPane.setCenter(vBox);
        borderPane.setBottom(null);
    }

    /**
     * Updates the view to show the BoardPanel and game controls
     */
    private void showBoard() {
        boardPanel = new BoardPanel(this, model.getBoard());
        undoButton = new Button("Undo move");
        undoButton.setId("UndoButton");   // DO NOT MODIFY ID
        undoButton.setPrefSize(150, 50);
        undoButton.setFont(new Font(12));
        undoButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
        undoButton.setOnAction(e -> undo());
        setUndoButton();

        saveButton = new Button("Save board");
        saveButton.setId("SaveButton");  // DO NOT MODIFY ID
        saveButton.setPrefSize(150, 50);
        saveButton.setFont(new Font(12));
        saveButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
        saveButton.setOnAction(e -> saveBoard());

        String boardName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".txt";
        saveFileNameTextField = new TextField(boardName);
        saveFileNameTextField.setId("SaveFileNameTextField");  // DO NOT MODIFY ID
        saveFileNameTextField.setStyle("-fx-background-color: #181a1b; -fx-text-fill: white;");

        saveFileErrorLabel = new Label("");
        saveFileErrorLabel.setId("SaveFileErrorLabel");  // DO NOT MODIFY ID
        saveFileErrorLabel.setStyle("-fx-text-fill: #e8e6e3;");

        restartButton = new Button("New game");
        restartButton.setId("RestartButton");  // DO NOT MODIFY ID
        restartButton.setPrefSize(150, 50);
        restartButton.setFont(new Font(12));
        restartButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
        restartButton.setOnAction(e -> restart());

        GridPane controls = new GridPane();
        controls.addRow(0, undoButton, restartButton);
        controls.addRow(1, saveFileNameTextField, saveButton);
        controls.add(saveFileErrorLabel, 0, 2, 2, 1);
        controls.setHgap(20);
        controls.setVgap(20);
        controls.setAlignment(Pos.BOTTOM_CENTER);
        GridPane.setHalignment(saveFileErrorLabel, HPos.CENTER);

        VBox vBox = new VBox(20, messageLabel, boardPanel, controls);
        vBox.setAlignment(Pos.CENTER);
        borderPane.setCenter(vBox);
        if (!(model.getCurrentAgent() instanceof HumanAgent)) {
            runMove();
        } else {
            messageLabel.setText(String.format("[%s turn] Select a piece", model.getBoard().getTurn().getType()));
        }
    }

    /**
     * Updates the messageLabel to the given String
     * @param messageLabel String to use for the text of the messageLabel
     */
    protected void setMessageLabel(String messageLabel) {
        this.messageLabel.setText(messageLabel);
    }

    /**
     * Handles running a move for both Human and Computer agents.
     * messageLabel must always contain 'MUSKETEER' or 'GUARD'.
     * Updates the view after performing the move. The board can be updated by calling BoardPanel.updateCells.
     * Checks if the game is over and updates the view accordingly.
     * On game over, messageLabel must contain the winner ('MUSKETEER' or 'GUARD') and all Cells must be disabled.
     *
     * All Cells and Buttons must be disabled while a computer moves.
     */
    protected void runMove() { // TODO
        if (gameMode==ThreeMusketeers.GameMode.HumanRandom||gameMode==ThreeMusketeers.GameMode.HumanGreedy) { // if the game mode is Human Random or Human Greedy enter the if block
            Agent currentAgent = this.model.getCurrentAgent(); // get the current Agent and assign it to currentAgent
            this.model.move(currentAgent);
            if (this.boardPanel!=null) { // if the board panel is not null enter the if block
                this.boardPanel.updateCells(); // update the boardPanel using the updateCells method
            }
            if(this.undoButton!=null){ // if the undo button in the view class is not null
                this.undoButton.setDisable(true); // disable the undo Button
            }
            if(this.restartButton!=null){ // if the restart button in the view class is not null
                this.restartButton.setDisable(true); // disable the restart button
            }
            if(this.saveButton!=null){ // if the save button in the view class is not null
                this.saveButton.setDisable(true); // disable the save button
            }
            setMessageLabel(String.format("%s's to turn to select a piece", model.getBoard().getTurn().getType())); // updates the message label
        }
        else if (gameMode==ThreeMusketeers.GameMode.Human){ // if the game mode is human mode enter the if block
            if (this.boardPanel!=null) { // if the boardPannel is not null enter the if block
                setMessageLabel(String.format("%s's to turn to select a piece", model.getBoard().getTurn().getType())); // updates the message label
                this.boardPanel.updateCells();
            }
        }
    }




    /**
     *  Enables or disables the undo button depending on if there are moves to undo
     */
    protected void setUndoButton(){ // TODO
        boolean enableUndoButton = this.model.getMovesSize()>0 && this.model.isHumansPlaying(); // declare a boolean flag called enableUndoButton, which enables the undo Button if the size of the moves is greater than 0 and a human is playing
        undoButton.setDisable(!enableUndoButton); // disable the undobutton if the conditions for enabling it are not met
    }


    /**
     * Sets the GameMode to the given mode
     * Shows the SideSelector (Not needed for Human vs Human) or the BoardPanel accordingly
     * @param mode the selected GameMode
     */
    protected void setGameMode(ThreeMusketeers.GameMode mode){
        gameModeLabel.setText(mode.name());// set the text for the gameModeLabel by passing in mode.name
        gameMode = mode; // set the gameMode equal to mode
        if (gameMode==ThreeMusketeers.GameMode.Human) { // if the gameMode is equal to human
            model.selectMode(gameMode, null); // using model's selectMode method pass in the argument gameMode, and passing in null for the side type
            showBoard(); // showBoard will display the gameboard
        }
        else {
            showSideSelector(); // if it is not human mode, a side slector will appear using showSideSelector to prompt user to choose between guard or musketeer
        }
    }





    /**
     * Handles setting the correct agents based on the selected GameMode and the player's piece type by
     * calling model.selectMode
     * Shows the BoardPanel once the side and mode are selected
     * @param sideType the selected Piece Type for the human player in Human vs Computer games
     */
    protected void setSide(Piece.Type sideType){ // TODO
        this.model.selectMode(gameMode,sideType); // using model and the selectMode method, pass in gameMode and sideType to choose your side
        showBoard(); // display the game board, by calling he showBoard method
    }


    /**
     * Handler for the Undo button
     * Undoes the latest move
     */
    private void undo() { // TODO
        this.model.undoMove(); // using the model and the undoMove method, undo the move
        this.boardPanel.updateCells(); // update the cells om the board to it's prior state
    }

    /**
     * Handler for the Save Board button
     * Saves the current board state to a text file
     * Uses saveFileNameTextField to get user input for the name of the file (must end with ".txt")
     * Contains error handling to make sure the file does not already exist and the input ends with ".txt"
     * Updates saveFileErrorLabel with the appropriate message
     *
     * Must use saveFileSuccess, saveFileExistsError, or saveFileNotTxtError to set as the text of saveFileErrorLabel
     */
    private void saveBoard() {
        while(this.saveButton.isDisable()==false){ // if the save button is not disabled, enter the while loop
            String fileName = saveFileNameTextField.getText(); // declare a variable called fileName to store the string version of fileName
            if (fileName.length()<4||!fileName.substring(fileName.length() - 4).equals(".txt")) { // if the string is less than 4 characters or the fileName does not have a substring .txt from the string length -4
                this.saveFileErrorLabel.setText(saveFileNotTxtError); // set saveFileErrorLabel to saveFileNotTxtError
            }
            File boardPathDirectory = new File("boards"); // create a variable called boardDirectoryPath to locate the directory of "boards
            File[] arrayOfBoardFiles = boardPathDirectory.listFiles(); // declare a File array called arrayOfBoardFiles, which holdes the files in boardPathDirectory or the "boards" directory
            boolean fileExist = false; // declare a boolean flag called fileExist and set it to false
            for (int i=0; i<arrayOfBoardFiles.length; i++){ // for loop that starts indexing from 0 until the length of arrayOfBoardFiles and increment by 1, so all board files are detected
                if (arrayOfBoardFiles[i].getName().equals(fileName)){ // using getName name, check if the current file in the arrayOfBardFiles at the current index is equal to fileName enter the if block
                    fileExist = true; // set fileExist to true
                    break; // No need to continue searching, exit the loop
                }
            }
            if (fileExist==true){ // if the file exist enter the if block
                this.saveFileErrorLabel.setText(saveFileExistsError); // set saveFileErrorLabel to saveFileExistsError
            }
            File saveFile = new File(boardPathDirectory,fileName); // declare a variable called saveFile which is of type file where it will eventually store the newly created file in the boardPathDirectory and it's name
            try { // try these steps in the try block
                if (fileExist==false){ //if the name od the file does not exist
                    saveFile.createNewFile(); // create a new saved file using the createNewFile method
                    this.model.getBoard().saveBoard(saveFile); // Save the file using getBoard and saveBoard method, passing in saveFile in the saveBoard method
                    this.saveFileErrorLabel.setText(saveFileSuccess); // set saveFileErrorLabel to saveFileSuccess
                }
            }
            catch (IOException e){ // if an IOexception is detected enter the catch block
                e.printStackTrace(); // do e.printStackTrace
            }
            break; // Break out of the loop because we only want to run this once
        }
    }


    /**
     * The handler for the New Game button
     * Restarts the game and updates the view accordingly
     * A new game is created and the main menu must be shown again
     */
    private void restart() { // TODO
        this.model.restart(); // using model instance variable called restart the game, using the restart method
        showMainMenu(); // show the main menu
    }

    /**
     * Updates the view to show the side selector
     */
    private void showSideSelector() {
        VBox vBox = new VBox(20, messageLabel, new SideInputPanel(this));
        vBox.setAlignment(Pos.CENTER);
        borderPane.setCenter(vBox);
    }


}
