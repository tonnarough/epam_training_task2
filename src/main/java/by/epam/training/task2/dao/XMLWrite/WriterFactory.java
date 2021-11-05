package by.epam.training.task2.dao.XMLWrite;

import by.epam.training.task2.entity.Appliance;

public interface WriterFactory {

    <T extends Appliance> XMLWriter<T> writeTo(Appliance appliance);

    static WriterFactory instance() {
        return ApplianceWriterFactory.getInstance();
    }

}
