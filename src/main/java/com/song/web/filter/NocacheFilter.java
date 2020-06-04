package com.song.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class NocacheFilter extends OncePerRequestFilter{
	
	@Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {

        res.setHeader("Cache-Control","no-cache,no-store,must-revalidate,private,max-age=0");
        res.setHeader("Pragma","no-cache");
        res.setDateHeader("Expires",0);        

        chain.doFilter(req, res);
        }

}
