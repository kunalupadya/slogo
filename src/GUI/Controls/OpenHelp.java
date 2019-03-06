package GUI.Controls;

import GUI.FrontendController;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;


public class OpenHelp {
    private FrontendController context;
    private Hyperlink myHyperlink;

    public OpenHelp(FrontendController context) {
        this.myHyperlink = new Hyperlink();
        ResourceBundle buttonImages = ResourceBundle.getBundle("/buttonProperties/ButtonImages");
        String image = buttonImages.getString("OpenHelp");
        Image hyperlinkGraphic = new Image(FrontendController.class.getResourceAsStream(image), 20, 20, true, true);
        myHyperlink.setGraphic(new ImageView(hyperlinkGraphic));
        myHyperlink.getStyleClass().add("button");
        myHyperlink.setOnAction(e -> action());
        this.context = context;
    }

    private void action() {
        if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI("https://www2.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php"));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

    public Hyperlink getHyperlink() {
        return myHyperlink;
    }
}
