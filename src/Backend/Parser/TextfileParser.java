package Backend.Parser;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author: Louis Lee
 */

//Is this going to be used as a way to read in user defined commands

public class TextfileParser {

    public TextfileParser(String filepath){
        File file = new File(filepath);
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder dBuilder = dbf.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

        }
        catch (Exception e) {
            //Should Never happen - no response
        }
    }
}
