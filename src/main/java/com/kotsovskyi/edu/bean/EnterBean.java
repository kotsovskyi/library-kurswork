package com.kotsovskyi.edu.bean;

import com.kotsovskyi.edu.entity.Job;
import com.kotsovskyi.edu.entity.Lesson;
import com.kotsovskyi.edu.entity.Students;
import com.kotsovskyi.edu.service.JobService;
import com.kotsovskyi.edu.service.LessonService;
import com.kotsovskyi.edu.service.StudentsService;
import org.springframework.context.annotation.Scope;

import javax.faces.component.UIComponent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.List;

@Named
@Scope("session")
public class EnterBean {

    private Students studentsPers = null;


    private List<Lesson> studentLessonsList = null;

    private List<Job> studentJobsList = null;
    private UIComponent mybutton;

    private File file;


//    private static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//    private static StudentsService studentsService = context.getBean(StudentsService.class);
    @Inject
    private StudentsService studentsService;

    @Inject
    private LessonService lessonService;

    @Inject
    private JobService jobService;




    public Students getStudentsPers() {
        return studentsPers;
    }

    public void setStudentsPers(Students studentsPers) {
        this.studentsPers = studentsPers;
    }

    public void studentNull(){
        studentsPers = null;
    }



    public void refreshListOfLessons() {
        if (studentsPers != null) {
            studentLessonsList = lessonService.getStudentLessons(studentsPers.getStudents_id());
        }
    }

    public String showAllLessonsPage() {
        return "showAllLessonsPage";
    }

    public List<Lesson> getStudentLessonsList() {
        return studentLessonsList;
    }

    public void setStudentLessonsList(List<Lesson> studentLessonsList) {
        this.studentLessonsList = studentLessonsList;
    }

    public String showAllJobsToDoPage() {
        return "showAllJobsToDoPage";
    }

    public void refreshListOfJobs() {
        studentJobsList = jobService.getStudentJobsById(studentsPers.getStudents_id());
    }

    public List<Job> getStudentJobsList() {
        return studentJobsList;
    }

    public void setStudentJobsList(List<Job> studentJobsList) {
        this.studentJobsList = studentJobsList;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }



    public UIComponent getMybutton() {
        return mybutton;
    }

    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }
}
