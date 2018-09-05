package by.htp.epam.cinema.web.tags;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import by.htp.epam.cinema.domain.Seat;

/**
 * Class check seat existence based on given coordinates
 * 
 * @author Arkadzi Patsko
 *
 */
public class CheckSeatExistence extends TagSupport {
	/**
	 * An unique serial version identifier
	 */
	private static final long serialVersionUID = 662303206695921144L;
	/**
	 * all seats in cinema hall
	 */
	private List<Seat> seats;
	/**
	 * row field
	 */
	private int row;
	/**
	 * column field
	 */
	private int column;

	/**
	 * Sets seats
	 * 
	 * @param seats
	 *            {@link #seats}
	 */
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	/**
	 * Sets row
	 * 
	 * @param row
	 *            {@link #row}
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Sets column
	 * 
	 * @param column
	 *            {@link #column}
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @param r
	 *            {@link #row}
	 * @param n
	 *            {@link #number}
	 * @return seat if it exists, otherwise null
	 */
	Seat getSeat(int r, int n) {
		for (Seat s : seats) {
			if (s.getRow() == r && s.getNumber() == n)
				return s;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int doStartTag() throws JspException {
		Seat seat = getSeat(row, column);
		pageContext.setAttribute("seat", seat);
		return SKIP_BODY;
	}
}