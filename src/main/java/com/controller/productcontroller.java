package com.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.product;
import com.dao.productDao;


@WebServlet("/productcontroller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024 * 512) // 512MB
public class productcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private String extractfilename(Part file) {
	    	 String cd = file.getHeader("content-disposition");
	    	 System.out.println(cd);//form-data; name="product_image"; filename="shoes1.jpg"
	    	 String[] iteam = cd.split(";");
	    	 for(String string : iteam) {
	    		 if(string.trim().startsWith("filename")) {
	    			 return string.substring(string.indexOf("=") + 2, string.length()-1);
	    		 }
	    	 }
	    	 return "";
	     }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             
	          String action=request.getParameter("action");
              
	          
              if(action.equalsIgnoreCase("add product"))
              {    
            	  String savepath = "C:\\Users\\HP\\eclipse-workspace\\Rajproject\\src\\main\\webapp\\product_image";
            	  File filesaveDir=new File(savepath);
            	  if(!filesaveDir.exists()) {
            		  filesaveDir.mkdir();
            	  }
            	  Part file1 = (Part) request.getPart("product_image");
            	  String filename=extractfilename(file1);
            	  file1.write(savepath + File.separator + filename);
            	  String filepath= savepath + File.separator + filename;
            	  
            	  String savepath2 = "C:\\Users\\HP\\eclipse-workspace\\Rajproject\\src\\main\\webapp\\product_image";
            	  File imgsaveDir=new File(savepath2);
            	  if(!imgsaveDir.exists()) {
            		  imgsaveDir.mkdir();
            	  }
            	  
            	  product p=new product();
            	  p.setSeller(Integer.parseInt(request.getParameter("seller")));
            	  p.setProduct_category(request.getParameter("product_category"));
            	  p.setProduct_name(request.getParameter("product_name"));
            	  p.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
            	  p.setProduct_desc(request.getParameter("product_desc"));
            	  p.setProduct_image(filename);
            	  productDao.addproduct(p);
            	  request.setAttribute("msg", "Product Added Successfully");
            	  request.getRequestDispatcher("seller-add-product.jsp").forward(request, response);
                  
            	  
              }
              else if(action.equalsIgnoreCase("update product"))
              {
            	  product p=new product();
            	  try { 
            	  String savepath = "C:\\Users\\HP\\eclipse-workspace\\Rajproject\\src\\main\\webapp\\product_image";
            	  File filesaveDir=new File(savepath);
            	  if(!filesaveDir.exists()) {
            		  filesaveDir.mkdir();
            	  }
            	  Part file1 = (Part) request.getPart("product_image");
            	  String filename=extractfilename(file1);
            	  p.setProduct_image(filename);
            	  file1.write(savepath + File.separator + filename);
            	  String filepath= savepath + File.separator + filename;
            	  
            	  String savepath2 = "C:\\Users\\HP\\eclipse-workspace\\Rajproject\\src\\main\\webapp\\product_image";
            	  File imgsaveDir=new File(savepath2);
            	  if(!imgsaveDir.exists()) {
            		  imgsaveDir.mkdir();
            	  }
            	  }catch (Exception e) {
            	    e.printStackTrace();
            	    p.setProduct_image(request.getParameter("product_image1"));
            	  }
            	  
            	  p.setPid(Integer.parseInt(request.getParameter("pid")));
            	  p.setSeller(Integer.parseInt(request.getParameter("seller")));
            	  p.setProduct_category(request.getParameter("product_category"));
            	  p.setProduct_name(request.getParameter("product_name"));
            	  p.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
            	  p.setProduct_desc(request.getParameter("product_desc"));
            	 
            	  productDao.updateproduct(p);
            	  request.setAttribute("msg", "Product Added Successfully");
            	  request.getRequestDispatcher("seller-add-product.jsp").forward(request, response);
                  
              }
	}

}
