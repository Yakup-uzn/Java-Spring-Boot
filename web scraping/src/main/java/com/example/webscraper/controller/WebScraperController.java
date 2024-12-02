package com.example.webscraper.controller;

import com.example.webscraper.service.WebScraperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebScraperController {

    private final WebScraperService webScraperService;

    public WebScraperController(WebScraperService webScraperService) {
        this.webScraperService = webScraperService;
    }

    @GetMapping("/scrape")
    public String scrapeWebsite(@RequestParam String url) {
        return webScraperService.getScrapedData(url);
    }
}
