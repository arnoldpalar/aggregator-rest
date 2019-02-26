package com.agap.aggregatorrest.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedResponse {

    String sessionId;
    String intent;
    Map<String, Object> params;

}
