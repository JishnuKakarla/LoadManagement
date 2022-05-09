package com.example.service;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.LiveasyModel;
import com.example.repository.LiveasyRepository;

@Service
public class LiveasyService {
	
	@Autowired
	LiveasyRepository liveasyRepo;
	
	public LiveasyModel create(LiveasyModel liveasyModel)
	{
		liveasyModel.setShipperId((int)new Random().nextInt(90001));
		return liveasyRepo.save(liveasyModel);
	}
	
	public List<LiveasyModel> read()
	{
		return liveasyRepo.findAll();
	}
	
	public LiveasyModel findbyId(int shipperId)
	{
		return liveasyRepo.findById(shipperId).get();
	}
	
	public int Update(int shipperId,LiveasyModel liveasyModel)
	{
		return liveasyRepo.update(liveasyModel.getComment(), liveasyModel.getDate(), liveasyModel.getLoadingPoint(), liveasyModel.getNoOfTrucks(), liveasyModel.getProductType(), liveasyModel.getTruckType(), liveasyModel.getUnloadingPoint(), liveasyModel.getWeight(), shipperId);
	}
	
	public LiveasyModel delete(LiveasyModel liveasyModel)
	{
		System.out.println(liveasyModel);
		liveasyRepo.delete(liveasyModel);
		return null;
	}
}
