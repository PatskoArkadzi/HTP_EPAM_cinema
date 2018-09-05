package by.htp.epam.cinema.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tag for pagination
 * 
 * @author Arkadzi Patsko
 *
 */
public class Paginator extends TagSupport {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = 5912634874090741720L;

	private static Logger logger = LoggerFactory.getLogger(Paginator.class);
	/**
	 * count field
	 */
	private int count;
	/**
	 * step field
	 */
	private int step;
	/**
	 * urlprefix field
	 */
	private String urlprefix;

	/**
	 * Sets count
	 * 
	 * @param count
	 *            {@link #count}
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Sets step
	 * 
	 * @param step
	 *            {@link #step}
	 */
	public void setStep(int step) {
		this.step = step;
	}

	/**
	 * Sets urlprefix
	 * 
	 * @param urlprefix
	 *            {@link #urlprefix}
	 */
	public void setUrlprefix(String urlprefix) {
		this.urlprefix = urlprefix;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		for (int i = 0; (count % step == 0) ? i < count / step : i <= count / step; i++) {
			try {
				out.write(String.format("&nbsp<a href='%s%d'>%d</a>", urlprefix, i * step, i));
			} catch (IOException e) {
				logger.error("IOException in Paginator class", e);
			}
		}
		return SKIP_BODY;
	}
}
