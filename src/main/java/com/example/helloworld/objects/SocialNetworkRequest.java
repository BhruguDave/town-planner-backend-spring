package com.example.helloworld.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SocialNetworkRequest {
    private List<String> participants;
    private String date;
}
