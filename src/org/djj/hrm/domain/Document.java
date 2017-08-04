package org.djj.hrm.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Document implements Serializable{
     private int id;//id
     private String title;
     private String fileName;
     private MultipartFile file;//file
     private String remark;//详情
     private Date createDate;//up时间
     private User user;//上传人
     public Document() {
 		super();
 		// TODO Auto-generated constructor stub
 	}
 	// setter和getter方法
 	public void setId(int id){
 		this.id = id;
 	}
 	public int getId(){
 		return this.id;
 	}
 	public void setTitle(String title){
 		this.title = title;
 	}
 	public String getTitle(){
 		return this.title;
 	}
 	
 	public String getFileName() {
 		return fileName;
 	}
 	public void setFileName(String fileName) {
 		this.fileName = fileName;
 	}
 	public MultipartFile getFile() {
 		return file;
 	}
 	public void setFile(MultipartFile file) {
 		this.file = file;
 	}
 	public void setRemark(String remark){
 		this.remark = remark;
 	}
 	public String getRemark(){
 		return this.remark;
 	}
 	public void setCreateDate(java.util.Date createDate){
 		this.createDate = createDate;
 	}
 	public java.util.Date getCreateDate(){
 		return this.createDate;
 	}
 	public User getUser() {
 		return user;
 	}
 	public void setUser(User user) {
 		this.user = user;
 	}
 	@Override
 	public String toString() {
 		return "Document [id=" + id + ", title=" + title + ", fileName="
 				+ fileName + ", file=" + file + ", remark=" + remark
 				+ ", createDate=" + createDate + ", user=" + user + "]";
 	}
 	
 	
}
