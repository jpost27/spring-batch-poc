package com.jp.springbatchpoc.cache;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;

@Getter
@RequiredArgsConstructor
public enum Cache {

    SR_NFL_RESPONSES(MediaType.APPLICATION_JSON),
    DOCUMENTATION_HTML(MediaType.TEXT_PLAIN),
    ;

    private final MediaType mediaType;
}
