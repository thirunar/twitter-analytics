package com.thirunar.twitteranalytics.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.social.twitter.api.SearchMetadata;
import org.springframework.social.twitter.api.SearchOperations;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

import static org.assertj.core.util.Lists.emptyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HashTagServiceTest {

    @InjectMocks
    private HashTagService service;

    @Mock
    private TwitterTemplate template;

    @Mock
    private SearchOperations searchOperations;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldVerifyIfTheTemplateIsInvokedForSearchOperation() {
        when(template.searchOperations()).thenReturn(searchOperations);
        SearchResults searchResults = new SearchResults(emptyList(), new SearchMetadata(1, 1));
        when(searchOperations.search(anyString())).thenReturn(searchResults);

        service.getTweetsFor("anytag");

        verify(template).searchOperations();
        verify(searchOperations).search("#anytag");
    }
}