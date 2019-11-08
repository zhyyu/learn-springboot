package com.zhyyu.learn.learnspringboot.controller;

import io.micrometer.core.instrument.util.StringUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author juror
 * @datatime 2019/10/29 14:40
 */
@RestController
@RequestMapping("file")
public class FileController {

    private byte[] bytes = {98, 99, 100};

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @RequestMapping("uploadFile")
    public String uploadFile(MultipartFile file1) throws IOException {
        System.out.println(file1.getContentType());
        System.out.println(file1.getName());
        System.out.println(file1.getOriginalFilename());
        System.out.println(file1.getResource());

        return "upload success";
    }

    /**
     * https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet
     */
    @RequestMapping("uploadFileWithOtherKey")
    public String uploadFileWithOtherKey(MultipartFile file1, String key1, String key2) throws IOException, ServletException {
        System.out.println(file1.getContentType());
        System.out.println(file1.getName());
        System.out.println(file1.getOriginalFilename());
        System.out.println(file1.getResource());

        /* ==================== 附加keys ==================== */
        System.out.println(key1);
        System.out.println(key2);

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        System.out.println(parameterMap);

        Collection<Part> parts = httpServletRequest.getParts();
        parts.forEach(part -> {
            System.out.println(part.getContentType());
            System.out.println(part.getName());
            System.out.println(part.getSubmittedFileName());
            System.out.println(part.getSize());
        });
        System.out.println(parts);
        /* ==================== 附加keys ==================== */

        return "upload success";
    }

    /**
     * https://www.baeldung.com/spring-rest-template-multipart-upload
     * https://github.com/spring-projects/spring-framework/issues/18147
     * https://medium.com/@voziv/posting-a-byte-array-instead-of-a-file-using-spring-s-resttemplate-56268b45140b
     */
    @RequestMapping("transferFile")
    public String transferFile(MultipartFile file1, String key1, String key2) throws IOException, ServletException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        /*  ================= 使用原生api ===================== */
        List<Part> filePartList = httpServletRequest.getParts().stream().filter(part -> StringUtils.isNotBlank(part.getSubmittedFileName())).collect(Collectors.toList());
        Map<String, Resource> resourceMap = new HashMap<>();
        for (Part part : filePartList) {
            // IOUtils FileCopyUtils 均可使用
            resourceMap.put(part.getName(), new ByteArrayResource(IOUtils.toByteArray(part.getInputStream())) {
            /*resourceMap.put(part.getName(), new ByteArrayResource(FileCopyUtils.copyToByteArray(part.getInputStream())) {*/

            /*InputStream has already been read - do not use InputStreamResource if a stream needs to be read multiple times*/
            /*resourceMap.put(part.getName(), new InputStreamResource(part.getInputStream()) {*/
                @Override
                public String getFilename() {
                    return part.getSubmittedFileName();
                }
            });
        }

        resourceMap.entrySet().forEach(entry -> {
            body.add(entry.getKey(), entry.getValue());
        });
        /*  ================= 使用原生api ===================== */

        /*body.add("file1", new ByteArrayResource(file1.getBytes()) {
            @Override
            public String getFilename() {
                return file1.getOriginalFilename();
            }
        });*/
        /*InputStream has already been read - do not use InputStreamResource if a stream needs to be read multiple times*/
        /*body.add("file1", new InputStreamResource(file1.getInputStream()) {
            @Override
            public String getFilename() {
                return file1.getOriginalFilename();
            }
        });*/
        body.add("key1", key1);
        body.add("key2", key2);

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

//        String serverUrl = "http://localhost:8000/file/uploadFile";
        String serverUrl = "http://localhost:8000/file/uploadFileWithOtherKey";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);

        System.out.println(response.getBody());
        return response.toString();
    }

    @RequestMapping("downloadFile")
    public ResponseEntity<Resource> downloadFile(String key1, String key2) throws IOException {
        /* ======== test post form ========*/
        System.out.println(key1);
        System.out.println(key2);
        /* ======== test post form ========*/

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
//    public ResponseEntity<Resource> downloadFileByTransfer(String key1, String key2) throws IOException {
    public void downloadFileByTransfer(String key1, String key2) throws IOException {
        /* ======== test post form ========*/
        System.out.println(key1);
        System.out.println(key2);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("key1", key1);
        map.add("key2", key2);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);
        /* ======== test post form ========*/

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Resource> entity = restTemplate.postForEntity("http://localhost:8000/file/downloadFile", httpEntity, Resource.class);

        entity.getHeaders().entrySet().forEach(
                headerEntry -> {httpServletResponse.setHeader(headerEntry.getKey(), headerEntry.getValue().get(0));}
        );

        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        IOUtils.copy(entity.getBody().getInputStream(), outputStream);
//        return entity;
    }

}
