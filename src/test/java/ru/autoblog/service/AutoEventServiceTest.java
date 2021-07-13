package ru.autoblog.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.autoblog.model.AutoEvent;
import ru.autoblog.model.AutoEventType;
import ru.autoblog.repo.AutoEventRepository;
import ru.autoblog.services.AutoEventService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class AutoEventServiceTest
{
    @MockBean
    private AutoEventRepository autoEventRepository;

    private AutoEventService autoEventService;

    @Before
    public void init() {
        autoEventService = new AutoEventService(autoEventRepository);
    }

    @Test
    public void getAllAutoEventsPaged()
    {
        AutoEvent event;
        List<AutoEvent> autoEvents = new ArrayList<>();

        event = new AutoEvent();
        event.setEventDate(LocalDateTime.of(2021,2, 5, 0, 0));
        event.setAutoEventType(AutoEventType.REFUELING);
        event.setPrice(1697.57);
        event.setMileage(229619L);
        autoEvents.add(event);


        event = new AutoEvent();
        event.setEventDate(LocalDateTime.of(2021,2, 7, 0, 0));
        event.setAutoEventType(AutoEventType.REFUELING);
        event.setPrice(999.76);
        event.setMileage(229909L);
        autoEvents.add(event);

        Page<AutoEvent> autoEventPage = new PageImpl<>(autoEvents);

        PageRequest pageRequest = PageRequest.of(0, 2);
        when(autoEventRepository
            .findByOrderByEventDateDesc(pageRequest)).thenReturn(autoEventPage);

        Page<AutoEvent> actualAutoEvents = autoEventService
            .getAllEventsPagged(pageRequest);

        verify(autoEventRepository, times(1))
            .findByOrderByEventDateDesc(pageRequest);
        assertThat(autoEventPage).isEqualTo(actualAutoEvents);
    }

    @Test
    public void saveAllAutoEvents()
    {
        AutoEvent event;
        List<AutoEvent> autoEvents = new ArrayList<>();

        event = new AutoEvent();
        event.setEventDate(LocalDateTime.of(2021,2, 5, 0, 0));
        event.setAutoEventType(AutoEventType.REFUELING);
        event.setPrice(1697.57);
        event.setMileage(229619L);
        autoEvents.add(event);

        event = new AutoEvent();
        event.setEventDate(LocalDateTime.of(2021,2, 7, 0, 0));
        event.setAutoEventType(AutoEventType.REFUELING);
        event.setPrice(999.76);
        event.setMileage(229909L);
        autoEvents.add(event);

        when(autoEventRepository.saveAll(autoEvents)).thenReturn(autoEvents);

        List<AutoEvent> saved = autoEventService.saveAll(autoEvents);

        assertThat(saved).isEqualTo(autoEvents);
        verify(autoEventRepository, times(1)).saveAll(autoEvents);
    }

}
