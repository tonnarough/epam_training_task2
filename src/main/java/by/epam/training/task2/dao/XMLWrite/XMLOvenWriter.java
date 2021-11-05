package by.epam.training.task2.dao.XMLWrite;

import by.epam.training.task2.entity.Oven;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLOvenWriter implements XMLWriter<Oven> {
    @Override
    public void write(Oven appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new File(path));

        Element rootElement = document.getRootElement();

        Element ovenElement = new Element("ovens");

        ovenElement.setAttribute("id", String.valueOf(appliance.getId()));

        ovenElement.addContent(new Element("powerConsumption")
                .setText(String.valueOf(appliance.getPowerConsumption())));

        ovenElement.addContent(new Element("weight")
                .setText(String.valueOf(appliance.getWeight())));

        ovenElement.addContent(new Element("capacity")
                .setText(String.valueOf(appliance.getCapacity())));

        ovenElement.addContent(new Element("depth")
                .setText(String.valueOf(appliance.getDepth())));

        ovenElement.addContent(new Element("height")
                .setText(String.valueOf(appliance.getHeight())));

        ovenElement.addContent(new Element("width")
                .setText(String.valueOf(appliance.getWidth())));

        rootElement.addContent(ovenElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
