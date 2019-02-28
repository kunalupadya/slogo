package Backend.Parser;

import java.util.*;

/**
 * @author: Louis Lee
 */

public class LanguageSetting {

    private String defaultLang = "resources.languages/English.properties";
    private String myLanguage;
    private ResourceBundle myResources;
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

    //TODO: What do we do if there's an error. We just return semi-translated list? This method should probably throw an error
    //TODO: must deal with user defined commands also
    String[] translateCommand(String[] listOfWords){
        var tokenConverter = new TokenConverter();
        for (int i = 0; i < listOfWords.length; i++) {
            if (tokenConverter.checkTypeOfInput(listOfWords[i]) == Token.COMMAND){
                if (!newMap.containsKey(listOfWords[i])) {
                    handleError.interpretationError(listOfWords[i]);
                    break;
                }
                listOfWords[i] = newMap.get(listOfWords[i]);
            }
        }
        return listOfWords;
    }

    private Map<String, String> reverseKeyFromValue(Map<String, String> translationMap){
        Map<String, String> myNewHashMap = new HashMap<>();
        for(Map.Entry<String, String> entry : translationMap.entrySet()){
            myNewHashMap.put(entry.getValue(), entry.getKey());
        }
        return myNewHashMap;
    }
}
