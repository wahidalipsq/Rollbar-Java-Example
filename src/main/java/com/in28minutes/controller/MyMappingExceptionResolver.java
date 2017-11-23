package com.in28minutes.controller;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.rollbar.api.payload.data.Server;
import com.rollbar.notifier.Rollbar;
import com.rollbar.web.provider.PersonProvider;
import com.rollbar.web.provider.RequestProvider;

public class MyMappingExceptionResolver extends SimpleMappingExceptionResolver {
	String accessToken = "8e194f5f31db4ff1b4e3e0951a40c936";
	Rollbar rollbar;

	public MyMappingExceptionResolver() {

		setWarnLogCategory(MyMappingExceptionResolver.class.getName());
	}

	@Override
	public String buildLogMessage(Exception e, HttpServletRequest req) {

		System.out.println("Exception : " + e.toString());
		RequestProvider requestProvider = new RequestProvider.Builder().userIpHeaderName(req.getRemoteAddr()).build();
		rollbar = Rollbar.init(withAccessToken(accessToken).request(requestProvider).build());
		rollbar.error(e);
		return "MVC exception: " + e.getLocalizedMessage();
	}

	@Override
	protected ModelAndView doResolveException(HttpServletRequest req, HttpServletResponse resp, Object handler,
			Exception ex) {
		ModelAndView mav = super.doResolveException(req, resp, handler, ex);
		mav.addObject("url", req.getRequestURL());
		return mav;
	}

}
