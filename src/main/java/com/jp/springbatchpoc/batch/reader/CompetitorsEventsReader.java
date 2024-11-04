package com.jp.springbatchpoc.batch.reader;

import com.jp.springbatchpoc.model.entity.CompetitorsEvents;
import com.jp.springbatchpoc.repository.CompetitorsEventsRepository;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

@RequiredArgsConstructor
public class CompetitorsEventsReader implements ItemReader<CompetitorsEvents> {

    private final CompetitorsEventsRepository competitorsEventsRepository;
    private List<CompetitorsEvents> competitorsEvents;

    @Override
    public CompetitorsEvents read()
            throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (competitorsEvents == null) {
            competitorsEvents = competitorsEventsRepository.findAll();
            competitorsEvents.sort(Comparator.comparing(ce -> ce.getEvent().getEventId()));
        }

        if (!competitorsEvents.isEmpty()) {
            return competitorsEvents.remove(0);
        }

        return null;
    }
}
