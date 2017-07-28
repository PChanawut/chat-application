package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class CreateScreen extends Screen{
	
	private TextField groupNameTextField;
	private TextField nickNameTextField;
	private TextField portNumberTextField;
	private TextField limitTextField;
	private CheckBox accessCheckBox;
	private Button backButton;
	private Button createButton;
	
	final int BUTTON_WIDTH = 138;
	final int BUTTON_HEIGHT = 35;
	final int CHECK_BOX_WIDTH = 78;
	
	final String [] buttonStyleArray = {
			"-fx-background-radius: 0px; ",
			"-fx-text-fill: #1565c0; ",
			"-fx-font-size: 25px; ",
			"-fx-font-family: Fresca-Regular; ",
			"-fx-font-weight: 100;"
	};
	
	final String [] textFieldStyleArray = {
			"-fx-background-radius: 4px; ",
			"-fx-text-fill: #E0E0E0; ",
			"-fx-font-size: 17px; ",
			"-fx-font-family: Fresca-Regular; ",
			"-fx-font-weight: 100; ",
			"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.75), 1, 0, 1, 1 ); "
	};
	
	private Scene scene;
	
	public CreateScreen(){
		
		String buttonStyle = "";
		for(String s : buttonStyleArray)
			buttonStyle += s;
		
		String textFieldStyle = "";
		for(String s : textFieldStyleArray)
			textFieldStyle += s;
		
		List<TextField> textFields = new ArrayList<TextField>();
		
		groupNameTextField = new TextField();
		groupNameTextField.setPromptText("group name");
		
		nickNameTextField = new TextField();
		nickNameTextField.setPromptText("nickname");
		
		portNumberTextField = new TextField();
		portNumberTextField.setPromptText("port number");
		
		accessCheckBox = new CheckBox("private");
		accessCheckBox.setMinWidth(CHECK_BOX_WIDTH);
		accessCheckBox.setStyle(
				  "-fx-text-fill: #FFFFFF; "
				+ "-fx-font-family: Fresca-Regular; "
				+ "-fx-font-size: 16px; "						
		);
		accessCheckBox.setPadding(new Insets(1,1,1,1));
		
		limitTextField = new TextField();
		limitTextField.setPromptText("limit");
		
		textFields.add(groupNameTextField);
		textFields.add(nickNameTextField);
		textFields.add(portNumberTextField);
		textFields.add(limitTextField);
		
		for(TextField t : textFields){
			t.setStyle(textFieldStyle);
			t.setPadding(new Insets(3, 4, 3, 4));
			t.setFocusTraversable(false);
		}
		
		HBox horizontalContainer = new HBox(5);
		horizontalContainer.setAlignment(Pos.CENTER);
		horizontalContainer.getChildren().addAll(portNumberTextField, accessCheckBox, limitTextField);
		
		backButton = new Button("BACK");
		backButton.setMaxSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		backButton.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		backButton.setPadding(Insets.EMPTY);
		backButton.setStyle(buttonStyle);
		
		createButton = new Button("CREATE");
		createButton.setMaxSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		createButton.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		createButton.setStyle(buttonStyle);
		createButton.setPadding(Insets.EMPTY);
		
		HBox horizontalButtonContainer = new HBox(30);
		horizontalButtonContainer.setAlignment(Pos.CENTER);
		horizontalButtonContainer.getChildren().addAll(backButton, createButton);
		
		VBox verticalContainer = new VBox(20);
		verticalContainer.setAlignment(Pos.CENTER);
		verticalContainer.getChildren().addAll(groupNameTextField, nickNameTextField, horizontalContainer, horizontalButtonContainer);
		VBox.setMargin(horizontalButtonContainer, new Insets(40, 0, 0, 0));
		
		BorderPane.setMargin(verticalContainer, new Insets(30, 75, 30, 75));
		BorderPane mainLayout = new BorderPane();
		createButton.requestFocus();
		
		mainLayout.setTop(verticalContainer);
		scene = new Scene(mainLayout);

		scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
		
		//LOAD FONT
		Font.loadFont(this.getClass().getResource("Fresca-Regular.ttf").toExternalForm().replaceAll("%20", " "), 24);

	}
	
	public Scene getScene(){
		return this.scene;
	}
	
}
