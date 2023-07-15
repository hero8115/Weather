package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Weather {
    private String temperature;
    private String wind;
    private String description;
    private List<Forecast> forecast;


}
