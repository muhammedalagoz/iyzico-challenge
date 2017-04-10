package com.iyzico.challenge.repository.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyzico.challenge.entity.Speaker;
import com.iyzico.challenge.repository.SpeakerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpeakerRepositoryTest {

	@Autowired
	SpeakerRepository speakerRepository;

	@Test
	public void speakerCountTest() {
		assertEquals(3, this.speakerRepository.findAll().size());
	}

	@Test
	public void speakerSubjectTest() {
		Optional<List<Speaker>> speakerList = this.speakerRepository.findByFirstName("Lemi");

		speakerList.ifPresent((speakers) -> {
			assertEquals(1, speakers.size());
			assertThat(speakers.get(0).getSubject(), CoreMatchers.containsString("Git"));
		});
	}
}
