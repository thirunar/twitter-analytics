package com.thirunar.twitteranalytics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashTagService {

    @Autowired
    private TwitterTemplate template;

    public List<Tweet> getTweetsFor(String hashTag) {
        SearchResults search = template.searchOperations()
                .search("#" + hashTag);
        return search.getTweets();
    }
}
