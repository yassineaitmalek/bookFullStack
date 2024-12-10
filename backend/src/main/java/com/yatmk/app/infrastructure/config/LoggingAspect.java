package com.yatmk.app.infrastructure.config;

import java.io.IOException;

import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

public class LoggingAspect {
}

// @Slf4j
// @Aspect
// @Component
// @EnableAspectJAutoProxy
// @RequiredArgsConstructor
// public class LoggingAspect extends OncePerRequestFilter {

// private static final String PACKAGE = "com.yatmk.app";

// private static final String METHOD_ARGS_TEMPLATE = "Class called: {} Method
// called: {} , Arguments: {}";

// private static final String METHOD_RETURN_TEMPLATE = "Class called: {} Method
// returned: {} , Return value: {}";

// private static final String METHOD_EXCEPTION_TEMPLATE = "Class called: {}
// Method threw exception: {} , Exception: {}";

// private static final String METHOD_DURATION_TEMPLATE = "Class called: {}
// Method called: {} executed in {} ms";

// private static final String URL_START_PROCESS_TEMPLATE = "Start Processing :
// Method = {}; Request URI = {};";

// private static final String URL_FINISH_PROCESS_TEMPLATE = "Finished
// Processing : Method = {}; Request URI = {}; Request Payload = {}; Response
// code = {}; Time taken = {} ms";

// private final KeycloakSecurityContext keycloakSecurityContext;

// public String getActor() {

// return Try.of(() -> keycloakSecurityContext)
// .mapTry(KeycloakSecurityContext::getToken)
// .mapTry(AccessToken::getSubject)
// .getOrElse(() -> "undefined");

// }

// private String getMethodName(JoinPoint joinPoint) {
// return Try.of(() -> joinPoint)
// .mapTry(JoinPoint::getSignature)
// .mapTry(Signature::getName)
// .getOrElse(String::new);
// }

// private String getClassName(JoinPoint joinPoint) {
// return Try.of(() -> joinPoint)
// .mapTry(JoinPoint::getSignature)
// .mapTry(Signature::getDeclaringTypeName)
// .getOrElse(String::new);
// }

// private String getArgs(JoinPoint joinPoint) {
// return Try.of(() ->
// joinPoint).mapTry(JoinPoint::getArgs).mapTry(Arrays::toString).getOrElse(String::new);
// }

// @Before("execution(* " + PACKAGE + "..*(..))")
// public void logMethodCall(JoinPoint joinPoint) {

// log.info(METHOD_ARGS_TEMPLATE, getClassName(joinPoint),
// getMethodName(joinPoint), getArgs(joinPoint));

// }

// @Around("execution(* " + PACKAGE + "..*(..))")
// public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws
// Throwable {
// long start = System.currentTimeMillis();
// Object result = joinPoint.proceed();
// long duration = System.currentTimeMillis() - start;

// log.info(METHOD_DURATION_TEMPLATE, getClassName(joinPoint),
// getMethodName(joinPoint), duration);

// return result;
// }

// @AfterReturning(pointcut = "execution(* " + PACKAGE + "..*(..))", returning =
// "result")
// public void logAfterReturning(JoinPoint joinPoint, Object result) {

// log.info(METHOD_RETURN_TEMPLATE, getClassName(joinPoint),
// getMethodName(joinPoint), result);

// }

// @AfterThrowing(pointcut = "execution(* " + PACKAGE + "..*(..))", throwing =
// "error")
// public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

// log.error(METHOD_EXCEPTION_TEMPLATE, getClassName(joinPoint),
// getMethodName(joinPoint), error);

// }

// public String getMethod(HttpServletRequest request) {

// return Try.of(() ->
// request).mapTry(HttpServletRequest::getMethod).getOrElse(String::new);
// }

// public String getURI(HttpServletRequest request) {

// return Try.of(() ->
// request).mapTry(HttpServletRequest::getRequestURI).getOrElse(String::new);
// }

// @Override
// protected void doFilterInternal(@NonNull HttpServletRequest request,
// @NonNull HttpServletResponse response,
// @NonNull FilterChain filterChain)
// throws ServletException, IOException {

// long startTime = System.currentTimeMillis();
// log.info(URL_START_PROCESS_TEMPLATE, getMethod(request), getURI(request));
// ContentCachingRequestWrapper requestWrapper = new
// ContentCachingRequestWrapper(request);
// ContentCachingResponseWrapper responseWrapper = new
// ContentCachingResponseWrapper(response);
// filterChain.doFilter(requestWrapper, responseWrapper);
// long timeTaken = System.currentTimeMillis() - startTime;
// String requestBody = getRequest(requestWrapper.getContentAsByteArray(),
// request.getCharacterEncoding());
// responseWrapper.copyBodyToResponse();
// log.info(
// URL_FINISH_PROCESS_TEMPLATE, getMethod(request), getURI(request),
// requestBody, response.getStatus(),
// timeTaken);

// }

// private String getRequest(byte[] contentAsByteArray, String
// characterEncoding) {

// return Try.of(() -> new String(contentAsByteArray, 0,
// contentAsByteArray.length, characterEncoding))
// .getOrElse(String::new);

// }
// }
