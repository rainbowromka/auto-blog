package ru.autoblog.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.autoblog.model.AutoEvent;

public interface AutoEventRepository extends JpaRepository<AutoEvent, Long>
{
    Page<AutoEvent> findByOrderByEventDateDesc(Pageable pageable);
}
