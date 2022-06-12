package com.jestify.converter;


import com.jestify.entity.Episodes;
import com.jestify.payload.EpisodeResponse;
import org.springframework.stereotype.Component;

@Component
public class EpisodeConverter {
        public EpisodeResponse toResponse(Episodes entity){
            return EpisodeResponse
                    .builder()
                    .description(entity.getDescription())
                    .episodeId(entity.getId())
                    .podcastId(entity.getPodcasts().getId())
                    .link(entity.getLink())
                    .name(entity.getName())
                    .thumbnail(entity.getThumbnail())
                    .createdDate(entity.getCreatedDate())
                    .build();
        }

}
