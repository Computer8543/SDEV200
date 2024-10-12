/* Program name: App.java
 * Author: Kyle Ingersoll
 * Date last updated: 10/10/2024
 * Purpose: To act as a library management program to manage books and borrowers.
 */
package com.finalproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    
    // create scene variables
    private static Scene scene;
    private static Scene loginFailureDueToEmptyUsernameOrPasswordScene;
    private static Scene loginFailureDueToIncorrectCredentialsScene;

    @Override
    public void start(Stage stage) throws IOException {
        // set title of page
        stage.setTitle("Library Management System");

        // create a pane to store login buttons in
        GridPane loginPane = new GridPane();

        // create login text labels and fields to store text in
        Label usernameLabel = new Label("Username:");
        usernameLabel.setContentDisplay(ContentDisplay.LEFT);
        
        Label passwordLabel = new Label("Password:");
        passwordLabel.setContentDisplay(ContentDisplay.LEFT);
        
        TextField usernameTextField = new TextField();
        usernameTextField.setAlignment(Pos.CENTER_RIGHT);
        
        PasswordField passwordField = new PasswordField();
        passwordField.setAlignment(Pos.CENTER_RIGHT);
        
        // create login button
        Button loginButton = new Button("Login");

        // layout the text boxes, labels, and the button
        loginPane.add(usernameLabel, 0, 0);
        loginPane.add(usernameTextField, 1, 0);
        loginPane.add(passwordLabel, 0, 1);
        loginPane.add(passwordField, 1, 1);
        loginPane.add(loginButton, 0, 2);


        // create new scene
        scene = new Scene(loginPane, 640, 480);

        // login logic
        loginButton.setOnAction((login) -> { 
            // get username and password from fields
            String username = usernameTextField.getText();
            String password = passwordField.getText();

            // if the username or password is empty, create a new screen showing a return button and an error message
            if (username.isEmpty() || password.isEmpty())
            {
                // initialize stage, GridPane, error message label, and return button
                GridPane loginFailureDueToEmptyUsernameOrPasswordGridPane = new GridPane();
                Label loginFailureDueToEmptyUsernameOrPasswordLabel = new Label("Both the username and password cannot be empty.");
                Button returnButton = new Button("Return to Login Screen");

                // set action for return button to return to login page
                returnButton.setOnAction(((returnToLoginPage) -> {
                    try {
                        // bad control flow practice, but we don't need to preserve input since an empty password or username 
                        // field means the input is invalid
                        start(stage);
                    } catch (IOException ex) {
                        System.out.println("Something went wrong, closing out program.");
                        System.exit(1);
                    }
                    

                }));

                // layout of label and button in GridPane
                loginFailureDueToEmptyUsernameOrPasswordGridPane.add(loginFailureDueToEmptyUsernameOrPasswordLabel, 0, 0);
                loginFailureDueToEmptyUsernameOrPasswordGridPane.add(returnButton, 1, 0);

                // initialize new scene
                loginFailureDueToEmptyUsernameOrPasswordScene = new Scene(loginFailureDueToEmptyUsernameOrPasswordGridPane, 640, 480);

                stage.setScene(loginFailureDueToEmptyUsernameOrPasswordScene);
                stage.show();

            }

            // authenticate user
            try {
                // see if username and password equal a valid user
                boolean validUser = authenticateUser(username, password); 

                // if they do, then show the next page, if not create another page showing the error
                if (validUser) {
                    // todo: set up library page with searchbar
                }
                else {
                GridPane loginFailureDueToIncorrectCredentialsGridPane = new GridPane();
                Label loginFailureDueToIncorrectCredentialsLabel = new Label("The username and/or password is incorrect.");
                Button returnButton = new Button("Return to Login Screen");

                // set action for return button to return to login page
                returnButton.setOnAction(((returnToLoginPage) -> {
                    try {
                        // bad control flow practice, but we don't need to preserve input since an empty password or username 
                        // field means the input is invalid
                        start(stage);
                    } catch (IOException ex) {
                        System.out.println("Something went wrong, closing out program.");
                        System.exit(1);
                    }
                    

                }));
                // we layout the buttons in the grid
                loginFailureDueToIncorrectCredentialsGridPane.add(loginFailureDueToIncorrectCredentialsLabel, 0, 0);
                loginFailureDueToIncorrectCredentialsGridPane.add(returnButton, 1, 0 );

                // we set up the scene to the stage and show it
                loginFailureDueToIncorrectCredentialsScene = new Scene(loginFailureDueToIncorrectCredentialsGridPane, 640, 480);
                stage.setScene(loginFailureDueToIncorrectCredentialsScene);
                stage.show();

                }

            } catch (ClassNotFoundException ex) {
                System.err.println(ex);
            } 
            catch (SQLException ex) {
                System.err.println(ex);
            }
            
            


            
        });
        
        // link loginStage to scene
        stage.setScene(scene);
        // show loginStage to user
        stage.show();
    }
    
    
    /* Authenticate the user against the Java embedded database */
    private boolean authenticateUser(String username, String password) throws SQLException, ClassNotFoundException {
        // load JDBC driver
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

        // connect to database
        Connection connection = DriverManager.getConnection("jdbc:derby:librarydatabase", username, password);

        // if connection works, then return true, else return false
        return connection.isValid(0);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}