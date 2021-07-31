package com.encore.spring.model;

import org.springframework.web.multipart.MultipartFile;

/*
 * 파일 업로드 폼을 잘 보고 만들어야한다. 
 */
public class UploadDataVO {
	private String userName;
	private MultipartFile[] uploadFiles; //uploadFiles이름으로 해야지만 업로드한 파일정보를 담을 수 있다.
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	
	
}
