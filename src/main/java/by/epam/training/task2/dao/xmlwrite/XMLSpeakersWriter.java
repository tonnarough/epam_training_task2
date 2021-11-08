package by.epam.training.task2.dao.xmlwrite;

import by.epam.training.task2.entity.Speakers;
import by.epam.training.task2.entity.criteria.SearchCriteria;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.NodeList;

import java.io.*;

public class XMLSpeakersWriter implements XMLWriter<Speakers> {

    @Override
    public void write(Speakers appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(path);

        Element rootElement = document.getRootElement();

        Element speakersElement = new Element(SearchCriteria.Speakers.SPEAKERS.toString().toLowerCase());

        speakersElement.setAttribute(SearchCriteria.Speakers.ID.toString().toLowerCase()
                , String.valueOf(appliance.getId()));

        speakersElement.addContent(new Element(SearchCriteria.Speakers.POWER_CONSUMPTION.toString().toLowerCase())
                .setText(String.valueOf(appliance.getPowerConsumption())));

        speakersElement.addContent(new Element(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString().toLowerCase())
                .setText(String.valueOf(appliance.getNumberOfSpeakers())));

        speakersElement.addContent(new Element(SearchCriteria.Speakers.FREQUENCY_RANGE.toString().toLowerCase())
                .setText(String.valueOf(appliance.getFrequencyRange())));

        speakersElement.addContent(new Element(SearchCriteria.Speakers.CORD_LENGTH.toString().toLowerCase())
                .setText(String.valueOf(appliance.getCordLength())));

        rootElement.addContent(speakersElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
