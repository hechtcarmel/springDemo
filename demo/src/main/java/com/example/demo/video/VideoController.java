package com.example.demo.video;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import reactor.core.publisher.Mono;

@RestController
public class VideoController {
	private static Logger logger = LogManager.getLogger(VideoController.class);

	@Autowired
	private StreamingService service;
	
	@Autowired
	private VideoUploadService videoUploadService;
	
	@GetMapping("/video")
	public String welcomeVideo() {
		
		logger.info("Hello World video");
		
		return "Hello World video";
	}
	
	@GetMapping(value="/video_example", produces="video/mp4")
	public Mono<Resource> getVideos(@RequestHeader("Range") String range) {
		
		logger.info("getVideos range: " + range);
		
		return service.getVideo();
	}
	
	@PostMapping(value="/upload", produces="video/mp4")
	public void uploadVideo(@RequestParam("file")MultipartFile multipartFile) {
		logger.trace("Uploading file");
		service.uploadToLocal(multipartFile);
		logger.trace("Done Uploading file");

	}
	
}
