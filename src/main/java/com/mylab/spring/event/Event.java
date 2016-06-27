package com.mylab.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Component("event")
@Scope("prototype")
@Lazy
public class Event {

    private static final Random RANDOMIZER = new Random();

    private final long id;
    private final Date creationDate;
    private final DateFormat dateFormat;
    private String event;
    private EventType type;

    @Autowired
    public Event(Date creationDate, @Qualifier("dateTime")DateFormat dateFormat) {
        this.creationDate = creationDate;
        this.dateFormat = dateFormat;
        id = RANDOMIZER.nextInt(Integer.MAX_VALUE);
    }

    public String getStringEvent() {
        return event;
    }

    public void setStringEvent(String event) {
        this.event = event;
    }

    public EventType getType() {
        return type;
    }

    @Value("INFO")
    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s: #%d {%s} occurred %s",
                Optional.ofNullable(type).map(Enum::name).orElse("Event"),
                id, event, dateFormat.format(creationDate));
    }
}
