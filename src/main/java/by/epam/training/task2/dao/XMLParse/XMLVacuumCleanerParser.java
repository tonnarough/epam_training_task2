package by.epam.training.task2.dao.XMLParse;

import by.epam.training.task2.entity.VacuumCleaner;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class XMLVacuumCleanerParser implements XMLParser<VacuumCleaner> {

    @Override
    public List<VacuumCleaner> parse(String path) throws IOException, JDOMException {
        return new SAXBuilder()
                .build(new InputSource(path))
                .getRootElement()
                .getChildren()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }

    @Override
    public VacuumCleaner convert(Element vacuumCleanerElement) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setProductName(vacuumCleanerElement.getName());
        vacuumCleaner.setId(Integer.parseInt(vacuumCleanerElement.getAttributeValue("id")));
        vacuumCleaner.setPowerConsumption(Double.parseDouble(vacuumCleanerElement.getChildText("powerConsumption")));
        vacuumCleaner.setFilterType((vacuumCleanerElement.getChildText("filterType")));
        vacuumCleaner.setBagType(vacuumCleanerElement.getChildText("bagType"));
        vacuumCleaner.setWandType(vacuumCleanerElement.getChildText("wandType"));
        vacuumCleaner.setMotorSpeedRegulation(Double.parseDouble(vacuumCleanerElement.getChildText("motorSpeedRegulation")));
        vacuumCleaner.setCleaningWidth(Double.parseDouble(vacuumCleanerElement.getChildText("cleaningWidth")));
        return vacuumCleaner;
    }
}
