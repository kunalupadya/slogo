package Parser;

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
    List<String[]> translateCommand(List<String[]> linesOfWords){
        var tokenConverter = new TokenConverter();
        boolean error = false;
        for(String [] line: linesOfWords){
            for (int i = 0; i < line.length; i++) {
                if (tokenConverter.checkTypeOfInput(line[i]) == Token.COMMAND){
                    if (!newMap.containsKey(line[i])) {
                        handleError.interpretationError(line[i]);
                        error = true;
                        break;
                    }
                    line[i] = newMap.get(line[i]);
                }
            }
            if (error) break;
        }
        return linesOfWords;
    }

    private Map<String, String> reverseKeyFromValue(Map<String, String> translationMap){
        Map<String, String> myNewHashMap = new HashMap<>();
        for(Map.Entry<String, String> entry : translationMap.entrySet()){
            myNewHashMap.put(entry.getValue(), entry.getKey());
        }
        return myNewHashMap;
    }
}
