package by.epam.training.task2.dao.XMLParse;

import by.epam.training.task2.entity.Refrigerator;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class XMLRefrigeratorParser implements XMLParser<Refrigerator> {

    @Override
    public List<Refrigerator> parse(String path) throws IOException, JDOMException {
        return new SAXBuilder()
                .build(new InputSource(path))
                .getRootElement()
                .getChildren()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }

    @Override
    public Refrigerator convert(Element refrigeratorElement) {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setProductName(refrigeratorElement.getName());
        refrigerator.setId(Integer.parseInt(refrigeratorElement.getAttributeValue("id")));
        refrigerator.setPowerConsumption(Double.parseDouble(refrigeratorElement.getChildText("powerConsumption")));
        refrigerator.setWidth(Double.parseDouble(refrigeratorElement.getChildText("weight")));
        refrigerator.setFreezerCapacity(Double.parseDouble(refrigeratorElement.getChildText("freezerCapacity")));
        refrigerator.setOverallCapacity(Double.parseDouble(refrigeratorElement.getChildText("overallCapacity")));
        refrigerator.setHeight(Double.parseDouble(refrigeratorElement.getChildText("height")));
        refrigerator.setWeight(Double.parseDouble(refrigeratorElement.getChildText("width")));
        return refrigerator;
    }
}
