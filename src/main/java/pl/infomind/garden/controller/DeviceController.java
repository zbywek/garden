package pl.infomind.garden.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.infomind.garden.entity.Device;
import pl.infomind.garden.service.DeviceService;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService deviceService;


    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/{deviceName}")
    public List<Device> findAllDevicesByDeviceName(@PathVariable String deviceName) {
        return deviceService.findAllDevicesByDeviceName(deviceName);
    }
}
