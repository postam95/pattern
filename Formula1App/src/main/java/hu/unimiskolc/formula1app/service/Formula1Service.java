package hu.unimiskolc.formula1app.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import hu.unimiskolc.formula1app.model.DriverDTO;
import hu.unimiskolc.formula1app.model.NewDriverDTO;

public interface Formula1Service {

	List<DriverDTO> getDrivers(String name, Pageable pageable);

	DriverDTO createDriver(NewDriverDTO newDriver);
	
	Double calculateDriver(String name);
}
