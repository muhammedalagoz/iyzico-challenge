package com.iyzico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;

@SpringBootApplication
@EnablePrometheusMetrics
public class IyzicoChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IyzicoChallengeApplication.class, args);
	}
}
