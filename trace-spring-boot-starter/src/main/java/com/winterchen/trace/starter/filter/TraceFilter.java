package com.winterchen.trace.starter.filter;


import com.winterchen.trace.starter.constants.Constants;
import com.winterchen.trace.starter.factory.TraceContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author winterchen
 * @since 1.0
 */
public class TraceFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraceFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String headerTraceId = httpServletRequest.getHeader(Constants.LEGACY_TRACE_ID_NAME);
        String headerParentServiceName = httpServletRequest.getHeader(Constants.LEGACY_PARENT_SERVICE_NAME);


        Map<String, String> map = new HashMap<>(16);
        map.put(Constants.LEGACY_TRACE_ID_NAME, headerTraceId);
        map.put(Constants.LEGACY_PARENT_SERVICE_NAME, headerParentServiceName);
        TraceContentFactory.storageMDC(map);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("URL ===> {}", httpServletRequest.getRequestURI());
            LOGGER.info("IP ===> {}",httpServletRequest.getRemoteAddr());
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        MDC.clear();
    }

}
