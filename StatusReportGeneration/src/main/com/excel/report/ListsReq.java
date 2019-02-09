package com.excel.report;

public class ListsReq {
	
 private String  names;
	/**
 * @return the names
 */
public String getNames() {
	return names;
}


/**
 * @param names the names to set
 */
public void setNames(String names) {
	this.names = names;
}


/**
 * @return the status
 */
public String getStatus() {
	return status;
}


/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}


/**
 * @return the time
 */
public String getTime() {
	return time;
}


/**
 * @param time the time to set
 */
public void setTime(String time) {
	this.time = time;
}


	private String status;
	private String time;
	
	public ListsReq() {}
	
	
public ListsReq(String names, String status, String time) {
	
	this.names=names;
	this.status=status;
	this.time=time;
}
}
