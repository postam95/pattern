package hu.unimiskolc.formula1app.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hu.unimiskolc.formula1app.model.DriverDTO;

public class DriverDatabase {
	
	private static DriverDatabase instance = null;
	private List<DriverDTO> drivers;
	
	private Long nextId = 11L;
	
	private DriverDatabase()	{
		drivers = new ArrayList<>();
		LocalDateTime currentDateTime = LocalDateTime.now();
		drivers.add(new DriverDTO(1L, currentDateTime, currentDateTime, "Kimi Raikkonen", 1, 21, 18, 46, 329, 103));
		drivers.add(new DriverDTO(2L, currentDateTime, currentDateTime, "Fernando Alonso", 2, 32, 22, 23, 311, 97));
		drivers.add(new DriverDTO(3L, currentDateTime, currentDateTime, "Lewis Hamilton", 7, 95, 98, 53, 266, 165));
		drivers.add(new DriverDTO(4L, currentDateTime, currentDateTime, "Michael Schumacher", 7, 91, 68, 46, 306, 155));
		drivers.add(new DriverDTO(5L, currentDateTime, currentDateTime, "Sebastian Vettel", 4, 53, 57, 38, 257, 121));
		drivers.add(new DriverDTO(6L, currentDateTime, currentDateTime, "Ayrton Senna", 3, 41, 65, 19, 161, 80));
		drivers.add(new DriverDTO(7L, currentDateTime, currentDateTime, "Daniel Ricciardo", 0, 7, 3, 15, 188, 31));
		drivers.add(new DriverDTO(8L, currentDateTime, currentDateTime, "Max Verstappen", 0, 10, 3, 10, 119, 42));
		drivers.add(new DriverDTO(9L, currentDateTime, currentDateTime, "Felipe Massa", 0, 11, 16, 15, 269, 41));
		drivers.add(new DriverDTO(10L, currentDateTime, currentDateTime, "Rubens Barrichello", 0, 11, 14, 17, 322, 68));
	}
	
	public static DriverDatabase getIstance()	{
		if (DriverDatabase.instance == null)	{
			instance = new DriverDatabase();
		}
		return instance;
	}
	
	public List<DriverDTO> getAll()	{
		return drivers;
	}
	
	public DriverDTO findById(Long id)	{
		DriverDTO driver = DriverDatabase.getIstance().getAll().stream()
				  .filter(d -> id.equals(d.getId()))
				  .findAny()
				  .orElse(null);
		return driver;
	}
	
	public List<DriverDTO> findByName(String name)	{
		return DriverDatabase.getIstance().getAll()
				.stream()
				.filter(d -> name.equals(d.getName()))
				.collect(Collectors.toList());
	}
	
	public boolean create(DriverDTO newDriver)	{
		newDriver.setId(nextId++);
		return drivers.add(newDriver);
	}
	
	public DriverDTO update(DriverDTO driver)	{
		DriverDTO updatedDriver = DriverDatabase.getIstance().findById(driver.getId());
		updatedDriver.setChampionships(driver.getChampionships());
		updatedDriver.setFastestLaps(driver.getFastestLaps());
		updatedDriver.setModifiedAt(LocalDateTime.now());
		updatedDriver.setName(driver.getName());
		updatedDriver.setPodiums(driver.getPodiums());
		updatedDriver.setPoles(driver.getPoles());
		updatedDriver.setRaces(driver.getRaces());
		updatedDriver.setWins(driver.getWins());
		return updatedDriver;
	}
	
	public void delete(Long id)	{
		DriverDTO deletedDriver = DriverDatabase.getIstance().findById(id);
		DriverDatabase.getIstance().drivers.remove(deletedDriver);
	}
	
}
