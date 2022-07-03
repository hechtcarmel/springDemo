package com.example.demo.video;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {
	
	private static final String FORMAT = "classpath:videos/%s.mp4";

	@Autowired
	private ResourceLoader resourceLoader;
	
	//TODO: Understand what is Mono.
	public Mono<Resource> getVideo(){
		String title = "example_video_2";
		return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, title)));
		
		
	}
	
	private String uploadFolderPath = "C:\\Users\\carmelhe\\t\\";
	private byte[] uploadedBytes;
	public void uploadToLocal(MultipartFile file) {
		try {
			byte[] data = file.getBytes();
			uploadedBytes = data;
			
			Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
			Files.write(path, data);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public byte[] getUploadedBytes() {
		return uploadedBytes;
	}
	
}
