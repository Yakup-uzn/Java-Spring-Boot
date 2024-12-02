package com.example.webscraper.service;

import com.example.webscraper.scraper.WebScraper;
import org.springframework.stereotype.Service;

@Service
public class WebScraperService {

    private final WebScraper webScraper;

    public WebScraperService(WebScraper webScraper) {
        this.webScraper = webScraper;
    }

    public String getScrapedData(String url) {
        return webScraper.scrapeData(url);
    }
}
