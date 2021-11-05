package by.epam.training.task2.dao.XMLWrite;

import by.epam.training.task2.entity.TabletPC;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLTabletPCWriter implements XMLWriter<TabletPC> {

    @Override
    public void write(TabletPC appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new File(path));

        Element rootElement = document.getRootElement();

        Element tabletPCElement = new Element("tabletPCs");

        tabletPCElement.setAttribute("id", String.valueOf(appliance.getId()));

        tabletPCElement.addContent(new Element("batteryCapacity")
                .setText(String.valueOf(appliance.getBatteryCapacity())));

        tabletPCElement.addContent(new Element("displayInches")
                .setText(String.valueOf(appliance.getDisplayInches())));

        tabletPCElement.addContent(new Element("memoryRom")
                .setText(String.valueOf(appliance.getMemoryRom())));

        tabletPCElement.addContent(new Element("flashMemoryCapacity")
                .setText(String.valueOf(appliance.getFlashMemoryCapacity())));

        tabletPCElement.addContent(new Element("color")
                .setText(String.valueOf(appliance.getColor())));

        rootElement.addContent(tabletPCElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
