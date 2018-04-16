package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class TournamentController {

    @FXML
    private HBox scoreArea;

    @FXML
    private VBox leftControlPanel;

    @FXML
    private VBox leftPlayerArea;

    @FXML
    private VBox rightPlayerArea;

    @FXML
    private VBox rightControlPanel;

    PlayersStorage playersStorage = new PlayersStorage();


    @FXML
    void testCode(ActionEvent event) {
        System.out.println(playersStorage.toString());
    }



    public void setPlayersStorage(PlayersStorage playersStorage) {
        this.playersStorage = playersStorage;
    }
}
