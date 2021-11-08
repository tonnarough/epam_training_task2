package by.epam.training.task2.dao.xmlparse;

import by.epam.training.task2.entity.VacuumCleaner;
import by.epam.training.task2.entity.criteria.SearchCriteria;
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
                .getChildren(SearchCriteria.VacuumCleaner.VACUUMCLEANER.toString().toLowerCase())
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }

    @Override
    public VacuumCleaner convert(Element vacuumCleanerElement) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();

        vacuumCleaner.setProductName(vacuumCleanerElement.getName());

        vacuumCleaner.setId(Integer.parseInt(vacuumCleanerElement
                .getAttributeValue(SearchCriteria.VacuumCleaner.ID.toString().toLowerCase())));

        vacuumCleaner.setPowerConsumption(Double.parseDouble(vacuumCleanerElement
                .getChildText(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString().toLowerCase())));

        vacuumCleaner.setFilterType((vacuumCleanerElement
                .getChildText(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString().toLowerCase())));

        vacuumCleaner.setBagType(vacuumCleanerElement
                .getChildText(SearchCriteria.VacuumCleaner.BAG_TYPE.toString().toLowerCase()));

        vacuumCleaner.setWandType(vacuumCleanerElement
                .getChildText(SearchCriteria.VacuumCleaner.WAND_TYPE.toString().toLowerCase()));

        vacuumCleaner.setMotorSpeedRegulation(Double.parseDouble(vacuumCleanerElement
                .getChildText(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString().toLowerCase())));

        vacuumCleaner.setCleaningWidth(Double.parseDouble(vacuumCleanerElement
                .getChildText(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString().toLowerCase())));
        return vacuumCleaner;
    }
}
