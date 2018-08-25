package org.java.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver {
	
	@Override
	public ModelAndView resolveException(HttpServletRequest req,HttpServletResponse res, Object handler, Exception ex) {
		
		String msg =ex.getMessage();
		
		if(ex instanceof UnauthorizedException){
			msg = "访问权限不足";
		}
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("err",msg);
		
		mv.setViewName("/index");
		
		return mv;
	}

}
