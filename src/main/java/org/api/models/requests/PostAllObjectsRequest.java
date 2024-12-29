package org.api.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostAllObjectsRequest {

    private String name;
    private DataDetails data;

    @Data
    public static class DataDetails {
        private Integer year;
        private Double price;
        @JsonProperty("CPU model")
        private String cpuModel;
        @JsonProperty("Hard disk size")
        private String hardDiskSize;
    }
}
