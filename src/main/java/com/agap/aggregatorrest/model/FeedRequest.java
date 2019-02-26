package com.agap.aggregatorrest.model;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class FeedRequest {

    private String sessionId;
    private String text;

}
