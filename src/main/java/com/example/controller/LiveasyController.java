package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.LiveasyModel;
import com.example.service.LiveasyService;

@RestController
public class LiveasyController {
 
	@Autowired
	LiveasyService liveasyservice;
	
	@PostMapping("/load")
	public LiveasyModel AddTruckDetails(@RequestBody LiveasyModel liveasyModel)
	{
		return liveasyservice.create(liveasyModel);
	}
	
	@GetMapping("/")
	public List<LiveasyModel> getTruckDetails()
	{
		return liveasyservice.read();
	}
	
	@GetMapping("/getload/{shipperId}")
	public LiveasyModel getTruckDetailsById(@PathVariable int shipperId)
	{
		return liveasyservice.findbyId(shipperId);
	}
	
	@PutMapping("/updateload/{shipperId}")
	public int update(@PathVariable int shipperId, @RequestBody LiveasyModel liveasyModel)
	{
		return liveasyservice.Update(shipperId, liveasyModel);
	}
	
	@DeleteMapping("/deleteload/{shipperId}")
	public LiveasyModel DeleteTruckDetails(@PathVariable int shipperId)
	{
		return liveasyservice.delete(liveasyservice.findbyId(shipperId));
	}
}
