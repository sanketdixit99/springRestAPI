package com.springrest.springrest.services;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CourseServiceImpl implements CourseService{

    //private List<Course> list= new ArrayList<>();
    @Autowired
    private CourseDao courseDao;

    //CourseServiceImpl(){
        //this.list.add(new Course(145, "Java programming", "Learn Java"));
        //this.list.add(new Course(155, "Python programming", "learn python"));
    //}

    @Override
    public List<Course> getCourses() {
        //return list;
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId){
        //return courseDao.findById(courseId).get();
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course){
        courseDao.save(course);
        return course;
    }

    @Override
    public void removeCourse(long courseId){
        courseDao.deleteById(courseId);
    }
}
