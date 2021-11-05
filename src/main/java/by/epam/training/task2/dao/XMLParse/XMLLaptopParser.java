package by.epam.training.task2.dao.XMLParse;

import by.epam.training.task2.entity.Laptop;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class XMLLaptopParser implements XMLParser<Laptop> {

    @Override
    public List<Laptop> parse(String path) throws IOException, JDOMException {
        return new SAXBuilder()
                .build(new InputSource(path))
                .getRootElement()
                .getChildren()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }

    @Override
    public Laptop convert(Element laptopElement) {
        Laptop laptop = new Laptop();
        laptop.setProductName(laptopElement.getName());
        laptop.setId(Integer.parseInt(laptopElement.getAttributeValue("id")));
        laptop.setBatteryCapacity(Double.parseDouble(laptopElement.getChildText("batteryCapacity")));
        laptop.setOs(laptopElement.getChildText("os"));
        laptop.setMemoryRom(Double.parseDouble(laptopElement.getChildText("memoryRom")));
        laptop.setSystemMemory(Double.parseDouble(laptopElement.getChildText("systemMemory")));
        laptop.setCpu(Double.parseDouble(laptopElement.getChildText("cpu")));
        laptop.setDisplayInchs(Double.parseDouble(laptopElement.getChildText("displayInchs")));
        return laptop;
    }
}
