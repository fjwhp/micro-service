package com.whp.upload.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.whp.eureka.consumer.feignclient.EurekaClientInterface;

@RunWith(SpringRunner.class)
//带有Spring Boot支持的引导程序
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UploadTester {

    @Autowired
    private EurekaClientInterface upload;
    @Test
   // @SneakyThrows
    public void testHandleFileUpload() {
        //TODO 需要解决junit测试问题
        upload.consumer();
       /* File file = new File("e:/test.txt");
        DiskFileItem fileItem = (DiskFileItem)new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE,
            true, file.getName());

        try (InputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multi = new CommonsMultipartFile(fileItem);

        System.out.println(upload.handleFileUpload(multi));*/
    }
}
