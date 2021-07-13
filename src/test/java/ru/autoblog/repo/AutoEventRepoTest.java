package ru.autoblog.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import ru.autoblog.model.AutoEvent;
import ru.autoblog.model.AutoEventType;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;


/**
 * Тестируем репозиторий событий автомобиля.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AutoEventRepoTest
{
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AutoEventRepository autoEventRepository;

    @Test
    public void findByEventDate()
    {
        AutoEvent event;
        event = new AutoEvent();
        event.setEventDate(LocalDateTime.of(2021,2, 5, 0, 0));
        event.setAutoEventType(AutoEventType.REFUELING);
        event.setPrice(1697.57);
        event.setMileage(229619L);
        testEntityManager.persist(event);

        event = new AutoEvent();
        event.setEventDate(LocalDateTime.of(2021,2, 7, 0, 0));
        event.setAutoEventType(AutoEventType.REFUELING);
        event.setPrice(999.76);
        event.setMileage(229909L);
        testEntityManager.persist(event);

        event = new AutoEvent();
        event.setEventDate(LocalDateTime.of(2021,2, 12, 0, 0));
        event.setAutoEventType(AutoEventType.REFUELING);
        event.setPrice(2351.85);
        event.setMileage(230142L);
        testEntityManager.persist(event);

        testEntityManager.flush();

        Pageable pageable = PageRequest.of(0, 2);
        Page<AutoEvent> result = autoEventRepository
            .findByOrderByEventDateDesc(pageable);

        assertThat(result).hasSize(2);
        assertThat(result.getContent().get(0))
            .hasFieldOrPropertyWithValue("price", 2351.85)
            .hasFieldOrPropertyWithValue("mileage", 230142L)
            .hasFieldOrPropertyWithValue("autoEventType",
                AutoEventType.REFUELING)
            .hasFieldOrPropertyWithValue("eventDate",
                LocalDateTime.of(2021,2, 12, 0, 0));
    }

    @Test
    public void save_AutoEvent()
    {
        AutoEvent event = new AutoEvent();
        event.setEventDate(LocalDateTime.of(2021,2, 5, 0, 0));
        event.setAutoEventType(AutoEventType.REFUELING);
        event.setPrice(1697.57);
        event.setMileage(229619L);

        AutoEvent saved = autoEventRepository.save(event);

        assertThat(testEntityManager.find(AutoEvent.class, saved.getId())).isEqualTo(saved);
    }
}
