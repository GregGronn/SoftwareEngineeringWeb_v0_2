package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.CashOutBean;
import com.beans.CompanyBean;
import com.beans.CustomerBean;
import com.beans.GameBean;
import com.beans.MembershipBean;
import com.beans.StopBean;
import com.beans.TransferBean;
import com.command.CashOutCommand;
import com.command.MembershipCommand;
import com.command.StopCommand;
import com.command.parameters.CommandParameter;
import com.commands.CompanyCommand;
import com.commands.CustomerCommand;
import com.commands.GameCommand;
import com.commands.LoginCommand;
import com.commands.TransferCommand;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}


	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requester = request.getParameter("requester");
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		if("company".equalsIgnoreCase(requester)){
			CompanyCommand cmd = new CompanyCommand();
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				CompanyBean bean = cmd.getBean();
				//request.setAttribute("result", bean);
				session.setAttribute("result", bean);
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}
			
		}else if("customer".equalsIgnoreCase(requester)){
			CustomerCommand cmd = new CustomerCommand();
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				CustomerBean bean = cmd.getBean();
				//request.setAttribute("result", bean);
				session.setAttribute("result", bean);
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}

		}else if("game".equalsIgnoreCase(requester)){
			GameCommand cmd = new GameCommand();
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				GameBean bean = cmd.getBean();
				//request.setAttribute("result", bean);
				session.setAttribute("result", bean);
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}
		}else if("login".equalsIgnoreCase(requester)){
			LoginCommand cmd = new LoginCommand();
			cmd.setParameters(getParameters(request));
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				session.setAttribute("USER", cmd.getUserName());
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}
		}else if("transfer".equalsIgnoreCase(requester)){
			TransferCommand cmd = new TransferCommand();
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				TransferBean bean = cmd.getBean();
				//request.setAttribute("result", bean);
				session.setAttribute("result", bean);
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}
		}else if("cashout".equalsIgnoreCase(requester)){
			CashOutCommand cmd = new CashOutCommand();
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				CashOutBean bean = cmd.getBean();
				//request.setAttribute("result", bean);
				session.setAttribute("result", bean);
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}
		}else if("membership".equalsIgnoreCase(requester)){
			MembershipCommand cmd = new MembershipCommand();
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				MembershipBean bean = cmd.getBean();
				//request.setAttribute("result", bean);
				session.setAttribute("result", bean);
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}
		}else if("stop".equalsIgnoreCase(requester)){
			StopCommand cmd = new StopCommand();
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				StopBean bean = cmd.getBean();
				//request.setAttribute("result", bean);
				session.setAttribute("result", bean);
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}

		}
		rd.forward(request, response);
	}
	private synchronized ArrayList<CommandParameter>getParameters(HttpServletRequest request){
		ArrayList<CommandParameter>paramList = new ArrayList<CommandParameter>();
		request.getParameterMap();
		for(String key : request.getParameterMap().keySet()){
			CommandParameter cp = new CommandParameter();
			cp.setName(key);
			cp.setValue(request.getParameter(key));
			paramList.add(cp);
		}
		return paramList;
		
	}
}
