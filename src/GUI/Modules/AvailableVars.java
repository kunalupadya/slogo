package GUI.Modules;

import GUI.FrontendController;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import java.util.ResourceBundle;

/**
 *
 * @author David Liu
 */

public class AvailableVars extends CommandsAndVars{
    private FrontendController context;
    private ResourceBundle myResourceBundles;
    private ListView<String> listDisplay;

    public AvailableVars(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        context = getContext();
        setClick();
    }

    @Override
    protected void setClick() {
        listDisplay.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    context.addToConsole(":" + cell.getItem());
                }
            });
            return cell;
        });
    }

    @Override
    protected void setPlaceholder() {
        myResourceBundles = getMyResourceBundles();
        listDisplay = getListDisplay();
        String availableVars = myResourceBundles.getString("AvailableVars");
        listDisplay.setPlaceholder(new Label(availableVars));
    }
}
