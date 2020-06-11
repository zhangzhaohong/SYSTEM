package com.project.org.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.org.model.Major;
import com.project.org.model.Student;
import com.project.org.service.MajorService;
import com.project.org.service.StudentService;
import com.project.org.tool.Pager;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class StudentAction extends ActionSupport {
    private int pageNow = 1;
    private int pageSize = 8;
    private Student student;
    private StudentService studentService;
    private Major major;
    private MajorService majorService;
    private File photoFile;
    private List list;

    public String execute() throws Exception {
        List list = studentService.findAll(pageNow, pageSize);
        Map request = (Map) ActionContext.getContext().get("request");
        Pager page = new Pager(getPageNow(), studentService.findstudentSize());
        request.put("list", list);
        request.put("page", page);
        return SUCCESS;
    }

    public String findstudent() throws Exception {
        String sno = student.getSno();
        Student stu = studentService.find(sno);
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("student", stu);
        return SUCCESS;
    }

    public String getImage() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        String sno = student.getSno();
        Student stu = studentService.find(sno);
        byte[] img = stu.getPhoto();
        response.setContentType("image/jpeg");
        ServletOutputStream os = response.getOutputStream();
        if (img != null && img.length != 0) {
            for (int i = 0; i < img.length; i++) {
                os.write(img[i]);
            }
            os.flush();
        }
        return NONE;
    }

    public String deletestudent() throws Exception {
        String sno = student.getSno();
        studentService.delete(sno);
        return SUCCESS;
    }

    public String updatestudentView() throws Exception {
        String sno = student.getSno();
        Student studentInfo = studentService.find(sno);
        List zys = majorService.getAll();
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("studentInfo", studentInfo);
        request.put("zys", zys);
        return SUCCESS;
    }

    public String updatestudent() throws Exception {
        Student student1 = studentService.find(student.getSno());
        student1.setSname(student.getSname());
        student1.setSex(student.getSex());
        student1.setMajor(majorService.getOneZy(student.getMajor().getId()));
        student1.setBirthday(student.getBirthday());
        student1.setTotalCredits(student.getTotalCredits());
        student1.setRemarks(student.getRemarks());
        if (this.getPhotoFile() != null) {
            FileInputStream fis = new FileInputStream(this.getPhotoFile());
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            student1.setPhoto(buffer);
        }
        Map request = (Map) ActionContext.getContext().get("request");
        studentService.update(student1);
        return SUCCESS;
    }

    public String addstudentView() throws Exception {
        return SUCCESS;
    }

    public String addstudent() throws Exception {
        Student stu = new Student();
        String sno1 = student.getSno();
        if (studentService.find(sno1) != null) {
            return ERROR;
        }
        stu.setSno(student.getSno());
        stu.setSname(student.getSname());
        stu.setSex(student.getSex());
        stu.setBirthday(student.getBirthday());
        stu.setTotalCredits(student.getTotalCredits());
        stu.setRemarks(student.getRemarks());
        stu.setMajor(majorService.getOneZy(student.getMajor().getId()));
        if (this.getPhotoFile() != null) {
            FileInputStream fis = new FileInputStream(this.getPhotoFile());
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            stu.setPhoto(buffer);
        }
        studentService.save(stu);
        return SUCCESS;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public File getPhotoFile() {
        return photoFile;
    }

    public MajorService getMajorService() {
        return majorService;
    }

    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    public void setPhotoFile(File photoFile) {
        this.photoFile = photoFile;
    }

    public List getList() {
        return majorService.getAll();
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
