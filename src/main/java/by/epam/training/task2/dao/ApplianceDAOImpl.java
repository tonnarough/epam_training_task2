package by.epam.training.task2.dao;

import by.epam.training.task2.dao.XMLParse.*;
import by.epam.training.task2.dao.XMLWrite.WriterFactory;
import by.epam.training.task2.dao.XMLWrite.XMLWriter;
import by.epam.training.task2.entity.*;
import by.epam.training.task2.entity.criteria.Criteria;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

    private String ovenPath = "src/main/resources/oven.xml";
    private String laptopPath = "src/main/resources/laptop.xml";
    private String refrigeratorPath = "src/main/resources/refrigerator.xml";
    private String speakersPath = "src/main/resources/speakers.xml";
    private String tabletPCPath = "src/main/resources/tabletPC.xml";
    private String vacuumCleanerPath = "src/main/resources/vacuumCleaner.xml";

    private final ParserFactory parserFactory = ParserFactory.instance();
    private final WriterFactory writerFactory = WriterFactory.instance();

    @Override
    public <T extends Appliance> List<T> findAll(Criteria<T> criteria) throws IOException, JDOMException {
        XMLParser<T> parser;
        final Class<T> searchType = criteria.getSearchType();

        if (Oven.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(ovenPath);

        } else if (Laptop.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(laptopPath);

        } else if (Refrigerator.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(refrigeratorPath);

        } else if (Speakers.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(speakersPath);

        } else if (TabletPC.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(tabletPCPath);

        } else if (VacuumCleaner.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(vacuumCleanerPath);

        }
        return null;
    }

    @Override
    public void add(Appliance appliance) throws IOException, JDOMException {
        XMLWriter writer = null;

        if (appliance instanceof Oven) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, ovenPath);

        } else if (appliance instanceof Laptop) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, laptopPath);

        } else if (appliance instanceof Refrigerator) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, refrigeratorPath);

        } else if (appliance instanceof Speakers) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, speakersPath);

        } else if (appliance instanceof TabletPC) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, tabletPCPath);

        } else if (appliance instanceof VacuumCleaner) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, vacuumCleanerPath);

        }
    }
}
