package Parser;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * This class translates all commands into English using a translationMap constructed with the Resource Bundles.
 *
 * @author Louis Lee
 */
public class LanguageSetting {

    private Map<String, String> translationMap;

    /**
     * Basic Constructor
     * creates translation map with the given language
     * @param language: chosen language from the GUI. Default language is English
     */
    public LanguageSetting(String language){
        var myLanguage = "languageProperties/" + language;
        var bundle = ResourceBundle.getBundle(myLanguage);
        translationMap = convertResourceBundleToMap(bundle);
    }

    private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if(resource.getString(key).contains("|")){
                String[] splitString = resource.getString(key).split("\\|");
                map.put(splitString[0], key);
                map.put(splitString[1], key);
            }
            else{
                map.put(resource.getString(key), key);
            }
        }
        return map;
    }

    /**
     * translates all the commands into the actual name of the commands.
     * @param listOfWords: input words
     * @return string array of translated commands
     */

    String[] translateCommand(String[] listOfWords){
        String[] newList = new String[listOfWords.length];
        for (int i = 0; i < listOfWords.length; i++) {
            if (translationMap.containsKey(listOfWords[i])) {
                newList[i] = translationMap.get(listOfWords[i]);
            }
            else{
                newList[i] = listOfWords[i];
            }
        }
        return newList;
    }

}
