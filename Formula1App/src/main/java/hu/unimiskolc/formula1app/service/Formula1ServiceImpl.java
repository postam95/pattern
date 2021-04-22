package hu.unimiskolc.formula1app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import hu.unimiskolc.formula1app.model.DriverDTO;
import hu.unimiskolc.formula1app.model.NewDriverDTO;
import hu.unimiskolc.formula1app.repository.DriverDatabase;

@Service
public class Formula1ServiceImpl implements Formula1Service {
	
	@Override
	public List<DriverDTO> getDrivers(String name, Pageable pageable) {
		if (StringUtils.isEmpty(name))	{
			return DriverDatabase.getIstance().getAll()
					.stream()
					.skip(pageable.getOffset())
					.limit(pageable.getPageSize())
					.collect(Collectors.toList());	
		} else	{
			return DriverDatabase.getIstance().findByName(name);
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
	public Double calculateDriver(Long id) {
		DriverDTO driver = DriverDatabase.getIstance().findById(id);
		
		return driver.calculateValue();
	}

	@Override
	public DriverDTO getDriverById(Long id) {
		return DriverDatabase.getIstance().findById(id);
	}

	@Override
	public DriverDTO updateDriver(Long id, NewDriverDTO newDriver) {
		DriverDTO driver = new DriverDTO(id, null, null, newDriver.getName(),
				newDriver.getChampionships(), newDriver.getWins(), newDriver.getPoles(), newDriver.getFastestLaps(),
				newDriver.getRaces(), newDriver.getPodiums());
		return DriverDatabase.getIstance().update(driver);
	}

	@Override
	public void deleteDriver(Long id) {
		DriverDatabase.getIstance().delete(id);
	}

}
