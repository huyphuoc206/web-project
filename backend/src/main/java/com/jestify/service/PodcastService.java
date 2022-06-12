package com.jestify.service;

import com.jestify.converter.EpisodeConverter;
import com.jestify.converter.PodcastConverter;
import com.jestify.entity.Episodes;
import com.jestify.entity.Podcasts;
import com.jestify.entity.Users;
import com.jestify.payload.EpisodeResponse;
import com.jestify.payload.FollowResponse;
import com.jestify.payload.PodcastResponse;
import com.jestify.repository.EpisodeRepository;
import com.jestify.repository.PodcastRepository;
import com.jestify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PodcastService {
    private final EpisodeService episodeService;
    private final PodcastRepository podcastRepository;

    private final UserRepository userRepository;
    private final PodcastConverter podcastConverter;
    private final FollowService followService;

    public List<EpisodeResponse> getPodcastEpisode(Long podcastId) {
        return episodeService.getEpisodeByIdPodcast(podcastId);
    }

    public PodcastResponse getPodcastById(Long podcastId) {
        Podcasts podcasts = podcastRepository.findById(podcastId)
                .orElseThrow(() -> new IllegalStateException("Podcast not found"));
        Users user =userRepository.findById((podcasts.getUserId()))
                .orElseThrow(() -> new IllegalStateException("User not found"));
        PodcastResponse podcastResponse = podcastConverter.toResponse(podcasts);
        podcastResponse.setEpisodeResponseList(getPodcastEpisode(podcastId));
        podcastResponse.setFullNameUser(user.getFullName());
        return podcastResponse;
    }


    public List<PodcastResponse> getFollowsPodcast(String type, Long userId) {
        List<FollowResponse> followResponseList = followService.getListFollows(userId, type);
        List<PodcastResponse> podcastResponseList = new ArrayList<>();
        for (FollowResponse followResponse : followResponseList) {
            Podcasts podcasts = podcastRepository.findById(followResponse.getObjectId()).orElseThrow(() -> new IllegalStateException("Not Found Podcast to Follow"));
            podcastResponseList.add(podcastConverter.toResponse(podcasts));
        }
        return podcastResponseList;
    }


}
