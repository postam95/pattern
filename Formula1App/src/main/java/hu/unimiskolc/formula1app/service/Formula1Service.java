package hu.unimiskolc.formula1app.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import hu.unimiskolc.formula1app.model.DriverDTO;
import hu.unimiskolc.formula1app.model.NewDriverDTO;

public interface Formula1Service {

	List<DriverDTO> getDrivers(String name, Pageable pageable);

	DriverDTO createDriver(NewDriverDTO newDriver);
	
	Double calculateDriver(Long id);
	
	DriverDTO getDriverById(Long id);
	
	DriverDTO updateDriver(Long id, NewDriverDTO newDriver);
	
	void deleteDriver(Long id);
	
}
