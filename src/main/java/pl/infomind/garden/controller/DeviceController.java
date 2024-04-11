package pl.infomind.garden.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.infomind.garden.entity.Device;
import pl.infomind.garden.model.DeviceResponse;
import pl.infomind.garden.service.DeviceService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService deviceService;



    @GetMapping("/name/{deviceName}")
    public List<Device> findAllDevicesByDeviceName(@PathVariable String deviceName) {
        return deviceService.findAllDevicesByDeviceName(deviceName);
    }

    @GetMapping("/id/{id}")
    public DeviceResponse findDeviceById(@PathVariable Long id) {
        return deviceService.findDeviceById(id);
    }
}
