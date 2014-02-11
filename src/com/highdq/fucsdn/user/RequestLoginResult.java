package com.highdq.fucsdn.user;

public class RequestLoginResult {
	private boolean status;
	private String error;
	private DataObject data;	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public DataObject getData() {
		return data;
	}
	public void setData(DataObject data) {
		this.data = data;
	}
	public static class DataObject {
		private String userId;
		private String userName;
		private String password;
		private String email;
		private String lastLoginTime;
		private String loginTimes;
		private String lastLoginIP;
		private boolean isDeleted;
		private String registerIP;
		private String registerTime;
		private boolean isActived;
		private int role;
		private int userType;
		private boolean isLocked;
		private String encryptUserInfo;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getLastLoginTime() {
			return lastLoginTime;
		}
		public void setLastLoginTime(String lastLoginTime) {
			this.lastLoginTime = lastLoginTime;
		}
		public String getLoginTimes() {
			return loginTimes;
		}
		public void setLoginTimes(String loginTimes) {
			this.loginTimes = loginTimes;
		}
		public String getLastLoginIP() {
			return lastLoginIP;
		}
		public void setLastLoginIP(String lastLoginIP) {
			this.lastLoginIP = lastLoginIP;
		}
		public boolean isDeleted() {
			return isDeleted;
		}
		public void setIsDeleted(boolean isDeleted) {
			this.isDeleted = isDeleted;
		}
		public String getRegisterIP() {
			return registerIP;
		}
		public void setRegisterIP(String registerIP) {
			this.registerIP = registerIP;
		}
		public String getRegisterTime() {
			return registerTime;
		}
		public void setRegisterTime(String registerTime) {
			this.registerTime = registerTime;
		}
		public boolean isActived() {
			return isActived;
		}
		public void setIsActived(boolean isActived) {
			this.isActived = isActived;
		}
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}
		public int getUserType() {
			return userType;
		}
		public void setUserType(int userType) {
			this.userType = userType;
		}
		public boolean isLocked() {
			return isLocked;
		}
		public void setIsLocked(boolean isLocked) {
			this.isLocked = isLocked;
		}
		public String getEncryptUserInfo() {
			return encryptUserInfo;
		}
		public void setEncryptUserInfo(String encryptUserInfo) {
			this.encryptUserInfo = encryptUserInfo;
		}
	}
}
