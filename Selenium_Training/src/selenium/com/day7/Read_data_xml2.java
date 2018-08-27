package selenium.com.day7;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Read_data_xml2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File("./Data/DataDriven_XML2.xml");
		try {
			FileInputStream ofile = new FileInputStream(file);

            DocumentBuilderFactory oFact = DocumentBuilderFactory.newInstance();

            DocumentBuilder obuild = oFact.newDocumentBuilder();

            Document oDoc = obuild.parse(ofile);

            NodeList oNodelist = oDoc.getElementsByTagName("student");

            System.out.println("Node List is : "+oNodelist.getLength());
 
            Node oNode = oNodelist.item(0);

            System.out.println("Node Name is : "+oNode.getNodeName());

            Element oElement = (Element) oNode;

            System.out.println(oElement.getTextContent());

            System.out.println("Name is : " + oElement.getElementsByTagName("firstname").item(0).getTextContent());
	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}


