package by.epam.training.task2.dao.xmlwrite;

import by.epam.training.task2.entity.Oven;
import by.epam.training.task2.entity.criteria.SearchCriteria;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;

public class XMLOvenWriter implements XMLWriter<Oven> {
    @Override
    public void write(Oven appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(path);

        Element rootElement = document.getRootElement();

        Element ovenElement = new Element(SearchCriteria.Oven.OVEN.toString().toLowerCase());

        ovenElement.setAttribute(SearchCriteria.Oven.ID.toString().toLowerCase()
                , String.valueOf(appliance.getId()));

        ovenElement.addContent(new Element(SearchCriteria.Oven.POWER_CONSUMPTION.toString().toLowerCase())
                .setText(String.valueOf(appliance.getPowerConsumption())));

        ovenElement.addContent(new Element(SearchCriteria.Oven.WEIGHT.toString().toLowerCase())
                .setText(String.valueOf(appliance.getWeight())));

        ovenElement.addContent(new Element(SearchCriteria.Oven.CAPACITY.toString().toLowerCase())
                .setText(String.valueOf(appliance.getCapacity())));

        ovenElement.addContent(new Element(SearchCriteria.Oven.DEPTH.toString().toLowerCase())
                .setText(String.valueOf(appliance.getDepth())));

        ovenElement.addContent(new Element(SearchCriteria.Oven.HEIGHT.toString().toLowerCase())
                .setText(String.valueOf(appliance.getHeight())));

        ovenElement.addContent(new Element(SearchCriteria.Oven.WIDTH.toString().toLowerCase())
                .setText(String.valueOf(appliance.getWidth())));

        rootElement.addContent(ovenElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
