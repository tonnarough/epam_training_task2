package by.epam.training.task2.dao.XMLWrite;

import by.epam.training.task2.entity.Appliance;
import org.jdom2.JDOMException;

import java.io.IOException;

public interface XMLWriter<T extends Appliance> {

    void write(T appliance, String path) throws IOException, JDOMException;

}