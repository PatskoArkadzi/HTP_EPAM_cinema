package by.htp.epam.cinema.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * filter class for state request and responce encoding
 * 
 * @author Arkadzi Patsko
 *
 */
public class CharacterEncodingFilter implements Filter {
	/**
	 * encoding field
	 */
	private String encoding;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String requestEncoding = request.getCharacterEncoding();
		if (encoding != null && !encoding.equalsIgnoreCase(requestEncoding)) {
			request.setCharacterEncoding(encoding);
		}
		String responseEncoding = response.getCharacterEncoding();
		if (encoding != null && !encoding.equalsIgnoreCase(responseEncoding)) {
			response.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void destroy() {
		encoding = null;
	}
}
