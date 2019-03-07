package GUI.Modules;

import GUI.FrontendController;
import javafx.scene.control.ListCell;
import java.util.Set;

public class CommandsAndVars extends ListModule {

    public CommandsAndVars(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        setClick();
    }

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
                    context.addToConsole(cell.getItem());
                }
            });
            return cell;
        });
    }

    public void setList(Set<String> myList) {
        list.clear();
        listCollection.clear();
        for (String s: myList) {
            listCollection.add(s);
            list.add(s);
        }
    }

    protected void setPlaceholder() {
    }
}
