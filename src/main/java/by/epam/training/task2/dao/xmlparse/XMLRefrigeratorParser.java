package by.epam.training.task2.dao.xmlparse;

import by.epam.training.task2.entity.Refrigerator;
import by.epam.training.task2.entity.criteria.SearchCriteria;
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
                .getChildren(SearchCriteria.Refrigerator.REFRIGERATOR.toString().toLowerCase())
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }

    @Override
    public Refrigerator convert(Element refrigeratorElement) {
        Refrigerator refrigerator = new Refrigerator();

        refrigerator.setProductName(refrigeratorElement.getName());

        refrigerator.setId(Integer.parseInt(refrigeratorElement
                .getAttributeValue(SearchCriteria.Refrigerator.ID.toString().toLowerCase())));

        refrigerator.setPowerConsumption(Double.parseDouble(refrigeratorElement
                .getChildText(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString().toLowerCase())));

        refrigerator.setWidth(Double.parseDouble(refrigeratorElement
                .getChildText(SearchCriteria.Refrigerator.WEIGHT.toString().toLowerCase())));

        refrigerator.setFreezerCapacity(Double.parseDouble(refrigeratorElement
                .getChildText(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString().toLowerCase())));

        refrigerator.setOverallCapacity(Double.parseDouble(refrigeratorElement
                .getChildText(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString().toLowerCase())));

        refrigerator.setHeight(Double.parseDouble(refrigeratorElement
                .getChildText(SearchCriteria.Refrigerator.HEIGHT.toString().toLowerCase())));

        refrigerator.setWeight(Double.parseDouble(refrigeratorElement
                .getChildText(SearchCriteria.Refrigerator.WIDTH.toString().toLowerCase())));
        return refrigerator;
    }
}
