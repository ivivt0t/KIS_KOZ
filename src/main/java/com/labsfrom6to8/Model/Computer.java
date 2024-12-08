package com.labsfrom6to8.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    private Long id;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("processor")
    private String processor;

    @JsonProperty("ram")
    private Integer ram;

    @JsonProperty("storage")
    private Integer storage;

    @JsonProperty("is_available")
    private Boolean isAvailable;
}
