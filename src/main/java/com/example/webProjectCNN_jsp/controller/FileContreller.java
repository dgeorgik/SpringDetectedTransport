package com.example.webProjectCNN_jsp.controller;

import com.example.webProjectCNN_jsp.model.Image;
import com.example.webProjectCNN_jsp.servise.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class FileContreller extends HttpServlet {
    private static List<Image> images = new ArrayList<Image>();

    private static final Logger logger = LoggerFactory.getLogger(FileContreller.class);


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/detected")
    public String detected() {
        return "detected";
    }

    @RequestMapping("/errorPage")
    public String errorRedirect() {
        return "errorList";
    }

    @ResponseBody
    @RequestMapping(value = {"/uploadFile"}, method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model, HttpServletResponse response) throws IOException {// имена параметров (тут - "file") - из формы JSP.

        String name = null;

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                name = file.getOriginalFilename();

                String rootPath = "/Users/georgijpustovalov/Downloads/webProjectCNN_jspCollab-master-2/src/main/webapp/downloadImages/loadFiles/download_images";  //try also "C:\path\"
                File dir = new File(rootPath + File.separator + "loadFiles");

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

                logger.info("uploaded: " + uploadedFile.getAbsolutePath());

                boolean streamFlag = true;
                boolean ocrFlag = false;
                images.add(new Image(name));
                System.out.println(name);




                if (streamFlag == true) {



                    String line;
                    OutputStream stdin = null;
                    InputStream stderr = null;
                    InputStream stdout = null;

                    Process process = Runtime.getRuntime().exec("/Users/georgijpustovalov/Downloads/yolodetected_generatescript-main/dist/MainClassStarterExe");
                    stdin = process.getOutputStream();
                    stderr = process.getErrorStream();
                    stdout = process.getInputStream();

                    line = uploadedFile.getAbsolutePath() + "\n";
                    stdin.write(line.getBytes());
                    stdin.flush();

                    line = "bus";
                    stdin.write(line.getBytes());
                    stdin.flush();

                    stdin.close();
                    BufferedReader brCleanUp =
                            new BufferedReader(new InputStreamReader(stdout));
                    while ((line = brCleanUp.readLine()) != null) {
                        System.out.println("[Stdout] " + line);
                    }
                    brCleanUp.close();

                    brCleanUp =
                            new BufferedReader(new InputStreamReader(stderr));
                    while ((line = brCleanUp.readLine()) != null) {
                        System.out.println("[Stderr] " + line);
                    }
                    brCleanUp.close();
                }


                if (ocrFlag == true) {
                    String line;
                    OutputStream stdin = null;
                    InputStream stderr = null;
                    InputStream stdout = null;

                    Process process = Runtime.getRuntime().exec("/Users/georgijpustovalov/Downloads/ocr_modulepython/dist/StarterOcr");
                    stdin = process.getOutputStream();
                    stderr = process.getErrorStream();
                    stdout = process.getInputStream();

                    line = uploadedFile.getAbsolutePath() + "\n";
                    stdin.write(line.getBytes());
                    stdin.flush();


                    stdin.close();

                    BufferedReader brCleanUp =
                            new BufferedReader(new InputStreamReader(stdout));
                    while ((line = brCleanUp.readLine()) != null) {
                        System.out.println("[Stdout] " + line);
                    }
                    brCleanUp.close();

                    brCleanUp =
                            new BufferedReader(new InputStreamReader(stderr));
                    while ((line = brCleanUp.readLine()) != null) {
                        System.out.println("[Stderr] " + line);
                    }
                    brCleanUp.close();
//                    detectedInformation(name);

                }

                model.addAttribute("file", name);
                System.out.println("--------------- "+  model.addAttribute("file", name));

//                RequestDispatcher reqDispObj = getServletContext().getRequestDispatcher("home.jsp");

                response.sendRedirect("./detected");


                return "You successfully uploaded file= " + name + "\n" + "You will be redirected in 3 second";
            } catch (Exception e) {
                response.sendRedirect("./errorPage");
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            response.sendRedirect("./errorPage");
            return "You failed to upload " + name + " because the file was empty.";
        }
    }


    public void detectedInformation(String name) {
        boolean dir_1 = false;
        boolean dir_2 = false;
        boolean dir_3 = false;
        File directory_cv2 = new File("/Users/georgijpustovalov/Downloads/webProjectCNN_jspCollab-master-2/src/main/webapp/downloadImages/loadFiles/cv2_detected_object");


        if (directory_cv2.isDirectory()) {

            // creating a String Array
            // store name of files
            String arr[] = directory_cv2.list();

            // check if length is greater than 0 or not
            if (arr.length > 0) {
                System.out.println("The directory "
                        + directory_cv2.getPath()
                        + " is not Empty!");
                deleteFileOnCv2DetectedObject();
                dir_1 = true;
            } else {
                System.out.println("The directory "
                        + directory_cv2.getPath()
                        + " is Empty!");
                dir_1 = false;
            }
        }

        File directory_load = new File("/Users/georgijpustovalov/Downloads/webProjectCNN_jspCollab-master-2/src/main/webapp/downloadImages/loadFiles/download_images/loadFiles");

        if (directory_load.isDirectory()) {

            // creating a String Array
            // store name of files
            String arr[] = directory_load.list();

            // check if length is greater than 0 or not
            if (arr.length > 0) {
                System.out.println("The directory "
                        + directory_load.getPath()
                        + " is not Empty!");
                deleteFileOnLoadFiles();
                dir_2 = true;
            } else {
                System.out.println("The directory "
                        + directory_load.getPath()
                        + " is Empty!");
                dir_2 = false;
            }
        }

        File directory_yoloDetected = new File("/Users/georgijpustovalov/Downloads/webProjectCNN_jspCollab-master-2/src/main/webapp/downloadImages/loadFiles/yolo_detectedImages");

        if (directory_yoloDetected.isDirectory()) {

            // creating a String Array
            // store name of files
            String arr[] = directory_yoloDetected.list();

            // check if length is greater than 0 or not
            if (arr.length > 0) {
                System.out.println("The directory "
                        + directory_yoloDetected.getPath()
                        + " is not Empty!");
                deleteFileOnYoloDetectedImages();
                dir_3 = true;
            } else {
                System.out.println("The directory "
                        + directory_yoloDetected.getPath()
                        + " is Empty!");
                dir_3 = false;
            }
        }

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd ' time: ' hh:mm:ss a zzz");

//                System.out.println("Текущая дата " + formatForDateNow.format(dateNow));




        Path path = Paths.get("project_logs");
        String text = "\nimage: " + name + " " + formatForDateNow.format(dateNow) + "\n" +
                " cv2_detected_object [ " + dir_1 + " ] \n" +
                " loadFiles [ " + dir_2 + " ] \n" +
                " yolo_detectedImages [ " + dir_3 + " ]";


        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Successfully written bytes to the file " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        public void deleteFileOnCv2DetectedObject(){

        try {
            System.out.println("The directory (/cv2_detected_object) was clean!");
            Files.walk(Paths.get("/Users/georgijpustovalov/Downloads/webProjectCNN_jspCollab-master-2/src/main/webapp/downloadImages/loadFiles/cv2_detected_object"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void deleteFileOnLoadFiles() {

        try {
            System.out.println("The directory (/loadFiles) was clean!");
            Files.walk(Paths.get("/Users/georgijpustovalov/Downloads/webProjectCNN_jspCollab-master-2/src/main/webapp/downloadImages/loadFiles/download_images/loadFiles"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public void deleteFileOnYoloDetectedImages() {

            try {
                System.out.println("The directory (/yolo_detectedImages) was clean!");
                Files.walk(Paths.get("/Users/georgijpustovalov/Downloads/webProjectCNN_jspCollab-master-2/src/main/webapp/downloadImages/loadFiles/yolo_detectedImages"))
                        .filter(Files::isRegularFile)
                        .map(Path::toFile)
                        .forEach(File::delete);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}