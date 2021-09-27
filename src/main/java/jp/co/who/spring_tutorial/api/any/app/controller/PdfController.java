package jp.co.who.spring_tutorial.api.any.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Slf4j
@RestController
public class PdfController {

    @GetMapping(path="/api/get/text", produces = MediaType.TEXT_PLAIN_VALUE)
    public Resource download() {
        var file = new File("src/main/resources/application.properties");
        log.debug(file.toString());
        return new FileSystemResource(file);
    }

    @GetMapping(path="/api/get/png")
    public ResponseEntity<Resource> download1() {
        var png = new File("src/main/resources/screenshot1.png");
        log.debug(png.toString());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        String.format("attachment; filename=%s", png.getName()))
                .body(new FileSystemResource(png));
    }

    @GetMapping(path="/api/get/png2")
    public void download2(HttpServletResponse response) throws Exception {
        var png = new FileInputStream("src/main/resources/screenshot1.png");
        OutputStream os = response.getOutputStream();
        log.debug(png.toString());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=sample.png");
        response.setContentType("application/octet-stream");

        IOUtils.copy(png, os);
        os.flush();
    }
}
