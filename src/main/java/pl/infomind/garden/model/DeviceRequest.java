package pl.infomind.garden.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceRequest {
    private String deviceName;

    private String deviceType;

    private String deviceDescription;

    private String deviceStatus;
}
