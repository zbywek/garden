package pl.infomind.garden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.infomind.garden.entity.Device;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query(value = "SELECT * FROM Devices d WHERE d.DEVICE_NAME = ?1", nativeQuery = true)
    List<Device> findByDeviceName(String deviceName);
}
