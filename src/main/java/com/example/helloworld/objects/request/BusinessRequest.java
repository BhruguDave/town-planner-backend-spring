package com.example.helloworld.objects.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BusinessRequest {
    private List<Integer> buildings;
}
