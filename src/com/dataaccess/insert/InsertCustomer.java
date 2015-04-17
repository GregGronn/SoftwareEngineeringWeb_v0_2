package com.dataaccess.insert;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.business.Customer;
import com.dataaccess.DbAccessor;

public class InsertCustomer extends DbAccessor{
	
	private int cno;
	private String cname;
	private int phone;
	private boolean member_status;

	
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

	public InsertCustomer(){
	}

	public InsertCustomer(String query){
		super.setQuery(query);
	}

	


	public boolean execute(){
		StringBuilder sb = new StringBuilder("");
		sb.append("Insert into s_customer values (");
		sb.append(this.cno);
		sb.append(", '");
		sb.append( this.cname);
		sb.append("', ");
		sb.append(this.phone);
		sb.append(", ");
		sb.append(this.member_status);
		sb.append("')");
		setQuery(sb.toString());
		System.out.println(sb.toString());
		return super.execute();
	}
}
