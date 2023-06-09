package com.example.webProjectCNN_jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.charset.Charset;

@SpringBootApplication
@Controller
public class WebProjectCnnJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebProjectCnnJspApplication.class, args);
	}

}
