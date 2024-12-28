package org.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllObjects {

    private String id;
    private String name;
    private DeviceData data;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeviceData {
        private String color;
        private String capacity;
        @JsonProperty("capacity GB")
        private String capacityGb;
        private Double price;
        private String generation;
        private Integer year;
        @JsonProperty("CPU model")
        private String cpuModel;
        @JsonProperty("Hard disk size")
        private String hardDiskSize;
        @JsonProperty("Strap Colour")
        private String strapColour;
        @JsonProperty("Case Size")
        private String caseSize;
        private String description;
        @JsonProperty("Screen size")
        private Double screenSize;
    }

}
