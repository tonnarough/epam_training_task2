package by.epam.training.task2.dao;

import by.epam.training.task2.dao.xmlparse.*;
import by.epam.training.task2.dao.xmlwrite.WriterFactory;
import by.epam.training.task2.dao.xmlwrite.XMLWriter;
import by.epam.training.task2.entity.*;
import by.epam.training.task2.entity.criteria.Criteria;
import org.jdom2.JDOMException;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ApplianceDAOImpl implements ApplianceDAO {

    ClassLoader classLoader = ApplianceDAOImpl.class.getClassLoader();
    private final String path = new File(Objects.requireNonNull(classLoader
            .getResource("appliances.xml")).getFile()).toString();

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
            return parser.parse(path);

        } else if (Laptop.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(path);

        } else if (Refrigerator.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(path);

        } else if (Speakers.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(path);

        } else if (TabletPC.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(path);

        } else if (VacuumCleaner.class.isAssignableFrom(searchType)) {
            parser = parserFactory.parserFor(searchType);
            return parser.parse(path);

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
            writer.write(appliance, path);

        } else if (appliance instanceof Laptop) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, path);

        } else if (appliance instanceof Refrigerator) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, path);

        } else if (appliance instanceof Speakers) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, path);

        } else if (appliance instanceof TabletPC) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, path);

        } else if (appliance instanceof VacuumCleaner) {
            writer = writerFactory.writeTo(appliance);
            writer.write(appliance, path);

        }
    }
}
