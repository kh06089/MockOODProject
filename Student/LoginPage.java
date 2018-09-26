import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPage {
	Pane pane, outerPane;
	Scene scene;
	TextField emailField;
	PasswordField pswdField;
	Button btnLogin;
	String buttonStyle = " -fx-background-radius: 25px; -fx-border-color: #14336C; -fx-border-width: 3px; -fx-border-radius: 20px; -fx-background-insets: 0";
	String backgroundColor = "-fx-background-color: #98B4C2";
	
	public LoginPage() {
		pane = new Pane();
		outerPane = new Pane();

		Image backGrd = new Image("http://static-11.sinclairstoryline.com/resources/media/a1513171-a451-48a6-ad84-2ea32c3c1a53-large16x9_1280x720_51223E00TCAUL.png", 200, 112.5, true, true);

		BackgroundSize backgroundSize = new BackgroundSize(200, 112.5, false, false, false, false);
		BackgroundPosition bPosition = new BackgroundPosition(Side.LEFT, 45, false, Side.TOP, 25, false);
		BackgroundImage bGround = new BackgroundImage(backGrd, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,bPosition,backgroundSize);
		Background background = new Background(bGround);
		
		pane.setPrefHeight(385);
		pane.setPrefWidth(290);


		emailField = new TextField();
		emailField.setLayoutX(51);
		emailField.setLayoutY(188);
		emailField.setPrefWidth(196);
		emailField.setStyle(buttonStyle);


		Label lblEmail = new Label("Email:");
		lblEmail.setLayoutX(51);
		lblEmail.setLayoutY(167);
		lblEmail.setFont(Font.font("Arial", FontWeight.BOLD, 14));

		pswdField = new PasswordField();
		pswdField.setLayoutX(51);
		pswdField.setLayoutY(267);
		pswdField.setPrefWidth(196);
		pswdField.setStyle(buttonStyle);

		Label lblPassword = new Label("Password:");
		lblPassword.setLayoutX(51);
		lblPassword.setLayoutY(247);
		lblPassword.setFont(Font.font("Arial", FontWeight.BOLD, 14));

		btnLogin = new Button("Login");
		btnLogin.setLayoutX(80);
		btnLogin.setLayoutY(330);
		btnLogin.setPrefWidth(130);
		btnLogin.setFont(Font.font("Arial", FontWeight.BOLD, 16));
		btnLogin.setStyle(buttonStyle);

		pane.setBackground(background);
		pane.getChildren().addAll(btnLogin, lblPassword, lblEmail, emailField, pswdField);

		outerPane.setStyle(backgroundColor);
		outerPane.getChildren().addAll(pane);

		scene = new Scene(outerPane);

	}
	
	public Scene getScene() {
		return scene;
	}
	
	public Pane getPane() {
		return pane;
	}

	public TextField getEmailField() {
		return emailField;
	}

	public PasswordField getPswdField() {
		return pswdField;
	}
	public Button getBtnLogin() {
		return btnLogin;
	}

}
