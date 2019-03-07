package Parser;

import java.util.*;

/**
 * @author: Louis Lee
 */

public class LanguageSetting {

    private String myLanguage;
    private ResourceBundle myResources;
    private Map<String, String> translationMap;

    public LanguageSetting(String language){
        myLanguage = "languageProperties/" + language;
        myResources = ResourceBundle.getBundle(myLanguage);
        translationMap = convertResourceBundleToMap(myResources);
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

    public String[] translateCommand(String[] listOfWords){
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
