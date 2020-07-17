package com.mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@WebServlet("/sai")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	try
	{
		PrintWriter pw = response.getWriter();
		int start = Integer.parseInt(request.getParameter("from"));
		String destination = request.getParameter("to");
		
		DefaultHttpClient d =  new DefaultHttpClient();
		HttpGet g = new HttpGet("http://localhost:8080/RestWebservice/employee?id="+start+"&name="+destination);
		g.setHeader("accept", "application/json");
	    HttpResponse execute = d.execute(g);
	  InputStream  ios = execute.getEntity().getContent();
	  InputStreamReader irs = new InputStreamReader(ios);
	  BufferedReader bos = new BufferedReader(irs);
	  String line ; 
	  while((line= bos.readLine())!= null)
	  {
		pw.println(line);  
	  }
	          
	}
	catch(Exception e)
	{
		
	}
	}
	}

	
	


