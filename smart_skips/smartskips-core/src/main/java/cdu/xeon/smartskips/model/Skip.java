package cdu.xeon.smartskips.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;

@Entity
@Table(name="t_skip")
public class Skip {


	private int id;
private String name;
private String location;
      // 0:empty    1:full    2:processing
private int full;
 //  0:general waste 1:construction waste
 private int type;
 private double capacity;
private double currentCapacity;
 private int status;
 private double longitude;
 private double latitude;
 private int count;
 




public Skip(int id, String name, String location, int full, int type, double capacity, double currentCapacity,
		int status, double longitude,double latitude, int count) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
	this.full = full;
	this.type = type;
	this.capacity = capacity;
	this.currentCapacity = currentCapacity;
	this.status = status;
	this.longitude=longitude;
	this.latitude=latitude;
	this.count=count;
}

public Skip(int id, String name, String location, int full,int type) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
	this.full = full;
	this.type = type;
	
}

 public Skip() {
	 
 }

@Id
 @GeneratedValue
public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}

@NotNull(message="The skip name cannot be empty")
public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}

@NotNull(message="The location cannot be empty")
public String getLocation() {
	return location;
}


public void setLocation(String location) {
	this.location = location;
}

@NotNull(message="The full cannot be empty")
public int getFull() {
	return full;
}


public void setFull(int full) {
	this.full = full;
}

@NotNull(message="The type cannot be empty")
public int getType() {
	return type;
}


public void setType(int type) {
	this.type = type;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public double getCapacity() {
	return capacity;
}


public void setCapacity(double capacity) {
	this.capacity = capacity;
}

@Column(name="current_capacity")
public double getCurrentCapacity() {
	return currentCapacity;
}


public void setCurrentCapacity(double currentCapacity) {
	this.currentCapacity = currentCapacity;
}


public double getLongitude() {
	return longitude;
}

public void setLongitude(double longitude) {
	this.longitude = longitude;
}

public double getLatitude() {
	return latitude;
}

public void setLatitude(double latitude) {
	this.latitude = latitude;
}


public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}


@Override
public String toString() {
	return "Skip [id=" + id + ", name=" + name + ", location=" + location + ", full=" + full + ", type=" + type
			+ ", capacity=" + capacity + ", currentCapacity=" + currentCapacity + ", status=" + status + ", longitude="
			+ longitude + ", latitude=" + latitude + "]";
}



}
