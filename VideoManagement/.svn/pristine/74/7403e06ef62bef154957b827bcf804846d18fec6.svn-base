package com.videoManagement.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
 * @ClassName:Error404Filter
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 张兵 【390125214@qq.com】
 * @date 2013-4-3 下午10:23:33 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
public class Error404Filter implements Filter {
	    public void destroy() {
	    }

	    @Override
	    public void init(FilterConfig config) throws ServletException {
	    }
	    
	    @Override
	    public void doFilter(ServletRequest req, ServletResponse rep,FilterChain chain) throws IOException, ServletException {
	        
	        HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) rep;
	        Error404ResponseWrapper responseWrapper = new Error404ResponseWrapper(this, response);
	        
	        chain.doFilter(request, responseWrapper);
	        if(responseWrapper.isFound()){
	            return ;
	        }
	        
	        //TODO 实现读取资源
	        //readResource(request,response);
	        
	        //资源不存在返回错误
	        String uri = request.getRequestURI();
	        System.out.println(uri+"uri是。。。。");
	        response.sendError(HttpServletResponse.SC_NOT_FOUND,uri);
	    }

		}
