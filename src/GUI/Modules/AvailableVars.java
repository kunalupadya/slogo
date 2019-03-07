package GUI.Modules;

import GUI.FrontendController;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

/**
 *
 */

public class AvailableVars extends CommandsAndVars{

    public AvailableVars(int width, int height, FrontendController myFrontendController) {
        super(width, height, "Available Variables", myFrontendController);
        setClick();
    }

    @Override
    public void setClick() {
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
    public void setPlaceholder() {
        String availableVars = myResourceBundles.getString("AvailableVars");
        listDisplay.setPlaceholder(new Label(availableVars));
    }
}
