package com.in28minutes.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.rollbar.notifier.Rollbar;
import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

/*@ControllerAdvice
@EnableWebMvc*/
public class GlobalExceptionHandlerController {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        
    	final Rollbar rollbar = new Rollbar(withAccessToken("8e194f5f31db4ff1b4e3e0951a40c936")
				.environment("production").handleUncaughtErrors(true).build());
        rollbar.error(e);
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
