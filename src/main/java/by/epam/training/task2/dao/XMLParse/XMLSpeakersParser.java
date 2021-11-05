package by.epam.training.task2.dao.XMLParse;

import by.epam.training.task2.entity.Speakers;
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
                .getChildren()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }

    @Override
    public Speakers convert(Element speakersElement) {
        Speakers speakers = new Speakers();
        speakers.setProductName(speakersElement.getName());
        speakers.setId(Integer.parseInt(speakersElement.getAttributeValue("id")));
        speakers.setPowerConsumption(Double.parseDouble(speakersElement.getChildText("powerConsumption")));
        speakers.setNumberOfSpeakers(Double.parseDouble(speakersElement.getChildText("numberOfSpeakers")));
        speakers.setFrequencyRange(speakersElement.getChildText("frequencyRange"));
        speakers.setCordLength(Double.parseDouble(speakersElement.getChildText("cordLength")));
        return speakers;
    }
}
