package by.epam.training.task2.service;

import by.epam.training.task2.entity.Appliance;
import by.epam.training.task2.entity.criteria.Criteria;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public interface ApplianceService {

    <T extends Appliance> List<T> find(Criteria<T> criteria) throws IOException, JDOMException;

    void add(Appliance appliance) throws IOException, JDOMException;

}