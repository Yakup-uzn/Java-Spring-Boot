package com.yakup.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakup.dto.DtoHome;
import com.yakup.dto.DtoRoom;
import com.yakup.entites.Home;
import com.yakup.entites.Room;
import com.yakup.repository.HomeRepository;
import com.yakup.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService { 
	
	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public DtoHome findHomeById(long id) {
		
		DtoHome dtoHome=new DtoHome();
		Optional<Home> optional= homeRepository.findById(id);
		
		if (optional.isEmpty()) {
			return null;
		}
		
		Home DbHome=optional.get();
		List<Room> DbRooms=optional.get().getRoom();
		
		BeanUtils.copyProperties(DbHome, dtoHome);
		
		if (!DbRooms.isEmpty() && DbRooms!=null) {
			for (Room room : DbRooms) {
				DtoRoom dtoRoom=new DtoRoom();
				BeanUtils.copyProperties(room, dtoRoom);
				
				// null pointer yememek için DtoHome'un rooms field ını :	"private List<DtoRoom> rooms= new ArrayList<>();" olarak düzelt
				dtoHome.getRooms().add(dtoRoom);	
			}
			
			
		}
		return dtoHome;
		
		
	}

}
