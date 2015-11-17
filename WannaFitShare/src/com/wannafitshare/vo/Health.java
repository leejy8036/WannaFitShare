package com.wannafitshare.vo;

import java.io.Serializable;

public class Health implements Serializable {

	private String csId;
	private double hWeight;
	private double tall;
	private String hBloodType;
	private double hBloodPressure;
	private double hBMI;
	private double hBloodSugar;
	private double hLDL;
	private double hHDH;

	public Health() {
		super();
	}

	public Health(String csId, double hWeight, double tall, String hBloodType,
			double hBloodPressure, double hBMI, double hBloodSugar, double hLDL,
			double hHDH) {
		super();
		this.csId = csId;
		this.hWeight = hWeight;
		this.tall = tall;
		this.hBloodType = hBloodType;
		this.hBloodPressure = hBloodPressure;
		this.hBMI = hBMI;
		this.hBloodSugar = hBloodSugar;
		this.hLDL = hLDL;
		this.hHDH = hHDH;
	}

	public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}

	public double gethWeight() {
		return hWeight;
	}

	public void sethWeight(double hWeight) {
		this.hWeight = hWeight;
	}

	public double getTall() {
		return tall;
	}

	public void setTall(double tall) {
		this.tall = tall;
	}

	public String gethBloodType() {
		return hBloodType;
	}

	public void sethBloodType(String hBloodType) {
		this.hBloodType = hBloodType;
	}

	public double gethBloodPressure() {
		return hBloodPressure;
	}

	public void sethBloodPressure(double hBloodPressure) {
		this.hBloodPressure = hBloodPressure;
	}

	public double gethBMI() {
		return hBMI;
	}

	public void sethBMI(double hBMI) {
		this.hBMI = hBMI;
	}

	public double gethBloodSugar() {
		return hBloodSugar;
	}

	public void sethBloodSugar(double hBloodSugar) {
		this.hBloodSugar = hBloodSugar;
	}

	public double gethLDL() {
		return hLDL;
	}

	public void sethLDL(double hLDL) {
		this.hLDL = hLDL;
	}

	public double gethHDH() {
		return hHDH;
	}

	public void sethHDH(double hHDH) {
		this.hHDH = hHDH;
	}

	@Override
	public String toString() {
		return "Health [csId=" + csId + ", hWeight=" + hWeight + ", tall="
				+ tall + ", hBloodType=" + hBloodType + ", hBloodPressure="
				+ hBloodPressure + ", hBMI=" + hBMI + ", hBloodSugar="
				+ hBloodSugar + ", hLDL=" + hLDL + ", hHDH=" + hHDH + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((csId == null) ? 0 : csId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(hBMI);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(hBloodPressure);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(hBloodSugar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((hBloodType == null) ? 0 : hBloodType.hashCode());
		temp = Double.doubleToLongBits(hHDH);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(hLDL);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(hWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tall);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Health other = (Health) obj;
		if (csId == null) {
			if (other.csId != null)
				return false;
		} else if (!csId.equals(other.csId))
			return false;
		if (Double.doubleToLongBits(hBMI) != Double
				.doubleToLongBits(other.hBMI))
			return false;
		if (Double.doubleToLongBits(hBloodPressure) != Double
				.doubleToLongBits(other.hBloodPressure))
			return false;
		if (Double.doubleToLongBits(hBloodSugar) != Double
				.doubleToLongBits(other.hBloodSugar))
			return false;
		if (hBloodType == null) {
			if (other.hBloodType != null)
				return false;
		} else if (!hBloodType.equals(other.hBloodType))
			return false;
		if (Double.doubleToLongBits(hHDH) != Double
				.doubleToLongBits(other.hHDH))
			return false;
		if (Double.doubleToLongBits(hLDL) != Double
				.doubleToLongBits(other.hLDL))
			return false;
		if (Double.doubleToLongBits(hWeight) != Double
				.doubleToLongBits(other.hWeight))
			return false;
		if (Double.doubleToLongBits(tall) != Double
				.doubleToLongBits(other.tall))
			return false;
		return true;
	}

}
