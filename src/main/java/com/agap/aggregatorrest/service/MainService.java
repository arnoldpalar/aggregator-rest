package com.agap.aggregatorrest.service;

import com.agap.aggregatorrest.model.FeedRequest;
import com.agap.aggregatorrest.model.FeedResponse;
import com.google.cloud.dialogflow.v2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MainService {

    @Value("${application.project-id:project-id}")
    String projectId;

    @Value("${application.language-code:en-US}")
    String languageCode;

    private SessionsClient sessionsClient;

    @Autowired
    public MainService(SessionsClient sessionsClient) {
        this.sessionsClient = sessionsClient;
    }

    public void resolveIntent(FeedRequest feedRequest, FeedResponse feedResponse) {
        TextInput.Builder textInput = TextInput.newBuilder().setText(feedRequest.getText()).setLanguageCode(languageCode);

        QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

        SessionName session = SessionName.of(projectId, feedResponse.getSessionId());
        DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

        QueryResult queryResult = response.getQueryResult();

        feedResponse.setIntent(queryResult.getIntent().getDisplayName());
        feedResponse.setParams(new HashMap<>());
        queryResult.getParameters().getFieldsMap().forEach((k, v) -> {
            feedResponse.getParams().put(k, v.getStringValue());
        });
    }

}
