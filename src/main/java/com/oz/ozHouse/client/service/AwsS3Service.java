package com.oz.ozHouse.client.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AwsS3Service {
	
	@Value("${cloud.aws.s3.bucketName}")
	private String bucketName;
	
	private final AmazonS3 amazonS3;
	
	// 여러장의 이미지를 사용하기 때문에 List를 사용
    public List<String> uploadImage(List<MultipartFile> multipartFile) {
    	System.out.println("AWS에 upload실행");
    	// 업로드 된 파일 이름 목록을 저장할 List 생성 	
        List<String> fileNameList = new ArrayList<>();
        
        // 전달 된 multipartFile 목록에 대해 각 파일을 처리
        // forEach를 이용해서 파일 정보를 읽어오고 AmazonS3 라이브러리를 활용해
        // putObject를 통해서 손쉽게 업로드 해준다.
        multipartFile.forEach(file -> {
            String fileName = createFileName(file.getOriginalFilename());
            System.out.println("파일 이름 : " + fileName);
            // S3에 업로드할 파일의 메타데이터를 생성
            ObjectMetadata objectMetadata = new ObjectMetadata();
            // 파일 크기를 메타데이터에 설정
            objectMetadata.setContentLength(file.getSize());
            // 파일 타입을 메타데이터에 설정
            objectMetadata.setContentType(file.getContentType());
            System.out.println("파일 업로드 전");
            try(InputStream inputStream = file.getInputStream()) {
            	// Amazon S3에 객체를 업로드
            	// PutObjectRequest를 이용하여 객체 업로드를 요청을 생성하고, 이를 amazonS3.putObject()를 통해 실행.
                amazonS3.putObject(new PutObjectRequest(bucketName, fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
            } catch(IOException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "이미지 업로드에 실패했습니다.");
            }

            fileNameList.add(fileName);
        });

        return fileNameList;
    }
    
    public String GetObjectUrl(String bucketName, String keyName) {

        // URL 생성
        URL url = amazonS3.getUrl(bucketName, keyName);
        
        System.out.println("url은 : " + url.toString());
        return url.toString();
    }
    
    // UUID를 이용해서 파일 이름을 지정
    private String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }
    
    // 클라이언트 쪽에서 가지고 있는 파일명들을 그대로 받아와서 해당 파일명과 일치하는 사진을 deleteObject를 통해서 삭제
    public void deleteImage(String fileName) {
        amazonS3.deleteObject(new DeleteObjectRequest(bucketName, fileName));
    }
    
    // 파일의 확장자를 추출하는 메서드
    private String getFileExtension(String fileName) {
        try {
        	// 파일 이름에서 마지막 마침표(".") 이후의 부분을 잘라서 확장자를 반환한다.
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일(" + fileName + ") 입니다.");
        }
    }
}
