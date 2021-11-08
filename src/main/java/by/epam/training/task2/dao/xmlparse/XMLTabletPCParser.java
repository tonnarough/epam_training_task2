package by.epam.training.task2.dao.XMLParse;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;
import by.epam.training.task2.entity.TabletPC;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class XMLTabletPCParser implements XMLParser<TabletPC> {

    @Override
    public List<TabletPC> parse(String path) throws IOException, JDOMException {
        return new SAXBuilder()
                .build(new InputSource(path))
                .getRootElement()
                .getChildren()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }

    @Override
    public TabletPC convert(Element tabletPCElement) {
        TabletPC tabletPC = new TabletPC();
        tabletPC.setProductName(tabletPCElement.getName());
        tabletPC.setId(Integer.parseInt(tabletPCElement.getAttributeValue("id")));
        tabletPC.setBatteryCapacity(Double.parseDouble(tabletPCElement.getChildText("batteryCapacity")));
        tabletPC.setDisplayInches(Double.parseDouble(tabletPCElement.getChildText("displayInches")));
        tabletPC.setMemoryRom(Double.parseDouble(tabletPCElement.getChildText("memoryRom")));
        tabletPC.setFlashMemoryCapacity(Double.parseDouble(tabletPCElement.getChildText("flashMemoryCapacity")));
        tabletPC.setColor(tabletPCElement.getChildText("color"));
        return tabletPC;
    }
}
