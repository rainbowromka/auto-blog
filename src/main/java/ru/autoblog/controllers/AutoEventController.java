package ru.autoblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.autoblog.model.AutoEvent;
import ru.autoblog.repo.AutoEventRepository;

@RestController
@RequestMapping("/services")
public class AutoEventController
{
    @Autowired
    AutoEventRepository autoEventRepository;

    @GetMapping("listEvents")
    public Page<AutoEvent> listAutoEvents(Pageable pageable)
    {
        return autoEventRepository.findAll(pageable);
    }
}
