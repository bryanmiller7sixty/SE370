package sample;

import Connector.Con_1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    @FXML
    private Button testrun;
    @FXML
    private ListView<String> tester;
    @FXML
    private void testrun(ActionEvent event) throws Exception {
        tester.getItems().add(Con_1.get());
    }
    public void setStage() throws IOException {
        Stage stage = new Stage();
        stage.setTitle("iCook");
        Pane myPane = null;
        myPane = FXMLLoader.load(getClass().getResource("Second.fxml"));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
