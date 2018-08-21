package by.htp.epam.cinema.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Timer extends Thread {

	private static Logger logger = LoggerFactory.getLogger(Timer.class);
	private boolean stop = false;

	private static final long RESERVATION_PERIOD = 1 * 30000L;// 30 sec
	private long secondsDisplay;
	private long minutesDisplay;

	public long getSecondsDisplay() {
		return secondsDisplay;
	}

	public long getMinutesDisplay() {
		return minutesDisplay;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		long endTime = startTime + RESERVATION_PERIOD;
		long elapsedTime;
		long remainingSeconds;
		while (!stop && System.currentTimeMillis() < endTime) {
			elapsedTime = System.currentTimeMillis() - startTime;
			remainingSeconds = (RESERVATION_PERIOD - elapsedTime) / 1000;
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