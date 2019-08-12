package com.yq.controller;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yq.entity.SysLog;
@Component
@Aspect
public class LogAop {
	private Date visitTime;
	private Class clazz;
	private Method method;
	@Autowired
	private HttpServletRequest request;
	//获取访问时间、访问类、方法
	@Before("execution(* com.yq.controller.*.*(..))")
	public void doBefore(JoinPoint jp) throws Exception{
		System.out.println("111111111111111111");
//		visitTime=new Date();
//		clazz=jp.getTarget().getClass();
//		String methodName=jp.getSignature().getName();
//		Object[]args=jp.getArgs();
//		Class[]params=new Class[args.length];
//		for(int i=0;i<args.length;i++){
//			params[i]=args[i].getClass();
//		}
//		method=clazz.getMethod(methodName, params);
	}
	//获取访问时长、url、ip、username
	@After("execution(* com.yq.controller.*.*(..))")
	public void doAfter(Joinpoint jp){
		System.out.println("2222222222222222222");
//		//时长
//		long time=new Date().getTime()-visitTime.getTime();
//		//获取Ip
//		String ip=request.getRemoteAddr();
//		//获取username
//		SecurityContext sc=SecurityContextHolder.getContext();
//		User user=(User)sc.getAuthentication().getPrincipal();
//		String username=user.getUsername();
//		//获取url
//		String url="";
//		if(clazz!=null&method!=null&clazz!=LogAop.class){
//			RequestMapping classRequestMapping=(RequestMapping)clazz.getAnnotation(RequestMapping.class);
//			if(classRequestMapping!=null){
//				String[]clazzValue=classRequestMapping.value();
//				RequestMapping methodRequestMapping=method.getAnnotation(RequestMapping.class);
//				String[]methodValue=methodRequestMapping.value();
//				url=clazzValue[0]+methodValue[0];
//			}
//		}
//		SysLog sysLog=new SysLog(UUID.randomUUID().toString().replace("-", ""),visitTime,visitTime.toLocaleString(),username,ip,url,time,method.getName());
//		System.out.println("-----------------------------");
//		System.out.println(sysLog);
//		System.out.println("--------------------------");
	}
}
