package by.epam.training.task2.dao.XMLWrite;

import by.epam.training.task2.entity.Refrigerator;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLRefrigeratorWriter implements XMLWriter<Refrigerator> {
    @Override
    public void write(Refrigerator appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new File(path));

        Element rootElement = document.getRootElement();

        Element refrigeratorElement = new Element("refrigerators");

        refrigeratorElement.setAttribute("id", String.valueOf(appliance.getId()));

        refrigeratorElement.addContent(new Element("powerConsumption")
                .setText(String.valueOf(appliance.getPowerConsumption())));

        refrigeratorElement.addContent(new Element("weight")
                .setText(String.valueOf(appliance.getWeight())));

        refrigeratorElement.addContent(new Element("freezerCapacity")
                .setText(String.valueOf(appliance.getFreezerCapacity())));

        refrigeratorElement.addContent(new Element("overallCapacity")
                .setText(String.valueOf(appliance.getOverallCapacity())));

        refrigeratorElement.addContent(new Element("height")
                .setText(String.valueOf(appliance.getHeight())));

        refrigeratorElement.addContent(new Element("width")
                .setText(String.valueOf(appliance.getWidth())));

        rootElement.addContent(refrigeratorElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
