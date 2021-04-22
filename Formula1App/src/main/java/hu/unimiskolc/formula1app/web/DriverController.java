package hu.unimiskolc.formula1app.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.unimiskolc.formula1app.model.DriverDTO;
import hu.unimiskolc.formula1app.model.NewDriverDTO;
import hu.unimiskolc.formula1app.service.Formula1Service;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController {

	private final Formula1Service formula1Service;
	
	public DriverController(Formula1Service formula1Service) {
		this.formula1Service = formula1Service;
	}

	@GetMapping
	List<DriverDTO> getDrivers(@RequestParam(name = "name", required = false) String name, Pageable pageable) {
		return formula1Service.getDrivers(name, pageable);
	}
	
	@PostMapping
	DriverDTO createDriver(@RequestBody @Valid NewDriverDTO newDriver) {
		return formula1Service.createDriver(newDriver);
	}
	
	@RequestMapping("/calculate")
	@GetMapping
	double calculateDriverValue(@RequestParam(name = "name", required = true) String name)	{
		return formula1Service.calculateDriver(name);
	}
	
}
