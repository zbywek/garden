package pl.infomind.garden.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.infomind.garden.entity.Device;
import pl.infomind.garden.repository.DeviceRepository;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> findAllDevicesByDeviceName(String deviceName) {
        return deviceRepository.findByDeviceName(deviceName);
    }
}
