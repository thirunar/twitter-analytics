package com.thirunar.twitteranalytics.controller;

import com.thirunar.twitteranalytics.service.HashTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class HashTagController {

    @Autowired
    private HashTagService hashTagService;

    @GetMapping(path = "/tweets")
    public ResponseEntity get(@PathParam("hashtag") String hashtag) {
        List<Tweet> tweets = hashTagService.getTweetsFor(hashtag);
        return ResponseEntity.ok(tweets);
    }
}
