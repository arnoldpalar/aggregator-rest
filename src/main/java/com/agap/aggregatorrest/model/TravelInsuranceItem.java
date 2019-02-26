package com.agap.aggregatorrest.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TravelInsuranceItem extends ListItem{

    private String provider;
    private BigDecimal price;
    private Short rating;
    private Integer totalReview;
    private Map<String, String> coverages;

    @Override
    public String getId() {
        return this.provider;
    }
}
