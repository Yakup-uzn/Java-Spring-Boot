package com.example.webscraper.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebScraper {

    public String scrapeData(String url) {
        StringBuilder scrapedData = new StringBuilder();
        
        // HTML tablo yapısını başlatıyoruz
        scrapedData.append("<table border='1' style='border-collapse: collapse; width: 100%;'>")
                   .append("<thead>")
                   .append("<tr>")
                   .append("<th>Logo</th>")
                   .append("<th>Şirket</th>")
                   .append("<th>Fiyat 1</th>")
                   .append("<th>Fiyat 2</th>")
                   .append("<th>Fiyat 3</th>")
                   .append("<th>Tarih</th>")
                   .append("</tr>")
                   .append("</thead>")
                   .append("<tbody>");

        try {
            // Belirtilen URL'yi bağlayıp HTML belgesini alıyoruz
            Document document = Jsoup.connect(url).get();

            // <tbody> elementini seçiyoruz
            Element tbody = document.select("tbody").first();

            if (tbody != null) {
                // Tüm <tr> elementlerini seçiyoruz
                Elements rows = tbody.select("tr");

                for (Element row : rows) {
                    scrapedData.append("<tr>"); // Her satır için <tr> başlat

                    // Şirket logosunu ve ismini içeren <td> etiketini işliyoruz
                    Element firstColumn = row.select("td").first();
                    if (firstColumn != null) {
                        // Logo img ve şirket adını işliyoruz
                        Element img = firstColumn.select("img").first();
                        String imgSrc = img != null ? img.attr("src") : "";
                        String companyName = firstColumn.text();

                        scrapedData.append("<td><img src='").append(imgSrc)
                                   .append("' width='24' height='24'></td>");
                        scrapedData.append("<td>").append(companyName).append("</td>");
                    }

                    // Diğer sütunlar (fiyatlar ve tarih)
                    Elements columns = row.select("td");
                    for (int i = 1; i < columns.size(); i++) {
                        scrapedData.append("<td>").append(columns.get(i).text()).append("</td>");
                    }

                    scrapedData.append("</tr>"); // Her satır için </tr> sonlandır
                }
            }

            // HTML tablo yapısını kapatıyoruz
            scrapedData.append("</tbody>")
                       .append("</table>");

        } catch (IOException e) {
            e.printStackTrace();
            return "Error scraping data.";
        }

        return scrapedData.toString();
    }
}
