package org.api.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostAllObjectsResponse {

    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private DataDetails data;
    @NotNull
    private String createdAt;

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
