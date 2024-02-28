package com.example.helloworld.objects.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BarchartResponse {
    private Iterable<String> participants;
    private Double spending;
}
