package by.epam.training.task2.dao.xmlparse;

import by.epam.training.task2.entity.Appliance;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public interface XMLParser<T extends Appliance> {

    List<T> parse(String path) throws IOException, JDOMException;

    T convert(Element element);

}
