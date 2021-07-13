package ru.autoblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="auto_events_maintenance", schema = "autoblog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoEventMaintenance
extends AutoEvent
{
    /**
     * Комментарии к техническому обслуживанию.
     */
    String comment;
}
