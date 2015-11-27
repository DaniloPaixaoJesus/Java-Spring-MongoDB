package com.apptanamao.www.service;

import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Service;

import com.apptanamao.www.dto.LocationDTO;
import com.apptanamao.www.repository.document.po.LocationPO;
import com.apptanamao.www.service.interfaces.LocationService;
import com.apptanamao.www.vo.LocationVO;
import com.mongodb.Mongo;

@Service("locationService")
public class LocationServiceImpl implements LocationService{

	public LocationVO testeMongoDb(){
		
		String openshiftMongoDbHost = "ds057254-a.mongolab.com";//
        int openshiftMongoDbPort = 57254;
        String username = "owner";
        String password = "da88878685";
        Mongo mongo;
        MongoDbFactory mongoDbFactory = null;
        MongoTemplate mongoTemplate = null;
		try {
			mongo = new Mongo(openshiftMongoDbHost, openshiftMongoDbPort);
			UserCredentials userCredentials = new UserCredentials(username, password);
			String databaseName = "apptanamaodb";
			mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName, userCredentials);
			mongoTemplate = new MongoTemplate(mongoDbFactory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new LocationVO("Erro ao acessar o banco de dados",0,0);
		}
		LocationPO locationPO = new LocationPO(mongoDbFactory.toString(), 1111.2222, 33333.4444);
		mongoTemplate.insert(locationPO);
		
		LocationVO location2 = LocationDTO.getLocationVO(locationPO);
		
		return location2;
        //return mongoTemplate;
	}
}
