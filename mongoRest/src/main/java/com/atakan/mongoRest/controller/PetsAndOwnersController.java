package com.atakan.mongoRest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atakan.mongoRest.dao.MongoDbRepo;
import com.atakan.mongoRest.entity.Owners;
import com.atakan.mongoRest.entity.ResponseInfo;
import com.atakan.mongoRest.error.BindingResultException;
import com.atakan.mongoRest.error.DocumentNotFoundException;

@RestController
@RequestMapping("/owners")
public class PetsAndOwnersController {

	@Autowired
	private MongoDbRepo mongoDbRepo;
		
	@GetMapping("/all")
	public List<Owners> getOwners(){
		
		return mongoDbRepo.findAll();
		
	}
	@PostMapping("/new")
	public Owners newOwner(@Valid @RequestBody Owners Owner,BindingResult bindingResult){
	
		if(bindingResult.hasErrors()) {
			throw new BindingResultException("values cannot be blank and age must be greater than 1");
		}
		else {
		return mongoDbRepo.save(Owner);
		}
		
	}
	@GetMapping("/{id}")
	public Optional<Owners> getById(@PathVariable String id) throws DocumentNotFoundException {

		if(!mongoDbRepo.existsById(id)) {
			throw new DocumentNotFoundException("Document with given id,cannot be found");
		}
		else {
			return mongoDbRepo.findById(id);
		}
	}
	@PutMapping("/{id}")
	public Owners updateById(@Valid @RequestBody Owners Owner,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			throw new BindingResultException("values cannot be blank and age must be greater than 1");
		}
		else {
			return mongoDbRepo.insert(Owner);
		}
	}
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseInfo delete(@PathVariable String id) throws DocumentNotFoundException {
		
		if(!mongoDbRepo.existsById(id)) {
			throw new DocumentNotFoundException("Document with given id, cannot be found");	
		}
		else {
			mongoDbRepo.deleteById(id);
			return new ResponseInfo("Document with given id has successfully deleted",HttpStatus.OK.value());
		}
		
	}
	

}
