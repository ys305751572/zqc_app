package com.leoman.common.filter;

import com.leoman.admin.entity.Admin;
import com.leoman.common.logger.Logger;
import com.leoman.common.core.Constant;
import com.leoman.index.servlet.ParameterRequestWrapper;
import com.leoman.utils.WebUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangbin on 2015/8/10.
 */
public class ApiFilter implements Filter {

    private static String[] SKIP_URLS = new String[]{};

    public ApiFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /*String urls = filterConfig.getInitParameter("skipUrls");
        if (StringUtils.isNotBlank(urls)) {
            String temp[] = urls.split(",");
            List<String> list = new ArrayList<String>();

            for (String skipUrl : temp) {
                if (StringUtils.isNotBlank(skipUrl)) {
                    skipUrl = "^" + skipUrl.replaceAll("\\*", ".*") + "$";
                    list.add(skipUrl);
                }
            }
            SKIP_URLS = list.toArray(SKIP_URLS);
        }*/
    }


    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        //        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//
//        Map<String,String[]> m = new HashMap<String,String[]>(httpRequest.getParameterMap());
//        request = new ParameterRequestWrapper((HttpServletRequest)request, m);
//
//        boolean allow = true;
//
//        String error = request.getParameter("error");
//        if(StringUtils.isNotBlank(error)) {
//        	allow = false;
//        }
//
//        String token = request.getParameter("token");
//        if(StringUtils.isBlank(token) || !token.equals(Constant.ACCESS_KEY)) {
//        	allow = false;
//        }
//        if( !allow ) {
//        	httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
//           	return;
//        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
