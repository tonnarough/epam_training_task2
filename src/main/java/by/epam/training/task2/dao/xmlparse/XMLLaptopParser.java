package by.epam.training.task2.dao.xmlparse;

import by.epam.training.task2.entity.Laptop;
import by.epam.training.task2.entity.criteria.SearchCriteria;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class XMLLaptopParser implements XMLParser<Laptop> {

    @Override
    public List<Laptop> parse(String path) throws IOException, JDOMException {
        return new SAXBuilder()
                .build(new InputSource(path))
                .getRootElement()
                .getChildren(SearchCriteria.Laptop.LAPTOP.toString().toLowerCase())
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }

    @Override
    public Laptop convert(Element laptopElement) {
        Laptop laptop = new Laptop();

        laptop.setProductName(laptopElement.getName());

        laptop.setId(Integer.parseInt(laptopElement.
                getAttributeValue(SearchCriteria.Laptop.ID.toString().toLowerCase())));

        laptop.setBatteryCapacity(Double.parseDouble(laptopElement
                .getChildText(SearchCriteria.Laptop.BATTERY_CAPACITY.toString().toLowerCase())));

        laptop.setOs(laptopElement.getChildText(SearchCriteria.Laptop.OS.toString().toLowerCase()));

        laptop.setMemoryRom(Double.parseDouble(laptopElement
                .getChildText(SearchCriteria.Laptop.MEMORY_ROM.toString().toLowerCase())));

        laptop.setSystemMemory(Double.parseDouble(laptopElement
                .getChildText(SearchCriteria.Laptop.SYSTEM_MEMORY.toString().toLowerCase())));

        laptop.setCpu(Double.parseDouble(laptopElement
                .getChildText(SearchCriteria.Laptop.CPU.toString().toLowerCase())));

        laptop.setDisplayInchs(Double.parseDouble(laptopElement
                .getChildText(SearchCriteria.Laptop.DISPLAY_INCHS.toString().toLowerCase())));
        return laptop;
    }
}
