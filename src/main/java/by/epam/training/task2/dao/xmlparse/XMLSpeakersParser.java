package by.epam.training.task2.dao.xmlparse;

import by.epam.training.task2.entity.Speakers;
import by.epam.training.task2.entity.criteria.SearchCriteria;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class XMLSpeakersParser implements XMLParser<Speakers> {

    @Override
    public List<Speakers> parse(String path) throws IOException, JDOMException {
        return new SAXBuilder()
                .build(new InputSource(path))
                .getRootElement()
                .getChildren(SearchCriteria.Speakers.SPEAKERS.toString().toLowerCase())
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }

    @Override
    public Speakers convert(Element speakersElement) {
        Speakers speakers = new Speakers();

        speakers.setProductName(speakersElement.getName());

        speakers.setId(Integer.parseInt(speakersElement
                .getAttributeValue(SearchCriteria.Speakers.ID.toString().toLowerCase())));

        speakers.setPowerConsumption(Double.parseDouble(speakersElement
                .getChildText(SearchCriteria.Speakers.POWER_CONSUMPTION.toString().toLowerCase())));

        speakers.setNumberOfSpeakers(Double.parseDouble(speakersElement
                .getChildText(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString().toLowerCase())));

        speakers.setFrequencyRange(speakersElement
                .getChildText(SearchCriteria.Speakers.FREQUENCY_RANGE.toString().toLowerCase()));

        speakers.setCordLength(Double.parseDouble(speakersElement
                .getChildText(SearchCriteria.Speakers.CORD_LENGTH.toString().toLowerCase())));
        return speakers;
    }
}
