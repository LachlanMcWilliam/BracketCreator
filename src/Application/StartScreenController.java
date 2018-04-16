package Application;

import javafx.application.Application;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.HashMap;


public class StartScreenController {

    @FXML
    private VBox controlColumn;

    @FXML
    private VBox nameColumn;

    @FXML
    private TextField addPlayerNameField;

    private final PlayersStorage storageController = new PlayersStorage();
    private final HashMap<Integer, Button> deleteButtonHash = new HashMap<>();
    private final HashMap<Integer, TextField> playerTextHash = new HashMap<>();

    private int idCounter = 0;


    /**
     * ADD PLAYERS CONTROLS
     **/

    public void addPlayerEnter(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            addPlayer(idCounter);
            addDeleteButton(idCounter);

            idCounter++;
        }
    }

    public void addPlayerClick() {
        addPlayer(idCounter);
        addDeleteButton(idCounter);

        idCounter++;
    }

    private void addPlayer(int Id) {

        String name = addPlayerNameField.getText();
        Player newPlayer = new Player(name);
        storageController.addPlayer(newPlayer);
        addPlayerNameField.setText("");


        TextField playerNameLabel = new TextField(name);
        playerNameLabel.setId(String.valueOf(Id));

        //System.out.println(playerNameLabel.getId());

        playerNameLabel.setEditable(false);

        nameColumn.getChildren().add(playerNameLabel);
        playerTextHash.put(Id, playerNameLabel);
        System.out.println(storageController.toString());
    }

    private void addDeleteButton(int Id) {
        Button deleteButton = new Button();

        deleteButton.setId(String.valueOf(Id));
        deleteButton.setText("Delete");
        deleteButton.setOnAction(event -> {
            String buttonId = ((Control) event.getSource()).getId();
            deletePlayer(Integer.valueOf(buttonId));
        });

        //System.out.println(deleteButton.getId());

        controlColumn.getChildren().add(deleteButton);
        deleteButtonHash.put(Id, deleteButton);

    }

    private void deletePlayer(int buttonId) {

        System.out.println("Button of Id: " + buttonId + " removed");

        Button deletedButton = deleteButtonHash.get(buttonId);
        TextField deletedField = playerTextHash.get(buttonId);

        deleteButtonHash.remove(buttonId);
        playerTextHash.remove(buttonId);

        String deletedPlayer = deletedField.getText();
        storageController.removePlayer(deletedPlayer);

        nameColumn.getChildren().remove(deletedField);
        controlColumn.getChildren().remove(deletedButton);

    }


    /**
     * START BUTTON CONTROLS
     */
    public void startButtonClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../sceneFiles/mainTournament.fxml"));

        Parent tournamentViewParent = loader.load();
        Scene tournamentScene = new Scene(tournamentViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tournamentScene);
        window.show();

        TournamentController tournamentController = loader.getController();

        tournamentController.setPlayersStorage(storageController);
    }
}