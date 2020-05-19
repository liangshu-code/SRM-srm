package com.ilp3.common.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ilp3.common.annotation.Log;
import com.ilp3.common.dao.LogMapper;
import com.ilp3.common.domain.SysLogDO;
import com.ilp3.common.utils.HttpContextUtils;
import com.ilp3.common.utils.IPUtils;
import com.ilp3.common.utils.JSONUtils;
import com.ilp3.common.utils.ShiroUtils;
import com.ilp3.system.entity.SysUserDO;

@Aspect
@Component
public class LogAspect {
	@Autowired
	LogMapper logMapper;

	private static Logger logger = LoggerFactory.getLogger(LogAspect.class);
	ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	@Pointcut("@annotation(com.ilp3.common.annotation.Log)")
	public void logPointCutDB() {
	}

	@Pointcut("execution(* com.ilp3.*.controller.*.*(..))")
	public void logPointCut() {
	}

	@Around("logPointCutDB()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		// 执行方法
		Object result = point.proceed();
		// 执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;
		// 保存日志
		saveLog(point, time);
		return result;
	}

	@Before("logPointCut()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());

		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

	}

	@AfterReturning(returning = "ret", pointcut = "logPointCut()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.info("RESPONSE : " + ret);
		logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	}

	// 异常通知
	// @AfterThrowing(pointcut = "logPointCut()&&logPointCutDB()", throwing = "e")
	@AfterThrowing(pointcut = "logPointCut()", throwing = "e")
	public void myThrowingAdvice(JoinPoint jionpoint, Exception e) {
		// 获取被调用的类名
		String targetClassName = jionpoint.getTarget().getClass().getName();
		// 获取被调用的方法名
		String targetMethodName = jionpoint.getSignature().getName();
		// 日志格式字符串
		String logInfoText = "异常通知：执行" + targetClassName + "类的"
				+ targetMethodName + "方法时发生异常:"+e.toString();
		// 将日志信息写入配置的文件中
		logger.error(logInfoText);
	}

	private void saveLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLogDO sysLog = new SysLogDO();
		Log syslog = method.getAnnotation(Log.class);
		if (syslog != null) {
			// 注解上的描述
			sysLog.setOperation(syslog.value());
		}
		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");
		// 请求的参数
		Object[] args = joinPoint.getArgs();
		try {
			String params = JSONUtils.beanToJson(args);
			if(params != null && params.length()>5000){
				params = params.substring(0,5000);
			}
			sysLog.setParams(params);
		} catch (Exception e) {

		}
		// 获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		// 设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));
		// 用户名
		SysUserDO currUser = ShiroUtils.getUser();
		if (null == currUser) {
			if (null == sysLog.getParams()) {
				sysLog.setUserId(-1L);
				sysLog.setUsername(sysLog.getParams());
			} else {
				sysLog.setUserId(-1L);
				sysLog.setUsername("获取用户信息为空");
			}
		} else {
			sysLog.setUserId(ShiroUtils.getUserId());
			sysLog.setUsername(ShiroUtils.getUser().getUsername());
		}
		sysLog.setTime((int) time);
		// 系统当前时间
		Date date = new Date();
		sysLog.setGmtCreate(date);
		// 保存系统日志
		logMapper.save(sysLog);
	}
}
