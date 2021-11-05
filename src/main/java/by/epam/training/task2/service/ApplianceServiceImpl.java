package by.epam.training.task2.service;

import by.epam.training.task2.dao.ApplianceDAO;
import by.epam.training.task2.dao.DAOFactory;
import by.epam.training.task2.entity.Appliance;
import by.epam.training.task2.entity.criteria.Criteria;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ApplianceServiceImpl implements ApplianceService {

    /**
     * We go through all the objects of the List and compare the expected value with the real value,
     * if they are not equal, then remove the object from the List.
     * @param criteria Is what we use to select suitable objects.
     * @param <T> We accept the subclasses of the Appliance class.
     * @return List of objects that match the search parameters.
     * @throws IOException
     * @throws JDOMException
     */
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

    /**
     *Transfer appliance to DAO layer.
     * @param appliance The object we want to write to XML.
     * @throws IOException
     * @throws JDOMException
     */
    @Override
    public void add(Appliance appliance) throws IOException, JDOMException {
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        applianceDAO.add(appliance);
    }
}


