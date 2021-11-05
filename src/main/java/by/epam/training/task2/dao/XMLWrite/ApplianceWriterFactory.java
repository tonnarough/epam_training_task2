package by.epam.training.task2.dao.XMLWrite;

import by.epam.training.task2.entity.*;

public final class ApplianceWriterFactory implements WriterFactory {

    private XMLWriter<Oven> ovenWriter;
    private XMLWriter<Laptop> laptopWriter;
    private XMLWriter<Refrigerator> refrigeratorWriter;
    private XMLWriter<Speakers> speakersWriter;
    private XMLWriter<TabletPC> tabletPCWriter;
    private XMLWriter<VacuumCleaner> vacuumCleanerWriter;

    private ApplianceWriterFactory() {
    }

    /**
     * Depending on the type of object, we create Writer.
     * @param appliance The object we want to write to XML.
     * @param <T> We accept the subclasses of the Appliance class.
     * @return Writer.
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Appliance> XMLWriter<T> writeTo(Appliance appliance) {
        XMLWriter<T> writer = null;

        if (appliance instanceof Oven) {
            if (ovenWriter == null) {
                ovenWriter = new XMLOvenWriter();
            }
            writer = (XMLWriter<T>) ovenWriter;

        } else if (appliance instanceof Laptop) {
            if (laptopWriter == null) {
                laptopWriter = new XMLLaptopWriter();
            }
            writer = (XMLWriter<T>) laptopWriter;

        } else if (appliance instanceof Refrigerator) {
            if (refrigeratorWriter == null) {
                refrigeratorWriter = new XMLRefrigeratorWriter();
            }
            writer = (XMLWriter<T>) refrigeratorWriter;

        } else if (appliance instanceof Speakers) {
            if (speakersWriter == null) {
                speakersWriter = new XMLSpeakersWriter();
            }
            writer = (XMLWriter<T>) speakersWriter;

        } else if (appliance instanceof TabletPC) {
            if (tabletPCWriter == null) {
                tabletPCWriter = new XMLTabletPCWriter();
            }
            writer = (XMLWriter<T>) tabletPCWriter;

        } else if (appliance instanceof VacuumCleaner) {
            if (vacuumCleanerWriter == null) {
                vacuumCleanerWriter = new XMLVacuumCleanerWriter();
            }
            writer = (XMLWriter<T>) vacuumCleanerWriter;
        }
        return writer;
    }

    public static ApplianceWriterFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        public static final ApplianceWriterFactory INSTANCE = new ApplianceWriterFactory();
    }
}
