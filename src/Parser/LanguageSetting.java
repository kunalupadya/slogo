package Parser;

import java.util.ResourceBundle;

/**
 * @author: Louis Lee
 */

public class LanguageSetting {

    private String myLanguage = "English"; //default value
    public ResourceBundle myResources;

    public LanguageSetting(String languageSetting){
        myLanguage = languageSetting;
        myResources= ResourceBundle.getBundle(myLanguage);
    }

    public void changeLanguage(String language){
        //add all this after UI is completed
        //example: myturtle.setChangeString(myResources.getString("GraphicsBackend.Turtle");
    }
}
