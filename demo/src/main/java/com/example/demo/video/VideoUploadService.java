package com.example.demo.video;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class VideoUploadService {
	
//	private String uploadFolderPath = "C:\\Users\\carmelhe\\t\\";
//	private byte[] uploadedBytes;
//	public void uploadToLocal(MultipartFile file) {
//		try {
//			byte[] data = file.getBytes();
//			uploadedBytes = data;
//			
////			Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
////			Files.write(path, data);
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public byte[] getUploadedBytes() {
//		return uploadedBytes;
//	}
}
