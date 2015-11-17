package com.wannafitshare.vo;

import java.io.Serializable;

public class Customer implements Serializable {

	private String csId;
	private String csPassword;
	private String csName;
	private String csEmail;
	private String csPhone;

	public Customer() {
	}

	public Customer(String csId, String csPassword, String csName,
			String csEmail, String csPhone) {
		this.csId = csId;
		this.csPassword = csPassword;
		this.csName = csName;
		this.csEmail = csEmail;
		this.csPhone = csPhone;
	}

	public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}

	public String getCsPassword() {
		return csPassword;
	}

	public void setCsPassword(String csPassword) {
		this.csPassword = csPassword;
	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public String getCsEmail() {
		return csEmail;
	}

	public void setCsEmail(String csEmail) {
		this.csEmail = csEmail;
	}

	public String getCsPhone() {
		return csPhone;
	}

	public void setCsPhone(String csPhone) {
		this.csPhone = csPhone;
	}

	@Override
	public String toString() {
		return "Customer [csId=" + csId + ", csPassword=" + csPassword
				+ ", csName=" + csName + ", csEmail=" + csEmail + ", csPhone="
				+ csPhone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((csEmail == null) ? 0 : csEmail.hashCode());
		result = prime * result + ((csId == null) ? 0 : csId.hashCode());
		result = prime * result + ((csName == null) ? 0 : csName.hashCode());
		result = prime * result
				+ ((csPassword == null) ? 0 : csPassword.hashCode());
		result = prime * result + ((csPhone == null) ? 0 : csPhone.hashCode());
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
		Customer other = (Customer) obj;
		if (csEmail == null) {
			if (other.csEmail != null)
				return false;
		} else if (!csEmail.equals(other.csEmail))
			return false;
		if (csId == null) {
			if (other.csId != null)
				return false;
		} else if (!csId.equals(other.csId))
			return false;
		if (csName == null) {
			if (other.csName != null)
				return false;
		} else if (!csName.equals(other.csName))
			return false;
		if (csPassword == null) {
			if (other.csPassword != null)
				return false;
		} else if (!csPassword.equals(other.csPassword))
			return false;
		if (csPhone == null) {
			if (other.csPhone != null)
				return false;
		} else if (!csPhone.equals(other.csPhone))
			return false;
		return true;
	}

}
