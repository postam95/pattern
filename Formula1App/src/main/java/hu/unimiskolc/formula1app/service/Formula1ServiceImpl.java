package hu.unimiskolc.formula1app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import hu.unimiskolc.formula1app.repository.DriverDatabase;
import hu.unimiskolc.formula1app.web.dto.driver.DriverDTO;
import hu.unimiskolc.formula1app.web.dto.driver.NewDriverDTO;

@Service
public class Formula1ServiceImpl implements Formula1Service {
	
	@Override
	public List<DriverDTO> getDrivers(String name, Pageable pageable) {
		
		if (StringUtils.isEmpty(name)) {
			return DriverDatabase.getIstance().getAll()
					.stream()
					.skip(pageable.getOffset())
					.limit(pageable.getPageSize())
					.collect(Collectors.toList());
		} else {
			return DriverDatabase.getIstance().getAll()
					.stream()
					.filter(a -> a.getName().equals(name))
					.collect(Collectors.toList());
		}
		
	}

	@Override
	public DriverDTO createDriver(NewDriverDTO newDriver) {
		DriverDTO driver = new DriverDTO(null, LocalDateTime.now(), LocalDateTime.now(), newDriver.getName(),
				newDriver.getChampionships(), newDriver.getWins(), newDriver.getPoles(), newDriver.getFastestLaps(),
				newDriver.getRaces(), newDriver.getPodiums());
		
		boolean result = DriverDatabase.getIstance().create(driver);
		if (result)
			return driver;
		return null;
	}

	@Override
	public Double calculateDriver(String name) {
		DriverDTO driver = DriverDatabase.getIstance().getAll().stream()
				  .filter(d -> name.equals(d.getName()))
				  .findAny()
				  .orElse(null);
		
		return driver.calculateValue();
	}

}
