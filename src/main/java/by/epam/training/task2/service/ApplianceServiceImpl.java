package by.epam.training.task2.service;

import by.epam.training.task2.dao.ApplianceDAO;
import by.epam.training.task2.dao.ApplianceDAOImpl;
import by.epam.training.task2.dao.DAOFactory;
import by.epam.training.task2.dao.XMLWrite.*;
import by.epam.training.task2.entity.Appliance;
import by.epam.training.task2.entity.criteria.Criteria;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public <T extends Appliance> List<T> find(Criteria<T> criteria) throws IOException, JDOMException {
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        List<T> applianceList = applianceDAO.findAll(criteria);
        final Map<Function<T, Object>, Object> equalClauses = criteria.getEqualClauses();

        List<T> result = new ArrayList<>(applianceList);

        for (T appliance : applianceList) {
            boolean shouldRemain = true;
            for (Map.Entry<Function<T, Object>, Object> equalClause : equalClauses.entrySet()) {
                final Function<T, Object> getter = equalClause.getKey();
                final Object expectedValue = equalClause.getValue();
                if (!expectedValue.equals(getter.apply(appliance))) {
                    shouldRemain = false;
                    break;
                }
            }
            if (!shouldRemain) {
                result.remove(appliance);
            }
        }
        return result;
    }

    @Override
    public void add(Appliance appliance) throws IOException, JDOMException {
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        applianceDAO.add(appliance);
    }
}


