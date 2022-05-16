package com.jestify.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class SongResponse {
    private String link;
    private String name;
    private int time;
    private String thumbnail;
    private String img;
}
