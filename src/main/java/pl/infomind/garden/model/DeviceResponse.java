package pl.infomind.garden.model;

import lombok.Data;

@Data
public class DeviceResponse {
    private Integer id;

    private String deviceName;

    private String deviceType;

    private String deviceDescription;

    private String deviceStatus;
}
