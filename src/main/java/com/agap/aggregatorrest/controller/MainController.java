package com.agap.aggregatorrest.controller;

import com.agap.aggregatorrest.model.FeedRequest;
import com.agap.aggregatorrest.model.FeedResponse;
import com.agap.aggregatorrest.model.TravelInsuranceItem;
import com.agap.aggregatorrest.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@CrossOrigin
@RestController
public class MainController {

    private MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping(value = "/feed", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeedResponse> feed(@RequestBody FeedRequest feedRequest) {

        FeedResponse feedResponse = FeedResponse.builder().sessionId(feedRequest.getSessionId()).build();
        mainService.resolveIntent(feedRequest, feedResponse);

        return ResponseEntity.ok(feedResponse);
    }


    @RequestMapping(value = "/insurance/travel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TravelInsuranceItem>> travelInsurance(@RequestParam String destination, @RequestParam(required = false) String departure, @RequestParam(required = false) Integer days) {

        List<TravelInsuranceItem> ret = new ArrayList<>();

        Map<String, String> coverages = new HashMap<>();
        coverages.put("Personal accident payment", "$200,000 / adult $40,000 / elderly");
        coverages.put("Medical expenses (overseas)", "$200,000 / adult $40,000 / elderly");
        coverages.put("Lost bags and belongings", "Up to $300 per item, pair, or set of items, max $3,000");

        ret.add(TravelInsuranceItem.builder()
                .provider("Provider 1")
                .price(new BigDecimal(25))
                .rating((short) 5)
                .totalReview(89)
                .coverages(coverages).build());

        ret.add(TravelInsuranceItem.builder()
                .provider("Provider 2")
                .price(new BigDecimal(35))
                .rating((short) 5)
                .totalReview(79)
                .coverages(coverages).build());

        ret.add(TravelInsuranceItem.builder()
                .provider("Provider 3")
                .price(new BigDecimal(45))
                .rating((short) 5)
                .totalReview(69)
                .coverages(coverages).build());

        ret.add(TravelInsuranceItem.builder()
                .provider("Provider 4")
                .price(new BigDecimal(55))
                .rating((short) 5)
                .totalReview(59)
                .coverages(coverages).build());

        ret.add(TravelInsuranceItem.builder()
                .provider("Provider 5")
                .price(new BigDecimal(65))
                .rating((short) 5)
                .totalReview(49)
                .coverages(coverages).build());

        ret.add(TravelInsuranceItem.builder()
                .provider("Provider 6")
                .price(new BigDecimal(75))
                .rating((short) 5)
                .totalReview(39)
                .coverages(coverages).build());

        ret.add(TravelInsuranceItem.builder()
                .provider("Provider 7")
                .price(new BigDecimal(85))
                .rating((short) 5)
                .totalReview(29)
                .coverages(coverages).build());

        ret.add(TravelInsuranceItem.builder()
                .provider("Provider 8")
                .price(new BigDecimal(95))
                .rating((short) 5)
                .totalReview(19)
                .coverages(coverages).build());

        return ResponseEntity.ok(ret);
    }

}
