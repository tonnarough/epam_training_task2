package by.epam.training.task2.dao.XMLWrite;

import by.epam.training.task2.entity.Laptop;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;

public class XMLLaptopWriter implements XMLWriter<Laptop> {

    @Override
    public void write(Laptop appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(path);

        Element rootElement = document.getRootElement();

        Element laptopElement = new Element("laptops");

        laptopElement.setAttribute("id", String.valueOf(appliance.getId()));

        laptopElement.addContent(new Element("batteryCapacity")
                .setText(String.valueOf(appliance.getBatteryCapacity())));

        laptopElement.addContent(new Element("os")
                .setText(String.valueOf(appliance.getOs())));

        laptopElement.addContent(new Element("memoryRom")
                .setText(String.valueOf(appliance.getMemoryRom())));

        laptopElement.addContent(new Element("systemMemory")
                .setText(String.valueOf(appliance.getSystemMemory())));

        laptopElement.addContent(new Element("cpu")
                .setText(String.valueOf(appliance.getCpu())));

        laptopElement.addContent(new Element("displayInchs")
                .setText(String.valueOf(appliance.getDisplayInchs())));

        rootElement.addContent(laptopElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
