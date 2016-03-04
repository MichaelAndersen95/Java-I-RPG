package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;

class XMLHandler {
    private final UI ui = new UI();
    private String fileName = "HighScores.xml";

    /**
     * Writes high scores to HighScores.xml
     * @param highScoreList list of high scores
     */
    public void writeXML(List<HighScore> highScoreList) {
        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("HighScores");
            document.appendChild(rootElement);

            //loops through highScoreList
            for (HighScore aHighScoreList : highScoreList) {

                rootElement.appendChild(getHighScore(document, aHighScoreList.getId(),
                        aHighScoreList.getName(), aHighScoreList.getScore(),
                        aHighScoreList.getKills()));
            }

            document.normalize();

            //write to file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(fileName));

            transformer.transform(source, result);

            ui.print("\n"+fileName+" saved\n\n");

        } catch (ParserConfigurationException | TransformerException e) {
            ui.print("Error writing "+fileName);
        }
    }

    /**
     *
     * @param doc document
     * @param id the players id
     * @param name the players name
     * @param score the players score
     * @param kills the players kills
     * @return highScore object
     */
    private Node getHighScore(Document doc, String id, String name, Integer score, Integer kills) {
        Element highScore = doc.createElement("HighScore");
        highScore.setAttribute("id", id);
        highScore.appendChild(getHighScoreElements(doc, highScore, "Player", name));
        highScore.appendChild(getHighScoreElements(doc, highScore, "Score", score.toString()));
        highScore.appendChild(getHighScoreElements(doc, highScore, "Kills", kills.toString()));
        return highScore;
    }

    /**
     *
     * @param doc document
     * @param element element
     * @param name element name
     * @param value element value
     * @return
     */
    // utility method to create text node
    private Node getHighScoreElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    /**
     * reads the content of HighScores.xml
     */
    public void readXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;
            document = builder.parse(new File(fileName));

            //Get all high scores
            NodeList nodeList = document.getElementsByTagName("HighScore");
            ui.print("============================\n");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                ui.print(""); //separator
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    //print details for each high score
                    Element element = (Element) node;
                    ui.print("\nHigh Score id: " + element.getAttribute("id"));
                    ui.print("\nPlayer: " + element.getElementsByTagName("Player").item(0).getTextContent());
                    ui.print("\nScore: " + element.getElementsByTagName("Score").item(0).getTextContent());
                    ui.print("\nKills: " + element.getElementsByTagName("Kills").item(0).getTextContent()+"\n");
                }

            }
            ui.print("\n\n");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            ui.print("Couldn't find file "+fileName+"\n");
        } catch (ParserConfigurationException e) {
            ui.print("Error when reading "+fileName);
        }


    }
}
