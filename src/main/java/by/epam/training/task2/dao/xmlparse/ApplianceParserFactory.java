package by.epam.training.task2.dao.xmlparse;

import by.epam.training.task2.entity.*;

public final class ApplianceParserFactory implements ParserFactory {

    private XMLParser<Oven> ovenParser;
    private XMLParser<Laptop> laptopParser;
    private XMLParser<Refrigerator> refrigeratorParser;
    private XMLParser<Speakers> speakersParser;
    private XMLParser<TabletPC> tabletPCParser;
    private XMLParser<VacuumCleaner> vacuumCleanerParser;

    private ApplianceParserFactory() {
    }

    /**
     *Determine if the class represented, for example Oven.class, is the same as
     *the class represented by the specified Class parameter or its superclass.
     *To select a specific parser.
     * @param type Determines what type of parameter should be parsed.
     * @param <T> We accept the subclasses of the Appliance class.
     * @return Parser of a particular type.
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Appliance> XMLParser<T> parserFor(Class<T> type) {
        XMLParser<T> parser = null;

        if (Oven.class.isAssignableFrom(type)) {
            if (ovenParser == null) {
                ovenParser = new XMLOvenParser();
            }
            parser = (XMLParser<T>) ovenParser;

        } else if (Laptop.class.isAssignableFrom(type)) {
            if (laptopParser == null) {
                laptopParser = new XMLLaptopParser();
            }
            parser = (XMLParser<T>) laptopParser;

        } else if (Refrigerator.class.isAssignableFrom(type)) {
            if (refrigeratorParser == null) {
                refrigeratorParser = new XMLRefrigeratorParser();
            }
            parser = (XMLParser<T>) refrigeratorParser;

        } else if (Speakers.class.isAssignableFrom(type)) {
            if (speakersParser == null) {
                speakersParser = new XMLSpeakersParser();
            }
            parser = (XMLParser<T>) speakersParser;

        } else if (TabletPC.class.isAssignableFrom(type)) {
            if (tabletPCParser == null) {
                tabletPCParser = new XMLTabletPCParser();
            }
            parser = (XMLParser<T>) tabletPCParser;

        } else if (VacuumCleaner.class.isAssignableFrom(type)) {
            if (vacuumCleanerParser == null) {
                vacuumCleanerParser = new XMLVacuumCleanerParser();
            }
            parser = (XMLParser<T>) vacuumCleanerParser;
        }
        return parser;
    }

    public static ApplianceParserFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        public static final ApplianceParserFactory INSTANCE = new ApplianceParserFactory();
    }
}
