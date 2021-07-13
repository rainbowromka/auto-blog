package ru.autoblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author Roman Perminov
 * Сущность события, возникающее с вашим автомобилем.
 */
@Entity
@Table(name="auto_events", schema = "autoblog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "jpaAutoEventSequence",
        allocationSize = 1,
        schema = "autoblog",
        sequenceName = "auto_event_sequence"
)
@Inheritance(strategy = InheritanceType.JOINED)
public class AutoEvent
{
    /**
     * ID события.
     */
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "jpaAutoEventSequence"
    )
    private Long id;

    /**
     * Тип события.
     */
    @Enumerated(EnumType.STRING)
    private AutoEventType autoEventType;

    /**
     * Дата события.
     */
    private LocalDateTime eventDate;

    /**
     * Пробег автомобиля.
     */
    private Long mileage;

    /**
     * Стоимость услуги, во время события. Либо NULL.
     */
    private Double price;
}
