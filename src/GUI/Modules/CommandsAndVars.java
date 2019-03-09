package GUI.Modules;

import GUI.FrontendController;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.util.List;
import java.util.Set;

/**
 *
 * @author David Liu
 */

public class CommandsAndVars extends ListModule {
    private FrontendController context;
    private List<String> list;
    private ListView<String> listDisplay;
    private ObservableList<String> listCollection;

    public CommandsAndVars(int width, int height, String moduleName, FrontendController myFrontendController) {
        super(width, height, moduleName, myFrontendController);
        context = getContext();
        list = getList();
        listDisplay = getListDisplay();
        listCollection = getListCollection();
        setClick();
    }

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
