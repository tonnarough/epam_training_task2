package by.epam.training.task2.dao.xmlwrite;

import by.epam.training.task2.entity.Refrigerator;
import by.epam.training.task2.entity.criteria.SearchCriteria;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;

public class XMLRefrigeratorWriter implements XMLWriter<Refrigerator> {
    @Override
    public void write(Refrigerator appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(path);

        Element rootElement = document.getRootElement();

        Element refrigeratorElement = new Element(SearchCriteria.Refrigerator.REFRIGERATOR.toString().toLowerCase());

        refrigeratorElement.setAttribute(SearchCriteria.Refrigerator.ID.toString().toLowerCase()
                , String.valueOf(appliance.getId()));

        refrigeratorElement.addContent(new Element(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString().toLowerCase())
                .setText(String.valueOf(appliance.getPowerConsumption())));

        refrigeratorElement.addContent(new Element(SearchCriteria.Refrigerator.WEIGHT.toString().toLowerCase())
                .setText(String.valueOf(appliance.getWeight())));

        refrigeratorElement.addContent(new Element(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString().toLowerCase())
                .setText(String.valueOf(appliance.getFreezerCapacity())));

        refrigeratorElement.addContent(new Element(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString().toLowerCase())
                .setText(String.valueOf(appliance.getOverallCapacity())));

        refrigeratorElement.addContent(new Element(SearchCriteria.Refrigerator.HEIGHT.toString().toLowerCase())
                .setText(String.valueOf(appliance.getHeight())));

        refrigeratorElement.addContent(new Element(SearchCriteria.Refrigerator.WIDTH.toString().toLowerCase())
                .setText(String.valueOf(appliance.getWidth())));

        rootElement.addContent(refrigeratorElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
