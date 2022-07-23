package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.springrest.springrest.entities.*;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    //get all the courses
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return this.courseService.getCourses();
    }

    //get course with id
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //add a course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    //update a course
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    //delete a course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> removeCourse(@PathVariable String courseId){
        try{
            this.courseService.removeCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
