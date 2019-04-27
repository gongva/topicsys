package com.pzhu.topicsys.modules.topic.model;

public class TopicEntity {

	private String topicId;
	private String name;
	private String description;
	private String tId;
	private String tName;
	private String tDepartment;
	private String sId;
	private String sName;
	private int status;
	private String paperAddress;//论文下载地址

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettDepartment() {
		return tDepartment;
	}

	public void settDepartment(String tDepartment) {
		this.tDepartment = tDepartment;
	}

	
	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPaperAddress() {
		return paperAddress;
	}

	public void setPaperAddress(String paperAddress) {
		this.paperAddress = paperAddress;
	}

}
