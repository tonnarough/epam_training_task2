package by.epam.training.task2.dao.xmlwrite;

import by.epam.training.task2.entity.TabletPC;
import by.epam.training.task2.entity.criteria.SearchCriteria;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;

public class XMLTabletPCWriter implements XMLWriter<TabletPC> {

    @Override
    public void write(TabletPC appliance, String path) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(path);

        Element rootElement = document.getRootElement();

        Element tabletPCElement = new Element(SearchCriteria.TabletPC.TABLETPC.toString().toLowerCase());

        tabletPCElement.setAttribute(SearchCriteria.TabletPC.ID.toString().toLowerCase()
                , String.valueOf(appliance.getId()));

        tabletPCElement.addContent(new Element(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString().toLowerCase())
                .setText(String.valueOf(appliance.getBatteryCapacity())));

        tabletPCElement.addContent(new Element(SearchCriteria.TabletPC.DISPLAY_INCHES.toString().toLowerCase())
                .setText(String.valueOf(appliance.getDisplayInches())));

        tabletPCElement.addContent(new Element(SearchCriteria.TabletPC.MEMORY_ROM.toString().toLowerCase())
                .setText(String.valueOf(appliance.getMemoryRom())));

        tabletPCElement.addContent(new Element(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString().toLowerCase())
                .setText(String.valueOf(appliance.getFlashMemoryCapacity())));

        tabletPCElement.addContent(new Element(SearchCriteria.TabletPC.COLOR.toString().toLowerCase())
                .setText(String.valueOf(appliance.getColor())));

        rootElement.addContent(tabletPCElement);

        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        outputter.output(document, new FileOutputStream(path));
    }
}
