package com.Hospital.Management.System.Controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Hospital.Management.System.HospitalManagementSystemApplication;
import com.Hospital.Management.System.Repository.PatientRepository;
import com.Hospital.Management.System.doclogin.entity.Appointment;
import com.Hospital.Management.System.entity.Patient;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController
{

	@Autowired
	private PatientRepository patientRepository;

   
	
	@PostMapping("/insert")
	public Patient createPatient(@RequestBody Patient patient)
	{
		 return patientRepository.save(patient);
	}
	@GetMapping("/getPatient")
	public  List<Patient> getAllPatients()
	{
		return patientRepository.findAll();
	}
	@DeleteMapping("/deletePatient/{id}")
	public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException
	{
		Patient patient= patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id"+id));
		patientRepository.delete(patient);
		Map<String,Boolean> reposne=new HashMap<>();
		reposne.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(reposne);
	}
	@GetMapping("getPatient/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException
	{
	    Patient patient=patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient Not found"+id));
		return ResponseEntity.ok(patient);
	}
	
	@PutMapping("/updatePatients/{id}")
	public ResponseEntity<Patient> updatePatientId(@PathVariable long id,@RequestBody Patient patient) throws AttributeNotFoundException
	{
		Patient patient1= patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id"+id));
		
		patient1.setAge(patient.getAge());
		patient1.setName(patient.getName());
		patient1.setBlood(patient.getBlood());
		patient1.setDose(patient.getDose());
		patient1.setFees(patient.getFees());
		patient1.setPrescription(patient.getPrescription());
		patient1.setUrgency(patient.getUrgency());
		
	     Patient savedpaPatient=patientRepository.save(patient1);
	     
	     return ResponseEntity.ok(savedpaPatient);
		

	}

}
