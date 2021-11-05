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

    private final String ovenPath = "src/main/resources/oven.xml";
    private final String laptopPath = "src/main/resources/laptop.xml";
    private final String refrigeratorPath = "src/main/resources/refrigerator.xml";
    private final String speakersPath = "src/main/resources/speakers.xml";
    private final String tabletPCPath = "src/main/resources/tabletPC.xml";
    private final String vacuumCleanerPath = "src/main/resources/vacuumCleaner.xml";

    private final ParserFactory parserFactory = ParserFactory.instance();
    private final WriterFactory writerFactory = WriterFactory.instance();

    /**
     *Determining if the class represented, for example Oven.class, is the same as
     *the class represented by the specified Class parameter or its superclass.
     *To get a List of criteria object.
     * @param criteria The type of objects that we want to get from the XML for further sorting.
     * @param <T> We accept the subclasses of the Appliance class.
     * @return List of objects of Appliance subclass.
     * @throws IOException
     * @throws JDOMException
     */
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

    /**
     *Write the object to XML.
     * @param appliance The object we want to write to XML.
     * @throws IOException
     * @throws JDOMException
     */
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
