package assignment2;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ModeInputPanel extends GridPane {
    private final View view;

    /**
     * Constructs a new GridPane with the main menu of the game, to select a game mode and load saved boards
     * @param view
     */
    public ModeInputPanel(View view) {
        this.view = view;
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);

        view.setMessageLabel("Main Menu");

        createModeButtons();
        createListView();
    }

    /**
     * Creates the Game mode buttons
     */
    private void createModeButtons(){
        for (ThreeMusketeers.GameMode mode: ThreeMusketeers.GameMode.values()) {
            Button button = new Button(mode.getGameModeLabel());
            button.setId(mode.getGameModeLabel().replaceAll(" ", "")); // DO NOT MODIFY ID

            // Default styles which can be modified
            button.setPrefSize(500, 100);
            button.setFont(new Font(20));
            button.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
            button.setOnAction(e -> this.view.setGameMode(mode));

            this.add(button, 0, this.getRowCount());
        }
    }

    /**
     * Creates the ListView to select a board to load
     */
    private void createListView(){
        Label selectBoardLabel = new Label(String.format("Current board: %s", view.model.getBoardFile().getName()));
        selectBoardLabel.setId("CurrentBoard"); // DO NOT MODIFY ID

        ListView<String> boardsList = new ListView<>();
        boardsList.setId("BoardsList");  // DO NOT MODIFY ID

        boardsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        int starterIndex = getFiles(boardsList);
        boardsList.getSelectionModel().select(starterIndex);

        Button selectBoardButton = new Button("Change board");
        selectBoardButton.setId("ChangeBoard"); // DO NOT MODIFY ID

        selectBoardButton.setOnAction(e -> selectBoard(selectBoardLabel, boardsList));

        VBox selectBoardBox = new VBox(10, selectBoardLabel, boardsList, selectBoardButton);

        // Default styles which can be modified

        boardsList.setPrefHeight(100);

        selectBoardLabel.setStyle("-fx-text-fill: #e8e6e3");
        selectBoardLabel.setFont(new Font(16));

        selectBoardButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
        selectBoardButton.setPrefSize(200, 50);
        selectBoardButton.setFont(new Font(16));

        selectBoardBox.setAlignment(Pos.CENTER);

        this.add(selectBoardBox, 0, this.getRowCount());
    }

    /**
     * Gets all the text files from the boards directory and puts them into the given listView
     * @param listView ListView to update
     * @return the index in the listView of Starter.txt
     */
    private int getFiles(ListView<String> listView){
        int indexOfStarter = 0; // indexOfStarter to keep track of when Starter.txt is found
        File boardsDirectoryPath = new File("boards"); // declare a variable called boardDirectoryPath is used to declare and locate where "boards" directory is located
        File[] arrayOfBoardFiles = boardsDirectoryPath.listFiles(); //declare a variable called arrayOfBoardFiles is used to hold the files that are in the boardsDirectoryPath, i.e the "boards" directory
        if (arrayOfBoardFiles != null) { // create an if statement to check if the arrayOfBoards is not null, enter the if block if it not null.
            for (int i=0; i < arrayOfBoardFiles.length; i++) { // create a for loop to start indexing at 0, until we reach the end of the arrayOfBoardFiles, increment by 1, so all files are detected.
                File boardFile = arrayOfBoardFiles[i]; // declare a variable called boardFile which holds the current file in the board directory at the given index
                String fileName = boardFile.getName(); // declare a variable called fileName which is used to hold the String version of the file name
                listView.getItems().add(fileName); // using the listView argument, add the string version of the fileName to the listView
                if (fileName.equals("Starter.txt")) { // if the fileName variable is equal to "Starter.txt"
                    indexOfStarter = i; // set the indexOfStarter to i, and that's the index where indexOfStarter is located
                }
            }
        }
        return indexOfStarter; // lastly, return the indexOfStarter
    }


    /**
     * Loads the board file selected in the boardsList and updates the selectBoardLabel with the name of the new Board file
     * @param selectBoardLabel a message Label to update which board is currently selected
     * @param boardsList a ListView populated with boards to load
     */
    private void selectBoard(Label selectBoardLabel, ListView<String> boardsList){
        File boardDirectoryPath = new File("boards"); // declare a variable called boardDirectoryPath which locates where "boards" directory is located
        String selectedBoard = boardsList.getSelectionModel().getSelectedItem(); // declare a variable called selectedBoard which uses the argument to get holds to the String versions of the selectedBoard
        if (selectedBoard != null) { //create an if statement the selectedBoard is not null. If it is not null enter the if block
            File[] files = boardDirectoryPath.listFiles(); // declare a variable called files which will hold all the files that are in the boardDirectoryPath, or the "boards" directory
            for (int i=0; i<files.length; i++) { // create a for loop that start's iterating at the first index until all files are read, increment by 1, so all files are processed
                File file = files[i]; // declare a variable called file, which holds the file at the current index
                if (file.getName().equals(selectedBoard)) { // if the name of the file is equal to the selected board, enter the if block
                    view.model.setBoard(file); // update the view of the board to file
                    selectBoardLabel.setText(String.format("Current Board: %s", selectedBoard)); // set the selectBoardLabel to display the currentBoard that is chosen
                    break; // after the board is chosen. break out of the loop
                }
            }
        }
    }
}

