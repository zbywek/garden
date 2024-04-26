package pl.infomind.garden.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.infomind.garden.entity.Device;
import pl.infomind.garden.map.DeviceMapper;
import pl.infomind.garden.model.DeviceRequest;
import pl.infomind.garden.model.DeviceResponse;
import pl.infomind.garden.repository.DeviceRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;


    public List<Device> findAllDevicesByDeviceName(String deviceName) {
        return deviceRepository.findByDeviceName(deviceName);
    }

    public DeviceResponse findDeviceById(Long deviceId) {
        Optional<Device> deviceOptional = deviceRepository.findById(deviceId);
        if (deviceOptional.isPresent()) {
            Device device = deviceOptional.get();
            return deviceMapper.mapToResponse(device);
        } else {
            throw new NoSuchElementException("Device not found");
        }
    }

    public DeviceResponse addDevice(DeviceRequest deviceRequest) {
//        Customer customer = mapper.mapTo(request);
//        customer = repository.save(customer);
//        return mapper.mapToResponse(customer);
        Device device = deviceMapper.mapTo(deviceRequest);
//        device.setCreatedAt(new Date());
        device = deviceRepository.save(device);
        return deviceMapper.mapToResponse(device);
    }
}
