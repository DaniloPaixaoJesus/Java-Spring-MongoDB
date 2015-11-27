package com.apptanamao.www.vo;

import java.util.Date;

/**
 * class represent the where Ad is, and at moment
 * @author danilo
 *
 */
public class LocationVO {
	private long id;
	private long adId;
	private String description;
	private double latitude;
	private double longitude;
	private Date timestamp;
	
	public LocationVO(){}
	
	public LocationVO(String descr, double lat, double longi){
		this.description = descr;
		this.latitude = lat;
		this.longitude = longi;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAdId() {
		return adId;
	}

	public void setAdId(long adId) {
		this.adId = adId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String toString() {
		return "[" + getDescription()
		+ ", " + getAdId()
		+ ", " + getTimestamp()
		+ ", " + getLatitude()
		+ ", " + getLongitude()
		+ "]";
	}
}
