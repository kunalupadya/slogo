package Parser;

import java.util.*;

/**
 * @author: Louis Lee
 */

public class LanguageSetting {

    private String myLanguage = "English"; //default value
    public ResourceBundle myResources;
    private Map<String, String> translationMap;
    private Map<String, String> newMap;
    private HandleError handleError;


    public LanguageSetting(String language){
        myLanguage = language;
        myResources= ResourceBundle.getBundle(myLanguage);
        translationMap = convertResourceBundleToMap(myResources);
        newMap = reverseKeyFromValue(translationMap);
    }

    private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if(resource.getString(key).contains("|")){
                map.put(key, resource.getString(key).split("|")[0]);
                map.put(key, resource.getString(key).split("|")[1]);
            }
            else{
                map.put(key, resource.getString(key));
            }
        }
        return map;
    }

    public String[] translateCommand(String[] listOfWords){
        String[] translatedListOfWords = new String[listOfWords.length];
        for(int a=0; a<listOfWords.length; a++){
            if(!newMap.containsKey(listOfWords[a])){
                handleError.interpretationError(listOfWords[a]);
                break;
            }
            translatedListOfWords[a] = newMap.get(listOfWords[a]);
        }
        return translatedListOfWords;
    }

    private Map<String, String> reverseKeyFromValue(Map<String, String> translationMap){
        Map<String, String> myNewHashMap = new HashMap<>();
        for(Map.Entry<String, String> entry : translationMap.entrySet()){
            myNewHashMap.put(entry.getValue(), entry.getKey());
        }
        return myNewHashMap;
    }
}
