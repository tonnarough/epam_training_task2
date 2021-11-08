package by.epam.training.task2.dao.xmlparse;

import by.epam.training.task2.entity.criteria.SearchCriteria;
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
                .getChildren(SearchCriteria.TabletPC.TABLETPC.toString().toLowerCase())
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }

    @Override
    public TabletPC convert(Element tabletPCElement) {
        TabletPC tabletPC = new TabletPC();

        tabletPC.setProductName(tabletPCElement.getName());

        tabletPC.setId(Integer.parseInt(tabletPCElement
                .getAttributeValue(SearchCriteria.TabletPC.ID.toString().toLowerCase())));

        tabletPC.setBatteryCapacity(Double.parseDouble(tabletPCElement
                .getChildText(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString().toLowerCase())));

        tabletPC.setDisplayInches(Double.parseDouble(tabletPCElement
                .getChildText(SearchCriteria.TabletPC.DISPLAY_INCHES.toString().toLowerCase())));

        tabletPC.setMemoryRom(Double.parseDouble(tabletPCElement
                .getChildText(SearchCriteria.TabletPC.MEMORY_ROM.toString().toLowerCase())));

        tabletPC.setFlashMemoryCapacity(Double.parseDouble(tabletPCElement
                .getChildText(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString().toLowerCase())));

        tabletPC.setColor(tabletPCElement
                .getChildText(SearchCriteria.TabletPC.COLOR.toString().toLowerCase()));
        return tabletPC;
    }
}
