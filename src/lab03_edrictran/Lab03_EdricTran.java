/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab03_edrictran;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Edric Tran
 * @author 6289632
 * GitHub link: https://github.com/Edric1234/Lab03_EdricTran.git
 */
public class Lab03_EdricTran extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
       GridPane gp = new GridPane();
       BorderPane bp = new BorderPane(gp);
       Scene scene = new Scene(bp, 400, 275);
       
       Label fName = new Label("First Name: ");
       Label lName = new Label("Last Name: ");
       Label email = new Label("Email: ");
       Label pw = new Label("Password: ");
       gp.add(fName, 0, 0);
       gp.add(lName, 0, 1);
       gp.add(email, 0, 2);
       gp.add(pw, 0, 3);
       Label message = new Label("");
       gp.add(message, 0, 5);
       gp.setColumnSpan(message, 2);
       
       TextField fNameText = new TextField();
       TextField lNameText = new TextField();
       TextField emailText = new TextField();
       PasswordField pwText = new PasswordField();
       gp.add(fNameText, 1, 0);
       gp.add(lNameText, 1, 1);
       gp.add(emailText, 1, 2);
       gp.add(pwText, 1, 3);

       gp.setAlignment(Pos.CENTER);
       gp.setHgap(10);
       gp.setVgap(10);
       gp.setPadding(new Insets(25, 25, 25, 25));
       
       Button reg = new Button("Register");
       Button clear = new Button("Clear");
       reg.setDisable(true);
       gp.add(reg, 0, 4);
       gp.add(clear, 1, 4);
       
       scene.setOnKeyReleased(event -> {
               boolean filled = false;
               
               if (!fNameText.getText().isEmpty() && !lNameText.getText().isEmpty()
                       && !emailText.getText().isEmpty() && !pwText.getText().isEmpty()) {
                   filled = true;
               } else {
                   filled = false;
               }
               if (filled) {
                   reg.setDisable(false);
               } else {
                   reg.setDisable(true);
               }
       });
       
       reg.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent e) {
              boolean emailValid = false;
              boolean pwValid = false;
              boolean pwContainLetter = false;
              boolean pwContainDigit = false;
              
              if (emailText.getText().contains("@") 
                       && emailText.getText().substring(emailText.getText().indexOf('@') + 1, emailText.getText().length() - 1).contains(".")) {
                   emailValid = true;
               } else {
                  emailValid = false;
              }
              
              for (char c : pwText.getText().toCharArray()) {
                  if (Character.isLetter(c)) pwContainLetter = true;
                  if (Character.isDigit(c)) pwContainDigit = true;
              }
              if (pwContainLetter && pwContainDigit) pwValid = true;
              
              if (emailValid && pwValid) {
                  message.setText("Welcome");
                  message.setTextFill(Color.GREEN);

              } else {
                  message.setText("ERROR: email/password is invalid");
                  message.setTextFill(Color.RED);
              }
          }
       });
       
       clear.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent e) {
               fNameText.clear();
               lNameText.clear();
               emailText.clear();
               pwText.clear();
           }
        });

       stage.setTitle("User Registration Form");
       stage.setScene(scene);
       stage.show();
    }
}


