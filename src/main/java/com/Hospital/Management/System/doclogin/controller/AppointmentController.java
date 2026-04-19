package com.Hospital.Management.System.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.doclogin.entity.Appointment;
import com.Hospital.Management.System.doclogin.repository.AppointmentsRepository;
import com.Hospital.Management.System.entity.Patient;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class AppointmentController
{
	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	@PostMapping("/insert")
	public Appointment createAppointment(@RequestBody Appointment appointment)
	{
		return appointmentsRepository.save(appointment);
	}
	@GetMapping("/getAppointment")
	public  List<Appointment> getAllAppointments()
	{
		return appointmentsRepository.findAll();
	}
	@DeleteMapping("/deleteAppointment/{id}")
	
	public ResponseEntity<Map<String,Boolean>>deleteAppointment(@PathVariable long id) throws AttributeNotFoundException
	{
		Appointment appointment= appointmentsRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment not found with id"+id));
		appointmentsRepository.delete(appointment);
		
		Map<String,Boolean> response=new HashMap<>();
		response.put("Appointment is deleted",  Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	

}
