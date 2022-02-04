package butler.util.ui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import butler.Butler;

public class Ui {

    private String message;
    private final Image USER_IMAGE;
    private final Image BUTLER_IMAGE;
    private static Ui UiInstance = null;


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

    public Ui() {
        USER_IMAGE = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
        BUTLER_IMAGE = new Image(this.getClass().getResourceAsStream("/images/DaButler.png"));
    }


    /**
     * Getter for Ui Singleton Pattern
     *
     * @return A Singleton Instance of Ui
     *
     */
    public static Ui getUi() {
        if (UiInstance == null) {
            UiInstance = new Ui();
        }
        return UiInstance;
    }

    protected void handleUserInput(TextField userInput, VBox dialogContainer) {
        Label userText = new Label(userInput.getText());
        Label butlerText = new Label(getResponse(userInput.getText()));
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(USER_IMAGE)),
                DialogBox.getButlerDialog(butlerText, new ImageView(BUTLER_IMAGE))
        );
        userInput.clear();
    }

    private String getResponse(String input) {
        return Butler.respond(input);
    }
}
