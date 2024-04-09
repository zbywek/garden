package pl.infomind.garden.map;

import org.springframework.stereotype.Component;
import pl.infomind.garden.entity.Device;
import pl.infomind.garden.model.DeviceResponse;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeviceMapper {
    public DeviceResponse mapToResponse(Device device) {
        var deviceResponse = new DeviceResponse();
        deviceResponse.setId(device.getId());
        deviceResponse.setDeviceName(device.getDeviceName());
        deviceResponse.setDeviceType(device.getDeviceType());
        deviceResponse.setDeviceDescription(device.getDeviceDescription());
        deviceResponse.setDeviceStatus(device.getDeviseStatus());
        return deviceResponse;
    }

    public List<DeviceResponse> mapToResponse(Collection<Device> devices) {
        return devices.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public Device mapTo(Device device, DeviceResponse deviceResponse) {
        device.setDeviceName(deviceResponse.getDeviceName());
        device.setDeviceType(deviceResponse.getDeviceType());
        device.setDeviceDescription(deviceResponse.getDeviceDescription());
        device.setDeviseStatus(deviceResponse.getDeviceStatus());
        return device;
    }

    public Device mapTo(DeviceResponse deviceResponse) {
        return mapTo(new Device(), deviceResponse);
    }
}
