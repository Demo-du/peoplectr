package org.djj.hrm.domain;

import java.io.Serializable;

public class Dept implements Serializable{
    private Integer id;//id
    private String name;//部门名
    private String remark;//详细描述
    public Dept() {
		super();
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return this.remark;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
}
