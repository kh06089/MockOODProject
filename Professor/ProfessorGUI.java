package Professor;

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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ProfessorGUI extends Application {

    private Desktop desktop = Desktop.getDesktop();

    //Window style
    private String backgroundColor = "-fx-background-color: #041E42";
    private String buttonStyle = " -fx-background-radius: 30px;";

    //Adds shadow effect to buttons when hovered over
    private Color colorOn = new Color(0.5843, 0.4902, 0.2471, 1);
    private Color colorOff = new Color(0.5, 0.5, 0.5, 0);
    private DropShadow shadowOn = new DropShadow(20, colorOn);
    private DropShadow shadowOff = new DropShadow(20, colorOff);

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) {
        Pane p = new Pane();
        Pane outerPane = new Pane();

        Scene s = new Scene(outerPane,400,335);

        //Background Design
        outerPane.setStyle(backgroundColor);

        //GS logo size
        double bGroundWidth = 200;
        double bGroundHeight = 112.5;

        Image backGrd = new Image("http://static-11.sinclairstoryline.com/resources/media/a1513171-a451-48a6-ad84-2ea32c3c1a53-large16x9_1280x720_51223E00TCAUL.png", bGroundWidth, bGroundHeight, true, true);
        Image help = new Image(getClass().getResourceAsStream("help.png"), 25, 25, false, true);

        shadowOn.setSpread(0.6);

        FileChooser fileChooser = new FileChooser();



        double hPosition = 200-(bGroundWidth /2);

        //Set size and location of background image
        BackgroundSize backgroundSize = new BackgroundSize(bGroundWidth, bGroundHeight, false, false, false, false);
        BackgroundPosition bPosition = new BackgroundPosition(Side.LEFT, hPosition, false, Side.TOP, 23.75, false);
        BackgroundImage bGround = new BackgroundImage(backGrd, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,bPosition,backgroundSize);
        Background background = new Background(bGround);

        p.setBackground(background);

        //Create Buttons
        Button question = new Button("  Upload\n" +
                "Questions");
        Button email = new Button("Upload\n Emails");
        Button reports = new Button("  View\nReports");
        Button send = new Button("Send Out\n Quizzes");
        Button btnHelp = new Button();


        //Create tooltip for help button
        Tooltip helpTip = new Tooltip();
        helpTip.setText("Text File Format Help");

        //Set Location and size of buttons
        question.setLayoutX(s.getWidth()/2-135);
        email.setLayoutX(s.getWidth()/2+15);
        reports.setLayoutX(s.getWidth()/2-135);
        send.setLayoutX(s.getWidth()/2+15);
        btnHelp.setLayoutX(0);

        question.setLayoutY(160);
        email.setLayoutY(160);
        reports.setLayoutY(240);
        send.setLayoutY(240);
        btnHelp.setLayoutY(0);

        question.setPrefWidth(120);
        question.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        question.setStyle(buttonStyle);
        question.setOnMouseEntered(e -> question.setEffect(shadowOn));
        question.setOnMouseExited(e -> question.setEffect(shadowOff));

        email.setPrefWidth(120);
        email.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        email.setStyle(buttonStyle);
        email.setOnMouseEntered(e -> email.setEffect(shadowOn));
        email.setOnMouseExited(e -> email.setEffect(shadowOff));

        reports.setPrefWidth(120);
        reports.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        reports.setStyle(buttonStyle);
        reports.setOnMouseEntered(e -> reports.setEffect(shadowOn));
        reports.setOnMouseExited(e -> reports.setEffect(shadowOff));

        send.setPrefWidth(120);
        send.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        send.setStyle(buttonStyle);
        send.setOnMouseEntered(e -> send.setEffect(shadowOn));
        send.setOnMouseExited(e -> send.setEffect(shadowOff));

        btnHelp.setGraphic(new ImageView(help));
        btnHelp.setStyle("-fx-background-color: transparent");
        btnHelp.setTooltip(helpTip);
        btnHelp.setOnMouseEntered(e -> btnHelp.setEffect(shadowOn));
        btnHelp.setOnMouseExited(e -> btnHelp.setEffect(shadowOff));
        btnHelp.setOnMousePressed(e -> btnHelp.setStyle("-fx-background-color: transparent; -fx-padding: 6 4 4 6;"));
        btnHelp.setOnMouseReleased(e -> btnHelp.setStyle("-fx-background-color: transparent; -fx-padding: 5 5 5 5;"));


        btnHelp.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                Stage helpStage = new Stage();
                helpStage.setTitle("File Formats");

                Pane rPane = new Pane();
                Pane emailsPane = new Pane();
                Pane questionsPane = new Pane();

                Image emailFmt = new Image(getClass().getResourceAsStream("emailFormat.png"));
                Image questionFmt = new Image(getClass().getResourceAsStream("questionFormat.png"));

                Button close;

                emailsPane.setStyle(backgroundColor);
                questionsPane.setStyle(backgroundColor);

                Scene rScene = new Scene(rPane, 1000, 460);

                emailsPane.setPrefWidth(483);
                emailsPane.setPrefHeight(400);
                emailsPane.setLayoutX(15);
                emailsPane.setLayoutY(10);

                questionsPane.setPrefWidth(480);
                questionsPane.setPrefHeight(400);
                questionsPane.setLayoutX(502);
                questionsPane.setLayoutY(10);

                Label emailLabel = new Label("Email Text Format");
                emailLabel.setLayoutX(165);
                emailLabel.setLayoutY(3);
                emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                emailLabel.setTextFill(Paint.valueOf("#FFFFFF"));

                ImageView emailView = new ImageView(emailFmt);
                emailView.setFitWidth(emailsPane.getPrefWidth() * 0.95);
                emailView.setFitHeight(emailsPane.getPrefHeight() - 42);
                emailView.setX((emailsPane.getPrefWidth() * 0.025));
                emailView.setY(emailsPane.getLayoutY() + 20);

                Label questLabel = new Label("Question Text Format");
                questLabel.setLayoutX(155);
                questLabel.setLayoutY(3);
                questLabel.setFont(Font.font("Arial", FontWeight.BLACK, 18));
                questLabel.setTextFill(Paint.valueOf("#FFFFFF"));

                ImageView questionView = new ImageView(questionFmt);
                questionView.setFitWidth(questionsPane.getPrefWidth() * 0.95);
                questionView.setFitHeight(questionsPane.getPrefHeight() - 42);
                questionView.setX(questionsPane.getLayoutX() + (questionsPane.getPrefWidth() * 0.025));
                questionView.setY(questionsPane.getLayoutY() + 30);


                double closeWidth = 250;
                close = new Button("Close");
                close.setPrefWidth(closeWidth);
                close.setPrefHeight(30);
                close.setLayoutX((rScene.getWidth() - closeWidth) / 2);
                close.setLayoutY(413);
                close.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                close.setStyle(buttonStyle);
                close.setOnAction(event1 -> helpStage.hide());
                close.setOnMouseEntered(e -> close.setEffect(shadowOn));
                close.setOnMouseExited(e -> close.setEffect(shadowOff));


                emailsPane.getChildren().addAll(emailLabel, emailView);
                questionsPane.getChildren().addAll(questLabel);

                rPane.setStyle(backgroundColor);
                rPane.getChildren().addAll(emailsPane, questionsPane, close, questionView);
                helpStage.setScene(rScene);
                helpStage.show();
            }
        });

        question.setOnAction(event -> {
            Stage questionStage = new Stage();
            File file = fileChooser.showOpenDialog(questionStage);

            if(file != null){
                openFile(file);
            }
        });

        email.setOnAction(event -> {
            Stage emailStage = new Stage();
            File file = fileChooser.showOpenDialog(emailStage);

            if(file != null){
                openFile(file);
            }
        });

        reports.setOnAction(event -> {
            Stage reportStage = new Stage();
            File file = fileChooser.showOpenDialog(reportStage);

            if(file != null){
                openFile(file);
            }
        });



        send.setOnAction(event -> {
            double textLayoutX = 100;

            Stage sendStage = new Stage();
            Pane sendPane = new Pane();
            Scene sendScene = new Scene(sendPane,500,400);
            sendPane.setStyle(backgroundColor);
            sendStage.setTitle("Send Quiz");

            //Button to send out quiz link
            Button sendOut = new Button("Send");
            sendOut.setLayoutX(400);
            sendOut.setLayoutY(350);
            sendOut.setPrefWidth(80);
            sendOut.setPrefHeight(20);
            sendOut.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            sendOut.setStyle(buttonStyle);

            Label timeLimit = new Label("Set Time Limit:");
            timeLimit.setLayoutX(textLayoutX);
            timeLimit.setLayoutY(20);
            timeLimit.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            timeLimit.setTextFill(Paint.valueOf("#FFFFFF"));

            Label qcode = new Label("Set Quiz Code:");
            qcode.setLayoutX(textLayoutX);
            qcode.setLayoutY(130);
            qcode.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            qcode.setTextFill(Paint.valueOf("#FFFFFF"));


            Label feedback = new Label("Set Feedback Option:");
            feedback.setLayoutX(textLayoutX);
            feedback.setLayoutY(210);
            feedback.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            feedback.setTextFill(Paint.valueOf("#FFFFFF"));

            Label dayLabel = new Label("Days:");
            dayLabel.setLayoutX(textLayoutX);
            dayLabel.setLayoutY(60);
            dayLabel.setFont(Font.font("Arial",14));
            dayLabel.setTextFill(Paint.valueOf("#FFFFFF"));

            Label hourLabel = new Label("Hours:");
            hourLabel.setLayoutX(textLayoutX + 95);
            hourLabel.setLayoutY(60);
            hourLabel.setFont(Font.font("Arial",14));
            hourLabel.setTextFill(Paint.valueOf("#FFFFFF"));

            Label minLabel = new Label("Minutes:");
            minLabel.setLayoutX(textLayoutX + 190);
            minLabel.setLayoutY(60);
            minLabel.setFont(Font.font("Arial", 14));
            minLabel.setTextFill(Paint.valueOf("#FFFFFF"));

            //Boxes to set Time Limit
            ComboBox<Integer> days = new ComboBox<>(FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
            days.setLayoutX(textLayoutX);
            days.setLayoutY(82);
            days.setStyle(buttonStyle + "-fx-font-size: 14px");

            ComboBox<Integer> hours = new ComboBox<>(FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24));
            hours.setLayoutX(textLayoutX + 95);
            hours.setLayoutY(82);
            hours.setStyle(buttonStyle + "-fx-font-size: 14px");

            ComboBox<Integer> mins = new ComboBox<>(FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59));
            mins.setLayoutX(textLayoutX + 190);
            mins.setLayoutY(82);
            mins.setStyle(buttonStyle + "-fx-font-size: 14px");


            TextField quizCode = new TextField();
            quizCode.setLayoutX(textLayoutX);
            quizCode.setLayoutY(164);
            quizCode.setStyle(buttonStyle + "-fx-font-size: 14px");
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
            rb1.setFont(Font.font("Arial", 14));
            rb1.setSelected(true);

            RadioButton rb2 = new RadioButton("Provide feedback with only incorrect answers.");
            rb2.setToggleGroup(group);
            rb2.setFont(Font.font("Arial", 14));


            RadioButton rb3 = new RadioButton("Provide feeedback with only correct answers.");
            rb3.setToggleGroup(group);
            rb3.setFont(Font.font("Arial", 14));

            rb1.setLayoutX(textLayoutX);
            rb2.setLayoutX(textLayoutX);
            rb3.setLayoutX(textLayoutX);

            rb1.setLayoutY(245);
            rb2.setLayoutY(275);
            rb3.setLayoutY(305);

            rb1.setTextFill(Paint.valueOf("#FFFFFF"));
            rb2.setTextFill(Paint.valueOf("#FFFFFF"));
            rb3.setTextFill(Paint.valueOf("#FFFFFF"));

            //Button gives option to return to last stage
            Button cancel = new Button("Cancel");
            cancel.setLayoutX(285);
            cancel.setLayoutY(350);
            cancel.setPrefWidth(90);
            cancel.setPrefHeight(20);
            cancel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            cancel.setStyle(buttonStyle);

            cancel.setOnAction(event12 -> {
                sendStage.hide();
                primaryStage.show();
            });


            sendPane.getChildren().addAll(sendOut,days,hours,mins,timeLimit,dayLabel,hourLabel,minLabel,quizCode,qcode,rb1,rb2,rb3,feedback, cancel);

            sendStage.setScene(sendScene);
            sendStage.show();
            primaryStage.hide();
        });


        p.getChildren().addAll(question,email,reports,send,btnHelp);
        outerPane.getChildren().add(p);



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