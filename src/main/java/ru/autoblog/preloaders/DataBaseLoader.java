package ru.autoblog.preloaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.autoblog.model.AutoEvent;
import ru.autoblog.model.AutoEventMaintenance;
import ru.autoblog.model.AutoEventRefueling;
import ru.autoblog.model.AutoEventType;
import ru.autoblog.services.AutoEventService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataBaseLoader
implements CommandLineRunner
{
    private static final boolean isAddValues = true;

    private final AutoEventService autoEventService;

    @Autowired
    public DataBaseLoader(
        AutoEventService autoEventService)
    {
        this.autoEventService = autoEventService;
    }

    @Override
    public void run(
        String... args)
    throws Exception
    {
        if (!isAddValues)
        {
            return;
        }

        List<AutoEvent> autoEvents = new ArrayList<>();

        AutoEventRefueling event;
        event = new AutoEventRefueling();
        event.setEventDate(LocalDateTime.of(2021,2, 5, 0, 0));
        event.setAutoEventType(AutoEventType.REFUELING);
        event.setMileage(230145L);
        event.setPscPrice(45.8);
        event.setValue(33.3);
        event.setPrice(1525.14);
        event.setArrageValue(15.5);
        event.setIsFull(true);
        autoEvents.add(event);

        AutoEventMaintenance eventMaintenance = new AutoEventMaintenance();
        eventMaintenance.setEventDate(LocalDateTime.of(2021, 2, 7, 0, 0));
        eventMaintenance.setAutoEventType(AutoEventType.MAINTENANCE);
        eventMaintenance.setMileage(230396L);
        eventMaintenance.setPrice(4480.0);
        eventMaintenance.setComment("Замена масла, масляного и воздушного фильтров.");
        autoEvents.add(eventMaintenance);

        event = new AutoEventRefueling();
        event.setEventDate(LocalDateTime.of(2021,2, 10, 0, 0));
        event.setAutoEventType(AutoEventType.REFUELING);
        event.setMileage(230679L);
        event.setPscPrice(45.8);
        event.setValue(12.0);
        event.setPrice(549.6);
        event.setArrageValue(21.0);
        event.setIsFull(true);
        autoEvents.add(event);

        this.autoEventService.saveAll(autoEvents);
    }
}
