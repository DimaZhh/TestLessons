package org.api.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllObjectsResponse {

    @NotNull
    @Size(min = 1)
    @Size(max = 1000)
    private String id;
    @NotNull
    @Size(min = 1)
    @Size(max = 1000)
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
