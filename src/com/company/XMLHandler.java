package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

class XMLHandler {
    private final UI ui = new UI();

    public void writeXML(String playerName, Integer playerScore, Integer playerKills) {
        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("highscores");
            document.appendChild(rootElement);

            Element highScore = document.createElement("highscore");
            rootElement.appendChild(highScore);
            highScore.setAttribute("id", "1");

            //player element
            Element player = document.createElement("Player");
            player.appendChild(document.createTextNode(playerName));
            highScore.appendChild(player);

            //score element
            Element score = document.createElement("Score");
            score.appendChild(document.createTextNode(playerScore.toString()));
            highScore.appendChild(score);

            //kills element
            Element kills = document.createElement("Kills");
            kills.appendChild(document.createTextNode(playerKills.toString()));
            highScore.appendChild(kills);

            //write to file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("highscores.xml"));

            transformer.transform(source, result);

            ui.print("File saved");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public void readXML() throws ParserConfigurationException {
        try {


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document;


            document = builder.parse(new File("highscores.xml"));


            //Get all high scores
            NodeList nodeList = document.getElementsByTagName("highscore");
            ui.print("============================");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                ui.print(""); //separator
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    //print details for each high score
                    Element element = (Element) node;
                    ui.print("High Score id: " + element.getAttribute("id"));
                    ui.print("Player: " + element.getElementsByTagName("player").item(0).getTextContent());
                    ui.print("Score: " + element.getElementsByTagName("score").item(0).getTextContent());
                    ui.print("Kills: " + element.getElementsByTagName("kills").item(0).getTextContent());
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            ui.print("Couldn't find file highscores.xml\n");
        }


    }
}
