package by.epam.training.task2.entity.criteria;

public final class SearchCriteria {

    public static enum Oven{
        ID, POWER_CONSUMPTION, WEIGHT, CAPACITY, DEPTH, HEIGHT, WIDTH, OVEN
    }

    public static enum Laptop{
        ID, BATTERY_CAPACITY, OS, MEMORY_ROM, SYSTEM_MEMORY, CPU, DISPLAY_INCHS, LAPTOP
    }

    public static enum Refrigerator{
        ID, POWER_CONSUMPTION, WEIGHT, FREEZER_CAPACITY, OVERALL_CAPACITY, HEIGHT, WIDTH, REFRIGERATOR
    }

    public static enum VacuumCleaner{
        ID, POWER_CONSUMPTION, FILTER_TYPE, BAG_TYPE, WAND_TYPE,
        MOTOR_SPEED_REGULATION, CLEANING_WIDTH, VACUUMCLEANER
    }

    public static enum TabletPC{
        ID, BATTERY_CAPACITY, DISPLAY_INCHES, MEMORY_ROM, FLASH_MEMORY_CAPACITY, COLOR, TABLETPC
    }

    public static enum Speakers{
        ID, POWER_CONSUMPTION, NUMBER_OF_SPEAKERS, FREQUENCY_RANGE, CORD_LENGTH, SPEAKERS
    }

    private SearchCriteria() {}
}