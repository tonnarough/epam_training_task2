package by.epam.training.task2.dao.xmlparse;

import by.epam.training.task2.entity.Appliance;

public interface ParserFactory {

    <T extends Appliance> XMLParser<T> parserFor(Class<T> type);

    static ParserFactory instance() {
        return ApplianceParserFactory.getInstance();
    }

}
