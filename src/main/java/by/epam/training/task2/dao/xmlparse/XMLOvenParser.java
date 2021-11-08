package by.epam.training.task2.dao.XMLParse;

import by.epam.training.task2.entity.Oven;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class XMLOvenParser implements XMLParser<Oven> {

    @Override
    public List<Oven> parse(String path) throws IOException, JDOMException {
        return new SAXBuilder()
                .build(new InputSource(path))
                .getRootElement()
                .getChildren()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Oven convert(Element ovenElement) {
        Oven oven = new Oven();
        oven.setProductName(ovenElement.getName());
        oven.setId(Integer.parseInt(ovenElement.getAttributeValue("id")));
        oven.setPowerConsumption(Double.parseDouble(ovenElement.getChildText("powerConsumption")));
        oven.setWidth(Double.parseDouble(ovenElement.getChildText("weight")));
        oven.setCapacity(Double.parseDouble(ovenElement.getChildText("capacity")));
        oven.setDepth(Double.parseDouble(ovenElement.getChildText("depth")));
        oven.setHeight(Double.parseDouble(ovenElement.getChildText("height")));
        oven.setWeight(Double.parseDouble(ovenElement.getChildText("width")));
        return oven;
    }
}
