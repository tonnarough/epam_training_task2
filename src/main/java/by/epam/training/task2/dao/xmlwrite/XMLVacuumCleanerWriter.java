package by.epam.training.task2.dao.xmlwrite;

import by.epam.training.task2.entity.VacuumCleaner;
import by.epam.training.task2.entity.criteria.SearchCriteria;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;

public class XMLVacuumCleanerWriter implements XMLWriter<VacuumCleaner> {
    @Override
    public void write(VacuumCleaner appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(path);

        Element rootElement = document.getRootElement();

        Element vacuumCleanerElement = new Element(SearchCriteria.VacuumCleaner.VACUUMCLEANER.toString().toLowerCase());

        vacuumCleanerElement.setAttribute(SearchCriteria.VacuumCleaner.ID.toString().toLowerCase()
                , String.valueOf(appliance.getId()));

        vacuumCleanerElement.addContent(new Element(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString().toLowerCase())
                .setText(String.valueOf(appliance.getPowerConsumption())));

        vacuumCleanerElement.addContent(new Element(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString().toLowerCase())
                .setText(String.valueOf(appliance.getFilterType())));

        vacuumCleanerElement.addContent(new Element(SearchCriteria.VacuumCleaner.BAG_TYPE.toString().toLowerCase())
                .setText(String.valueOf(appliance.getBagType())));

        vacuumCleanerElement.addContent(new Element(SearchCriteria.VacuumCleaner.WAND_TYPE.toString().toLowerCase())
                .setText(String.valueOf(appliance.getWandType())));

        vacuumCleanerElement.addContent(new Element(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString().toLowerCase())
                .setText(String.valueOf(appliance.getMotorSpeedRegulation())));

        vacuumCleanerElement.addContent(new Element(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString().toLowerCase())
                .setText(String.valueOf(appliance.getCleaningWidth())));

        rootElement.addContent(vacuumCleanerElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
