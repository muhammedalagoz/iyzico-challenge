package com.iyzico.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iyzico.challenge.entity.Speaker;
import com.iyzico.challenge.service.SpeakerService;

@RestController
@RequestMapping("/api")
public class SpeakerController {

	@Autowired
	SpeakerService speakService;

	@RequestMapping("/speakers")
	@ResponseBody
	public List<Speaker> getSpeakers() {
		return speakService.findAll();
	}
}
