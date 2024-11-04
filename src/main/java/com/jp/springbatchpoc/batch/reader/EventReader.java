package com.jp.springbatchpoc.batch.reader;

import com.jp.springbatchpoc.model.entity.Event;
import com.jp.springbatchpoc.model.enums.EventStatuses;
import com.jp.springbatchpoc.repository.EventRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

@RequiredArgsConstructor
public class EventReader implements ItemReader<Event> {

    private final EventRepository eventRepository;
    private List<Event> events;

    @Override
    public Event read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (events == null) {
            events = eventRepository.findAll();
            // For now, only return events between now and June 1, 2020
            events.removeIf(event -> event.getScheduledTime().isAfter(LocalDateTime.now())
                    || event.getScheduledTime().isBefore(LocalDateTime.of(2020, 6, 1, 0, 0))
                    || !event.getEventStatus().getEventStatusCode().equals(EventStatuses.FINAL.getStatusCode()));
        }

        if (!events.isEmpty()) {
            return events.remove(0);
        }

        return null;
    }
}
