package com.zhyyu.learn.learnspringboot.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author juror
 * @datatime 2019/10/29 14:40
 */
@RestController
@RequestMapping("file")
public class FileController {

    private byte[] bytes = {98, 99, 100};

    @RequestMapping("uploadFile")
    public String uploadFile(MultipartFile file1) throws IOException {
        System.out.println(file1.getContentType());
        System.out.println(file1.getName());
        System.out.println(file1.getOriginalFilename());
        System.out.println(file1.getResource());

        return "upload success";
    }

    /**
     * https://www.baeldung.com/spring-rest-template-multipart-upload
     * https://github.com/spring-projects/spring-framework/issues/18147
     * https://medium.com/@voziv/posting-a-byte-array-instead-of-a-file-using-spring-s-resttemplate-56268b45140b
     */
    @RequestMapping("transferFile")
    public String transferFile(MultipartFile file1) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file1", new ByteArrayResource(file1.getBytes()) {
            @Override
            public String getFilename() {
                return file1.getOriginalFilename();
            }
        });

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        String serverUrl = "http://localhost:8000/file/uploadFile";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);

        return response.toString();
    }

    @RequestMapping("downloadFile")
    public ResponseEntity<Resource> downloadFile() throws IOException {
        File file = new ClassPathResource("a.xls").getFile();
        System.out.println(file);

        String mimeType2 = Files.probeContentType(file.toPath());
        System.out.println(mimeType2);

        ClassPathResource classPathResource = new ClassPathResource("a.xls");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType2))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(classPathResource);
    }

    @RequestMapping("downloadFileByTransfer")
    public ResponseEntity<Resource> downloadFileByTransfer() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Resource> entity = restTemplate.getForEntity("http://localhost:8000/file/downloadFile", Resource.class);
        return entity;
    }

}
