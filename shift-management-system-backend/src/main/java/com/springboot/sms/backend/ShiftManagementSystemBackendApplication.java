package com.springboot.sms.backend;



import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.sms.backend.entity.Employee;
import com.springboot.sms.backend.entity.Shift;
import com.springboot.sms.backend.repository.EmployeeRepository;
import com.springboot.sms.backend.repository.ShiftRepository;

@SpringBootApplication(scanBasePackages = "com.springboot.sms")
public class ShiftManagementSystemBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ShiftManagementSystemBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ShiftRepository shiftRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*Employee employee1 = new Employee("Hudzy", "Omar", "HudzyOmar@gmail.com");
		employeeRepository.save(employee1);
		
		Employee employee2 = new Employee("Michael", "Schofield", "MSchofield@gmail.com");
		employeeRepository.save(employee2);
		
		Employee employee3 = new Employee("Jack", "Black", "JackBlack@gmail.com");
		employeeRepository.save(employee3);
		
		Employee employee4 = new Employee("Tony", "Stark", "TStarkEnteprises@gmail.com");
		employeeRepository.save(employee4);
		
		Shift shift1 = new Shift("Morning Shift", LocalTime.of(9, 0), LocalTime.of(17, 0));
		shiftRepository.save(shift1);
	
		Shift shift2 = new Shift("Night Shift", LocalTime.of(20, 0), LocalTime.of(9, 0));
		shiftRepository.save(shift2);*/
		
		
		
	}

}
