package ru.autoblog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="auto_events_refueling", schema = "autoblog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoEventRefueling
extends AutoEvent
{
    /**
     * Цена за литр топлива.
     */
    Double pscPrice;

    /**
     * Заправленый объем.
     */
    Double value;

    /**
     * Признак того что бак полностью заправлен.
     */
    Boolean isFull;

    /**
     * Расход топлива.
     */
    Double arrageValue;
}
