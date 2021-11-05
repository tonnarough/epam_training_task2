package by.epam.training.task2.dao.XMLWrite;

import by.epam.training.task2.entity.VacuumCleaner;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLVacuumCleanerWriter implements XMLWriter<VacuumCleaner> {
    @Override
    public void write(VacuumCleaner appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new File(path));

        Element rootElement = document.getRootElement();

        Element vacuumCleanerElement = new Element("vacuumCleaners");

        vacuumCleanerElement.setAttribute("id", String.valueOf(appliance.getId()));

        vacuumCleanerElement.addContent(new Element("powerConsumption")
                .setText(String.valueOf(appliance.getPowerConsumption())));

        vacuumCleanerElement.addContent(new Element("filterType")
                .setText(String.valueOf(appliance.getFilterType())));

        vacuumCleanerElement.addContent(new Element("bagType")
                .setText(String.valueOf(appliance.getBagType())));

        vacuumCleanerElement.addContent(new Element("wandType")
                .setText(String.valueOf(appliance.getWandType())));

        vacuumCleanerElement.addContent(new Element("motorSpeedRegulation")
                .setText(String.valueOf(appliance.getMotorSpeedRegulation())));

        vacuumCleanerElement.addContent(new Element("cleaningWidth")
                .setText(String.valueOf(appliance.getCleaningWidth())));

        rootElement.addContent(vacuumCleanerElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
