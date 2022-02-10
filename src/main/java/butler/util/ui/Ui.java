package butler.util.ui;

import butler.Butler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Ui {

    private static Ui uiInstance = null;
    private String message;
    private final Image userImage;
    private final Image butlerImage;

    /**
     * Default Ui Constructor
     */
    public Ui() {
        userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
        butlerImage = new Image(this.getClass().getResourceAsStream("/images/DaButler.png"));
    }

    /**
     * Gets the message stored in this handler class.
     *
     * @return The message stored in this class.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets the message stored in this handler class.
     *
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter for Ui Singleton Pattern
     *
     * @return A Singleton Instance of Ui
     *
     */
    public static Ui getUi() {
        if (uiInstance == null) {
            uiInstance = new Ui();
        }
        return uiInstance;
    }

    protected void handleUserInput(TextField userInput, VBox dialogContainer) {
        Label userText = new Label(userInput.getText());
        userText.setPadding(new Insets(10, 10, 10, 10));
        Label butlerText = new Label(getResponse(userInput.getText()));
        butlerText.setPadding(new Insets(10, 10, 10, 10));
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(userImage)),
                DialogBox.getButlerDialog(butlerText, new ImageView(butlerImage))
        );
        userInput.clear();
    }

    private String getResponse(String input) {
        return Butler.respond(input);
    }
}
