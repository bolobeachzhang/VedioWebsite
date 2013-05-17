package com.videoManagement.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**   
 * @ClassName:Error404ResponseWrapper
 * @Description: TODO(用来处理404错误页面的) 
 * @author 张兵 【390125214@qq.com】
 * @date 2013-4-3 下午10:22:38 
 * @version V1.0   
 * @Copyright: Copyright (c) 2013
 * @Company:	成都大学信息科学与技术学院重点工作室
 */
class Error404ResponseWrapper extends HttpServletResponseWrapper {
    
    private int status = SC_OK;
    
    public Error404ResponseWrapper(Error404Filter error404Filter, HttpServletResponse response){
        super(response);
    }
    
    @Override
    public void sendError(int sc) throws IOException {
        this.status = sc;
        if(isFound()){
            super.sendError(sc);                
        }else{
            super.setStatus(SC_OK);
        }
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        this.status = sc;
        if(isFound()){
            super.sendError(sc,msg);  
        }else{
            super.setStatus(SC_OK);                 
        }
    }
    
    public void setStatus(int status){
       this.status = status;
       super.setStatus(status);
    }
    
    @Override
    public void reset() {
        this.status = SC_OK;
        super.reset();
    }

    
    public boolean isFound(){
        return status != SC_NOT_FOUND;
    }
}

