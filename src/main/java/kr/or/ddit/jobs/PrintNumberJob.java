package kr.or.ddit.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PrintNumberJob {
	private int number = 1;
	
//	@Scheduled(cron = "0 0 3 * * MON")
	public void printNumberPerSecond() {
		log.info("number : {}, thread name : {}", number++, Thread.currentThread().getName());
	}
}
