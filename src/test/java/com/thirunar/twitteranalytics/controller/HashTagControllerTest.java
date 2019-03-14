package com.thirunar.twitteranalytics.controller;

import com.thirunar.twitteranalytics.service.HashTagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(HashTagController.class)
public class HashTagControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HashTagService service;

    @Test
    public void shouldGetTheTweetsBasedOnHashTag() throws Exception {
        Tweet tweet = new Tweet(1, "1", new Date(), "", "", 1L, 3, "3", "1");
        when(service.getTweetsFor(any())).thenReturn(Arrays.asList(tweet));

        mockMvc.perform(get("/tweets")
                        .param("hashtag", "thiru"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1));


    }
}