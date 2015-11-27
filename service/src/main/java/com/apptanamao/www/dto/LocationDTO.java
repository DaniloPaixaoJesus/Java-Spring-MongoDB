package com.apptanamao.www.dto;

import com.apptanamao.www.repository.document.po.LocationPO;
import com.apptanamao.www.vo.LocationVO;

public class LocationDTO {

	public static LocationVO getLocationVO(LocationPO locationPO){
		LocationVO locationVO = new LocationVO(locationPO.getDescription(), locationPO.getLatitude(), locationPO.getLongitude());
		return locationVO;
	}
	
	public static LocationPO getLocationPO(LocationPO locationVO){
		LocationPO locationPO = new LocationPO(locationVO.getDescription(), locationVO.getLatitude(), locationVO.getLongitude());
		return locationPO;
	}
}
