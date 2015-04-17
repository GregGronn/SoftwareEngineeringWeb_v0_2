package com.dataaccess.insert;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.business.Customer;
import com.dataaccess.DbAccessor;

public class InsertCurrentCustomer extends DbAccessor{
	
	private int cno;
	private String cname;
	private int phone;
	private boolean member_status;
	private Timestamp time_started = null;
	private Timestamp time_ended = null;
	private String game_playing;
	
	public InsertCurrentCustomer(){
	}

	public InsertCurrentCustomer(String query){
		super.setQuery(query);
	}

	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public boolean isMember_status() {
		return member_status;
	}
	public void setMember_status(boolean member_status) {
		this.member_status = member_status;
	}
	public Timestamp getTime_started() {
		return time_started;
	}
	public void setTime_started(Timestamp time_started) {
		this.time_started = new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
	public Timestamp getTime_ended() {
		return time_ended;
	}
	public void setTime_ended(Timestamp time_ended) {
		this.time_ended = new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
	public String getGame_playing() {
		return game_playing;
	}
	public void setGame_playing(String game_playing) {
		this.game_playing = game_playing;
	}

	public boolean execute(){
		StringBuilder sb = new StringBuilder("");
		sb.append("Insert into s_current values (");
		sb.append(this.cno);
		sb.append(", '");
		sb.append( this.cname);
		sb.append("', ");
		sb.append(this.phone);
		sb.append(", ");
		sb.append(this.member_status);
		sb.append(", ");
		sb.append(this.time_started);
		sb.append(", ");
		sb.append(this.time_ended);
		sb.append(", '");
		sb.append(this.game_playing);
		sb.append("')");
		setQuery(sb.toString());
		System.out.println(sb.toString());
		return super.execute();
	}
}
