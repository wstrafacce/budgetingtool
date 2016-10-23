package br.com.budgetingtool.api;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;


public class AuthFilterImpl extends OncePerRequestFilter{
	public static final String XAUTH = "Authorization";
	private static final String AUTH_ERROR_URL = "/permDenied";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chainFilter) throws ServletException, IOException {
		final String xAuth = request.getHeader(XAUTH);
		if (xAuth == null || xAuth.isEmpty()){
			response.sendRedirect(AUTH_ERROR_URL);
		} else {
			chainFilter.doFilter(request, response);
		}
	}
}
