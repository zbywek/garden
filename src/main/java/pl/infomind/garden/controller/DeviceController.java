package pl.infomind.garden.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.infomind.garden.entity.Device;
import pl.infomind.garden.model.DeviceRequest;
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

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public DeviceResponse addDevice(@RequestBody DeviceRequest deviceRequest) {
        return deviceService.addDevice(deviceRequest);
    }


}
