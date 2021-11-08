package by.epam.training.task2.service.validation;

import by.epam.training.task2.entity.Appliance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public final class Validator {

    private Validator(){

    }

    public static <T extends Appliance> List<T> findApplianceByCriteria(List<T> applianceList, Map<Function<T, Object>, Object> equalClauses){
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
}
