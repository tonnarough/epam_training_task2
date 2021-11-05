package by.epam.training.task2.dao.XMLWrite;

import by.epam.training.task2.entity.Speakers;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;

public class XMLSpeakersWriter implements XMLWriter<Speakers> {

    @Override
    public void write(Speakers appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new File(path));

        Element rootElement = document.getRootElement();

        Element speakersElement = new Element("speakers");

        speakersElement.setAttribute("id", String.valueOf(appliance.getId()));

        speakersElement.addContent(new Element("powerConsumption")
                .setText(String.valueOf(appliance.getPowerConsumption())));

        speakersElement.addContent(new Element("numberOfSpeakers")
                .setText(String.valueOf(appliance.getNumberOfSpeakers())));

        speakersElement.addContent(new Element("frequencyRange")
                .setText(String.valueOf(appliance.getFrequencyRange())));

        speakersElement.addContent(new Element("cordLength")
                .setText(String.valueOf(appliance.getCordLength())));

        rootElement.addContent(speakersElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
