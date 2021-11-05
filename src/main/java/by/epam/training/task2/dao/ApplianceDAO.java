package by.epam.training.task2.dao;

import by.epam.training.task2.entity.Appliance;
import by.epam.training.task2.entity.criteria.Criteria;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public interface ApplianceDAO {

    <T extends Appliance> List<T> findAll(Criteria<T> criteria) throws IOException, JDOMException;

    void add(Appliance appliance) throws IOException, JDOMException;

}