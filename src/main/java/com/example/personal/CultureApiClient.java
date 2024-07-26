package com.example.personal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://www.culture.go.kr/openapi/rest/publicperformancedisplays/d/",
        name = "cultureClient",configuration = CultureConfiguration.class)
public interface CultureApiClient { //API를 불러오는 interface
    //공연/전시상세정보조회

    // 전체 공연/전시 상세 정보 조회
    @GetMapping("/list")
    ResponseEntity<String> getPerformanceList(@RequestParam("seq") String sequence);

    //세부 정보
    @GetMapping("/detail")
    ResponseEntity<String> getPerformanceDetail(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "place", required = false) String place,
            @RequestParam(value = "price", required = false) int price,
            @RequestParam(value = "contents1", required = false) String contents,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "placeUrl", required = false) String placeUrl
    );

}
