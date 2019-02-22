package Parser;

import java.util.ResourceBundle;

/**
 * @author: Louis Lee
 */

public class LanguageSetting {

    private String myLanguage = "English"; //default value
    public ResourceBundle myResources = ResourceBundle.getBundle(myLanguage);

    public LanguageSetting(String languageSetting){
        myLanguage = languageSetting;
    }

    public void changeLanguage(String language){
        //add all this after UI is completed
        //example: myturtle.setChangeString(myResources.getString("Turtle");
    }
}
