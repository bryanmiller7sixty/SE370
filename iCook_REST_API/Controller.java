package sample;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
public class Controller implements Initializable{
    @FXML
    private ListView<String> pro;
    @FXML
    private ListView<String> veg;
    @FXML
    private ListView<String> carbs;
    @FXML
    private ListView<String> sauces;
    @FXML
    private void chicken(ActionEvent event)
    {
        pro.getItems().add("Chicken");
    }
    @FXML
    private void Broccli(ActionEvent event)
    {
        veg.getItems().add("Broccli");
    }
    @FXML
    private void Garlic(ActionEvent event) throws Exception {
        veg.getItems().add("Garlic");
    }
    @FXML
    private void clearTable(){
        pro.getItems().clear();
        veg.getItems().clear();
    }
    private void closeStage()
    {
        ((Stage)veg.getScene().getWindow()).close();
    }
    @FXML
    public void loadSecond(ActionEvent event) throws IOException {
        try{
            Controller2 cont2 = new Controller2();
            cont2.setStage();
            closeStage();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

}
