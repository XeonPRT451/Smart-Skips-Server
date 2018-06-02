package cdu.xeon.smartskips.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_landfill")
public class Landfill {
	
	    private int id;
	    private String name;
	    private String address;
	    private double GWCapacity;
	    private double currentGWCapacity;
	    private double CWCapacity;
	    private double currentCWCapacity;
	    private int status;
	    private double longitude;
	    private double latitude;
	    

	    public Landfill(int id, String name, String address) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
		}

	    public Landfill() {
	    	
	    }

		@Id
	    @GeneratedValue
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}

		@NotNull(message="The landfill name cannot be empty")
		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}

		@NotNull(message="The location cannot be empty")
		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public double getGWCapacity() {
			return GWCapacity;
		}


		public void setGWCapacity(double gWCapacity) {
			GWCapacity = gWCapacity;
		}

		@Column(name="current_GWCapacity")
		public double getCurrentGWCapacity() {
			return currentGWCapacity;
		}


		public void setCurrentGWCapacity(double currentGWCapacity) {
			this.currentGWCapacity = currentGWCapacity;
		}


		public double getCWCapacity() {
			return CWCapacity;
		}


		public void setCWCapacity(double cWCapacity) {
			CWCapacity = cWCapacity;
		}

		@Column(name="current_CWCapacity")
		public double getCurrentCWCapacity() {
			return currentCWCapacity;
		}


		public void setCurrentCWCapacity(double currentCWCapacity) {
			this.currentCWCapacity = currentCWCapacity;
		}

		 public int getStatus() {
				return status;
			}

			public void setStatus(int status) {
				this.status = status;
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
	 
			
			
}
