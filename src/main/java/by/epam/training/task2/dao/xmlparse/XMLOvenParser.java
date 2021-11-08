package by.epam.training.task2.dao.xmlparse;

import by.epam.training.task2.entity.Oven;
import by.epam.training.task2.entity.criteria.SearchCriteria;
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
                .getChildren(SearchCriteria.Oven.OVEN.toString().toLowerCase())
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Oven convert(Element ovenElement) {
        Oven oven = new Oven();

        oven.setProductName(ovenElement.getName());

        oven.setId(Integer.parseInt(ovenElement
                .getAttributeValue(SearchCriteria.Oven.ID.toString().toLowerCase())));

        oven.setPowerConsumption(Double.parseDouble(ovenElement
                .getChildText(SearchCriteria.Oven.POWER_CONSUMPTION.toString().toLowerCase())));

        oven.setWidth(Double.parseDouble(ovenElement
                .getChildText(SearchCriteria.Oven.WIDTH.toString().toLowerCase())));

        oven.setCapacity(Double.parseDouble(ovenElement
                .getChildText(SearchCriteria.Oven.CAPACITY.toString().toLowerCase())));

        oven.setDepth(Double.parseDouble(ovenElement
                .getChildText(SearchCriteria.Oven.DEPTH.toString().toLowerCase())));

        oven.setHeight(Double.parseDouble(ovenElement
                .getChildText(SearchCriteria.Oven.HEIGHT.toString().toLowerCase())));

        oven.setWeight(Double.parseDouble(ovenElement
                .getChildText(SearchCriteria.Oven.WEIGHT.toString().toLowerCase())));
        return oven;
    }
}
