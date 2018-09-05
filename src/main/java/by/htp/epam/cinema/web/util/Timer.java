package by.htp.epam.cinema.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.TIMER_RESERVATION_PERIOD;

/**
 * Timer for control order lifecycle
 * 
 * @author Arkadzi Patsko
 *
 */
public class Timer extends Thread {

	private static final ResourceManager RM = ResourceManager.TIMER;
	private static Logger logger = LoggerFactory.getLogger(Timer.class);

	/**
	 * stop field. Define when thread should be stopped
	 */
	private boolean stop = false;

	/**
	 * remaining second for display
	 */
	private long secondsDisplay;
	/**
	 * remaining minutesDisplay for display
	 */
	private long minutesDisplay;

	/**
	 * @return {@link #secondsDisplay}
	 */
	public long getSecondsDisplay() {
		return secondsDisplay;
	}

	/**
	 * @return {@link #minutesDisplay}
	 */
	public long getMinutesDisplay() {
		return minutesDisplay;
	}

	/**
	 * Sets stop parameter
	 * 
	 * @param stop
	 *            {@link #stop}
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		long reservationPeriod = Long.parseLong(RM.getValue(TIMER_RESERVATION_PERIOD));
		long startTime = System.currentTimeMillis();
		long endTime = startTime + reservationPeriod;
		long elapsedTime;
		long remainingSeconds;
		while (!stop && System.currentTimeMillis() < endTime) {
			elapsedTime = System.currentTimeMillis() - startTime;
			remainingSeconds = (reservationPeriod - elapsedTime) / 1000;
			secondsDisplay = remainingSeconds % 60;
			minutesDisplay = remainingSeconds / 60;

			logger.info(String.format("%02d : %02d", minutesDisplay, secondsDisplay));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.error("InterruptedException in Timer class", e);
			}
		}
	}
}