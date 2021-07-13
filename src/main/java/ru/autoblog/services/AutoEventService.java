package ru.autoblog.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.autoblog.model.AutoEvent;
import ru.autoblog.repo.AutoEventRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AutoEventService
{
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AutoEventService.class);

    private final AutoEventRepository autoEventRepository;

    public AutoEventService(AutoEventRepository autoEventRepository)
    {
        this.autoEventRepository = autoEventRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<AutoEvent> saveAll(List<AutoEvent> autoEvents)
    {
        LOGGER.info("Saving {}", autoEvents);
        return autoEventRepository.saveAll(autoEvents);
    }

    public Page<AutoEvent> getAllEventsPagged(Pageable pageable)
    {
        return autoEventRepository.findByOrderByEventDateDesc(pageable);
    }
}
