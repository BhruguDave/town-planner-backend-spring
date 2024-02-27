package com.example.helloworld.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HeatmapRequest {
    private String date;
    private Integer hour;
}
