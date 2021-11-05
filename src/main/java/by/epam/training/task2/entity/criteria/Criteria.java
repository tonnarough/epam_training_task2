package by.epam.training.task2.entity.criteria;

import by.epam.training.task2.entity.Appliance;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Criteria<T extends Appliance> {

    /**
     * The object we want to find.
     */
    private final Class<T> searchType;

    /**
     * Contains a specific field and a corresponding value
     */
    private final Map<Function<T, Object>, Object> equalClauses;

    private Criteria(Class<T> searchType) {
        this.searchType = searchType;
        this.equalClauses = Collections.emptyMap();
    }

    private Criteria(Class<T> searchType, Map<Function<T, Object>, Object> equalClauses) {
        this.searchType = searchType;
        this.equalClauses = equalClauses;
    }

    public Class<T> getSearchType() {
        return searchType;
    }

    public Map<Function<T, Object>, Object> getEqualClauses() {
        return equalClauses;
    }

    public static <T extends Appliance> SearchTypeBuilder<T> from(Class<T> searchType) {
        return new SearchTypeBuilder<>(searchType);
    }

    /**
     *Pattern Builder with searchType.
     * @param <T> The object we want to write to XML.
     */
    public static final class SearchTypeBuilder<T extends Appliance> {
        private final Class<T> searchType;

        private SearchTypeBuilder(Class<T> searchType) {
            this.searchType = searchType;
        }

        @SuppressWarnings("unchecked")
        public <E> EqualSearchTypeBuilder<T> with(Function<T, E> getter, E checkValue) {
            final Map<Function<T, Object>, Object> clauses = new HashMap<>();
            clauses.put((Function<T, Object>) getter, checkValue);
            return new EqualSearchTypeBuilder<>(searchType, clauses);
        }

        public Criteria<T> create() {
            return new Criteria<>(searchType);
        }
    }

    /**
     *Pattern Builder with searchType and equalClauses.
     * @param <T> The object we want to write to XML.
     */
    public static final class EqualSearchTypeBuilder<T extends Appliance> {
        private final Class<T> searchType;
        private final Map<Function<T, Object>, Object> equalClauses;

        private EqualSearchTypeBuilder(Class<T> searchType, Map<Function<T, Object>, Object> equalClauses) {
            this.searchType = searchType;
            this.equalClauses = equalClauses;
        }

        @SuppressWarnings("unchecked")
        public <E> EqualSearchTypeBuilder<T> and(Function<T, E> getter, E checkValue) {
            equalClauses.put((Function<T, Object>) getter, checkValue);
            return this;
        }

        public Criteria<T> create() {
            return new Criteria<>(searchType, equalClauses);
        }
    }
}
