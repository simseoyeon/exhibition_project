package com.example.personal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/performance")
public class CultureApiController {
    private CultureApiClient cultureApiClient;

    @GetMapping("/list")
    public ResponseEntity<String> getPerformanceList(@RequestParam("seq") String sequence) {
        return cultureApiClient.getPerformanceList(sequence);
    }

    @GetMapping("/detail")
    public ResponseEntity<String> getPerformanceDetail(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "place", required = false) String place,
            @RequestParam(value = "price", required = false) int price,
            @RequestParam(value = "contents1", required = false) String contents,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "placeUrl", required = false) String placeUrl) {
        return cultureApiClient.getPerformanceDetail(title, startDate, endDate, place, price, contents, phone, placeUrl);
    }
}

