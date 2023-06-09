//package com.example.webProjectCNN_jsp.controller;
//
//import com.example.webProjectCNN_jsp.model.Person;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class MainController {
//    //
//    private static List<Person> persons = new ArrayList<Person>();
//
//    static {
//        persons.add(new Person("Bill", "Gates"));
//        persons.add(new Person("Steve", "Jobs"));
//    }
//
//    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
//    public String index(Model model) {
//
//        String message = "Hello Spring Boot + JSP";
//
//        model.addAttribute("message", message);
//
//        return "index";
//
//    }
//
//    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
//    public String viewPersonList(Model model) {
//
//        model.addAttribute("persons", persons);
//
//        return "personList";
//    }
//
//    //    @RequestMapping(value = {"/moscowTram"}, method = RequestMethod.GET)
////    public String viewmoscowTram(Model model) {
////        return "moscowTram";
////    }
////    @RequestMapping(value = {"/moscowMetro"}, method = RequestMethod.GET)
////    public String viewMoscowMetro(Model model) {
////        return "moscowMetro";
////    }
////
//    @RequestMapping(value = {"/detected"}, method = RequestMethod.GET)
//    public String detectedPage(Model model) {
//        return "detectedPage";
//    }
//}
////    @RequestMapping(value = {"/moscowTrolleybus"}, method = RequestMethod.GET)
////    public String viewMoscowTrolleybus(Model model) {
////        return "moscowTrolleybus";
////    }
////    @RequestMapping(value = {"/moscowAirplane"}, method = RequestMethod.GET)
////    public String viewMoscowAirplane(Model model) {
////        return "moscowAirplane";
////    }
////    @RequestMapping(value = {"/moscowTrain"}, method = RequestMethod.GET)
////    public String viewMoscowTrain(Model model) {
////        return "moscowTrain";
////    }
////
////    @RequestMapping(value = {"/moscowMinibus"}, method = RequestMethod.GET)
////    public String viewMoscowMinibus(Model model) {
////        return "moscowMinibus";
////    }
//
//
