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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.doclogin.repository.MedicineRepository;
import com.Hospital.Management.System.entity.Patient;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v3")
public class MedicineController 
{
	@Autowired
  MedicineRepository medicineRepository;
	
	@PostMapping("/insert")
	public Medicine createMedicine(@RequestBody Medicine medicine)
	{
		return medicineRepository.save(medicine);
	}
	
	@GetMapping("/getMedicine")
	public  List<Medicine> getAllMedicine()
	{
		return medicineRepository.findAll();
	}
	
	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException
	{
	Medicine medicine=medicineRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Medicine not found"));
	return ResponseEntity.ok(medicine);

	}
	@PutMapping("/medicine/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable long id,@RequestBody Medicine medicine) throws AttributeNotFoundException
	{
		Medicine medicine1=medicineRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Medicine not found"));
		medicine1.setDrugName(medicine.getDrugName());
		medicine1.setStock(medicine.getStock());

		medicineRepository.save(medicine1);
		return ResponseEntity.ok(medicine1);
	}
	@DeleteMapping("/deletemedicine/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id) throws AttributeNotFoundException
	{
		Medicine medicine1=medicineRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Medicine not found"));
		medicineRepository.delete(medicine1);
		Map<String,Boolean> response=new HashMap<>();
		response.put("delete",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
