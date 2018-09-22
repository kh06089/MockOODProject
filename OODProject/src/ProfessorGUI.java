import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ProfessorGUI extends Application {

    private double bGroundWidth = 200;
    private double bGroundHeight = 112.5;
    private Desktop desktop = Desktop.getDesktop();


    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane p = new Pane();
        Image backGrd = new Image("http://static-11.sinclairstoryline.com/resources/media/a1513171-a451-48a6-ad84-2ea32c3c1a53-large16x9_1280x720_51223E00TCAUL.png");
        FileChooser fileChooser = new FileChooser();


        double hPosition = (400/2)-(bGroundWidth/2);

        BackgroundSize backgroundSize = new BackgroundSize(bGroundWidth, bGroundHeight, false, false, false, false);
        BackgroundPosition bPosition = new BackgroundPosition(Side.LEFT, hPosition, false, Side.TOP, 23.75, false);
        BackgroundImage bGround = new BackgroundImage(backGrd, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,bPosition,backgroundSize);
        Background background = new Background(bGround);

        p.setBackground(background);
        Button question = new Button("  Upload\n" +
                                          "Questions");
        Button email = new Button("Upload\n Emails");
        Button reports = new Button("  View\nReports");
        Button send = new Button(" Send Out\n   Emails");
        Button btnHelp = new Button("?");

        question.setLayoutX(70);
        email.setLayoutX(230);
        reports.setLayoutX(70);
        send.setLayoutX(230);
        btnHelp.setLayoutX(5);

        question.setLayoutY(160);
        email.setLayoutY(160);
        reports.setLayoutY(240);
        send.setLayoutY(240);
        btnHelp.setLayoutY(5);

        question.setPrefWidth(100);
        question.setStyle("-fx-font: 12 font ; -fx-base: #d9d9d9;");

        email.setPrefWidth(100);
        email.setStyle("-fx-font: 12 font ; -fx-base: #d9d9d9;");

        reports.setPrefWidth(100);
        reports.setStyle("-fx-font: 12 font ; -fx-base: #d9d9d9;");

        send.setPrefWidth(100);
        send.setStyle("-fx-font: 12 font ; -fx-base: #d9d9d9;");






        btnHelp.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Stage secondaryStage = new Stage();
                Pane rPane = new Pane();
                Scene rScene = new Scene(rPane,300,400);

                secondaryStage.setScene(rScene);
                secondaryStage.show();
            }
        });

        question.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Stage questionStage = new Stage();
                File file = fileChooser.showOpenDialog(questionStage);

                if(file != null){
                    openFile(file);
                }
            }
        });

        email.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Stage emailStage = new Stage();
                File file = fileChooser.showOpenDialog(emailStage);

                if(file != null){
                    openFile(file);
                }
            }
        });

        reports.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                Stage secondaryStage = new Stage();
                Pane rPane = new Pane();
                Scene rScene = new Scene(rPane,300,400);

                secondaryStage.setScene(rScene);
                secondaryStage.show();
            }

        });

        send.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                Stage thirdStage = new Stage();
                Pane sendPane = new Pane();
                Scene sendScene = new Scene(sendPane,500,400);
                sendPane.setStyle("-fx-background-color: silver");

                Button sendOut = new Button("Send");
                sendOut.setLayoutX(400);
                sendOut.setLayoutY(350);
                sendOut.setPrefWidth(80);
                sendOut.setPrefHeight(20);
                sendOut.setFont(Font.font(14) );

                Label timeLimit = new Label("Set Time Limit:");
                timeLimit.setLayoutX(120);
                timeLimit.setLayoutY(65);
                timeLimit.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                Label qcode = new Label("Set Quiz Code:");
                qcode.setLayoutX(120);
                qcode.setLayoutY(155);
                qcode.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                Label feedback = new Label("Set Feedback Option:");
                feedback.setLayoutX(120);
                feedback.setLayoutY(230);
                feedback.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                Label dayLabel = new Label("Days:");
                dayLabel.setLayoutX(120);
                dayLabel.setLayoutY(90);

                Label hourLabel = new Label("Hours:");
                hourLabel.setLayoutX(190);
                hourLabel.setLayoutY(90);

                Label minLabel = new Label("Minutes:");
                minLabel.setLayoutX(260);
                minLabel.setLayoutY(90);

                Label secLabel = new Label("Seconds:");
                secLabel.setLayoutX(330);
                secLabel.setLayoutY(90);

                ComboBox<Integer> days = new ComboBox<Integer>(FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
                days.setLayoutX(120);
                days.setLayoutY(120);

                ComboBox<Integer> hours = new ComboBox<Integer>(FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24));
                hours.setLayoutX(190);
                hours.setLayoutY(120);

                ComboBox<Integer> mins = new ComboBox<Integer>(FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59));
                mins.setLayoutX(260);
                mins.setLayoutY(120);

                ComboBox<Integer> sec = new ComboBox<Integer>(FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59));
                sec.setLayoutX(330);
                sec.setLayoutY(120);


                TextField quizCode = new TextField();
                quizCode.setLayoutX(120);
                quizCode.setLayoutY(185);
                quizCode.setTextFormatter(new TextFormatter<String>((Change change) -> {
                    String newText = change.getControlNewText();
                    if (newText.length() > 4) {
                        return null ;
                    } else {
                        return change ;
                    }
                }));
                //FeedBack Options
                final ToggleGroup group = new ToggleGroup();

                RadioButton rb1 = new RadioButton("Provide feedback with all questions.");
                rb1.setToggleGroup(group);
                rb1.setSelected(true);
                RadioButton rb2 = new RadioButton("Provide feedback with only incorrect answers.");
                rb2.setToggleGroup(group);
                RadioButton rb3 = new RadioButton("Provide feeedback with only correct answers.");
                rb3.setToggleGroup(group);

                rb1.setLayoutX(120);
                rb2.setLayoutX(120);
                rb3.setLayoutX(120);

                rb1.setLayoutY(250);
                rb2.setLayoutY(275);
                rb3.setLayoutY(300);


                sendPane.getChildren().addAll(sendOut,days,hours,mins,sec,timeLimit,dayLabel,hourLabel,minLabel,secLabel,quizCode,qcode,rb1,rb2,rb3,feedback);

                thirdStage.setScene(sendScene);
                thirdStage.show();
            }

        });


        p.getChildren().addAll(question,email,reports,send,btnHelp);


        Scene s = new Scene(p,400,350);

        primaryStage.setScene(s);
        primaryStage.show();
    }

    private void openFile(File file){
        try{
            desktop.open(file);
        }
        catch(IOException e){

        }
    }

}