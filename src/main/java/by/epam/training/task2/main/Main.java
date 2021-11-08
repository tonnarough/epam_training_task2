package by.epam.training.task2.main;

import by.epam.training.task2.entity.Laptop;
import by.epam.training.task2.entity.Oven;
import by.epam.training.task2.entity.Speakers;
import by.epam.training.task2.entity.criteria.Criteria;
import by.epam.training.task2.service.ApplianceService;
import by.epam.training.task2.service.ServiceFactory;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, JDOMException {

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService applianceService = factory.getApplianceService();

        final Criteria<Oven> ovenCriteria = Criteria.from(Oven.class)
                .with(Oven::getDepth, 60.0)
                .create();

        final Criteria<Laptop> laptopCriteria = Criteria.from(Laptop.class)
                .with(Laptop::getBatteryCapacity, 1.5)
                .and(Laptop::getCpu, 2.2)
                .and(Laptop::getMemoryRom, 8000.0)
                .create();

        final List<Oven> ovens = applianceService.find(ovenCriteria);
        ovens.forEach(System.out::println);

        final List<Laptop> laptops = applianceService.find(laptopCriteria);
        laptops.forEach(System.out::println);

        applianceService.add(new Speakers("Speakers",
                4, 20.0, 3.0, "4-6", 7.0));

        final Criteria<Speakers> speakersCriteria = Criteria.from(Speakers.class)
                .with(Speakers::getNumberOfSpeakers, 3.0)
                .and(Speakers::getCordLength, 7.0)
                .create();

        final List<Speakers> speakers = applianceService.find(speakersCriteria);
        speakers.forEach(System.out::println);


    }
}
