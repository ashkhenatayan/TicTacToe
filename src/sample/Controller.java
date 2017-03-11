package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Optional;

public class Controller {
    private int firstPlayer=0;
    private int secondPlayer=0;
    @FXML
    public  Button cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9;


    @FXML
    void takeYourTurn(MouseEvent e) {
        if (e.getButton()== MouseButton.PRIMARY)
        {   secondPlayer=0;
            if (firstPlayer==0) {
                ((Button)(e.getSource())).setText("X");

            }

            else ;
            firstPlayer=1;
        }
        else {
            firstPlayer=0;
            if (secondPlayer==0) {
                ((Button)(e.getSource())).setText("O");

            }
            else ;
            secondPlayer=1;
        }

        clearBord();




    }

   public  int gameOutput(){

        if ((cell1.getText().equals("X")&& cell4.getText().equals("X") && cell7.getText().equals("X")) ||
               (cell2.getText().equals("X")&& cell5.getText().equals("X") && cell8.getText().equals("X"))||
               (cell3.getText().equals("X")&& cell6.getText().equals("X") && cell9.getText().equals("X"))||
       (cell1.getText().equals("X")&& cell2.getText().equals("X") && cell3.getText().equals("X"))||
               (cell4.getText().equals("X")&& cell5.getText().equals("X") && cell6.getText().equals("X"))||
               (cell7.getText().equals("X")&& cell8.getText().equals("X") && cell9.getText().equals("X"))||
                (cell1.getText().equals("X")&& cell5.getText().equals("X") && cell9.getText().equals("X"))||
                (cell7.getText().equals("X")&& cell5.getText().equals("X") && cell3.getText().equals("X")))



       {

            return 1;
       }
       if ((cell1.getText().equals("O")&& cell4.getText().equals("O") && cell7.getText().equals("O")) ||
               (cell2.getText().equals("O")&& cell5.getText().equals("O") && cell8.getText().equals("O"))||
               (cell3.getText().equals("O")&& cell6.getText().equals("O") && cell9.getText().equals("O"))||
               (cell1.getText().equals("O")&& cell2.getText().equals("O") && cell3.getText().equals("O"))||
               (cell4.getText().equals("O")&& cell5.getText().equals("O") && cell6.getText().equals("O"))||
               (cell7.getText().equals("O")&& cell8.getText().equals("O") && cell9.getText().equals("O"))||
               (cell1.getText().equals("O")&& cell5.getText().equals("O") && cell9.getText().equals("O"))||
               (cell7.getText().equals("O")&& cell5.getText().equals("O") && cell3.getText().equals("O")))
       {

           return 2;
       }
       return 0;
    }





    public void clearBord() {
        if (gameOutput() == 1 || gameOutput() == 2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game is over");
            if (gameOutput() == 1) {
                alert.setHeaderText("First player has won!");
                alert.setContentText("Would you like start another game?");

              firstPlayer=0;

            }
            else {
                alert.setHeaderText("Second player has won!");
                alert.setContentText("Would you like start another game?");
                secondPlayer =0;
                }

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                cell1.setText("");
                cell2.setText("");
                cell3.setText("");
                cell4.setText("");
                cell5.setText("");
                cell6.setText("");
                cell7.setText("");
                cell8.setText("");
                cell9.setText("");


            }
        }



    }

}


