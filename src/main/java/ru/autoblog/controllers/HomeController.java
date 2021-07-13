package ru.autoblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class HomeController
{
    @RequestMapping(value = "/")
    public String index()
    {
        return "index";
    }
}
