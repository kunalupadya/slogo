package Parser;

import java.util.*;

/**
 * @author: Louis Lee
 */

public class LanguageSetting {

    private String myLanguage;
    private ResourceBundle myResources;
    private Map<String, String> translationMap;
    private Map<String, String> newMap;
//    private HandleError handleError;


    public LanguageSetting(String language){
        //myLanguage = language;
        myLanguage = language;
        myResources = ResourceBundle.getBundle(myLanguage);
        translationMap = convertResourceBundleToMap(myResources);
        newMap = reverseKeyFromValue(translationMap);
    }

    private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if(resource.getString(key).contains("|")){
                String[] splitString = resource.getString(key).split("\\|");
                System.out.println(splitString);
                map.put(key, splitString[0]);
                map.put(key, splitString[1]);
            }
            else{
                map.put(key, resource.getString(key));
            }
        }
        System.out.println(map);
        return map;
    }

    //TODO: What do we do if there's an error. We just return semi-translated list? This method should probably throw an error
    //TODO: must deal with user defined commands also
    public String[] translateCommand(String[] listOfWords){
        var tokenConverter = new TokenConverter();
        for (int i = 0; i < listOfWords.length; i++) {
            if (tokenConverter.checkTypeOfInput(listOfWords[i]) == Token.COMMAND){
                if (!newMap.containsKey(listOfWords[i])) {
//                    handleError.interpretationError(listOfWords[i]);
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


    public Map<String, String> makeReflectionMap() {
        ResourceBundle englishProperty = ResourceBundle.getBundle("English");
        Map<String, String> map = new HashMap<>();
        Enumeration<String> keys = englishProperty.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if (englishProperty.getString(key).contains("|")) {
                map.put(englishProperty.getString(key).split("\\|")[0], key);
                map.put(englishProperty.getString(key).split("\\|")[1], key);
            }
            else{
                map.put(englishProperty.getString(key), key);
            }
        }
        return map;

    }
}
