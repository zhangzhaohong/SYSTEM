package com.project.org.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.org.model.Classes;
import com.project.org.model.Success;
import com.project.org.model.SuccessId;
import com.project.org.service.ClassesService;
import com.project.org.service.StudentService;
import com.project.org.service.SuccessService;
import com.project.org.tool.Pager;

import java.util.List;
import java.util.Map;

public class SuccessAction extends ActionSupport {
    private Success success;
    private StudentService studentService;
    private ClassesService classesService;
    private SuccessService successService;
    private int pageNow = 1;
    private int pageSize = 8;

    public String execute() throws Exception {
        List list1 = studentService.findAll(1, studentService.findstudentSize());
        List list2 = classesService.findAll(1, classesService.findKcSize());
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("list1", list1);
        request.put("list2", list2);
        return SUCCESS;
    }

    public String addorupdateschool() throws Exception {
        Success success1 = null;
        SuccessId successId1 = new SuccessId();
        successId1.setSno(success.getId().getSno());
        successId1.setCno(success.getId().getCno());
        if (successService.getschool(success.getId().getSno(), success.getId().getCno()) == null) {
            success1 = new Success();
            success1.setId(successId1);
        } else {
            success1 = successService.getschool(success.getId().getSno(), success.getId().getCno());
        }
        Classes kc1 = classesService.find(success.getId().getCno());
        success1.setSuccess(success.getSuccess());
        if (success.getSuccess() > 60 || success.getSuccess() == 60) {
            success1.setCredit(kc1.getCredit());
        } else
            success1.setCredit(0);
        successService.saveorupdateSuccess(success1);
        return SUCCESS;
    }

    public String schoolInfo() throws Exception {
        List list = successService.findAllSuccess(this.getPageNow(), this.getPageSize());
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("list", list);
        Pager page = new Pager(this.getPageNow(), successService.findSuccessSize());
        request.put("page", page);
        return SUCCESS;
    }

    public String findschool() throws Exception {
        List list = successService.getschoolList(success.getId().getSno());
        if (list.size() > 0) {
            Map request = (Map) ActionContext.getContext().get("request");
            request.put("list", list);
            return SUCCESS;
        } else
            return ERROR;
    }

    public String deleteOneschool() throws Exception {
        String sno = success.getId().getSno();
        String cno = success.getId().getCno();
        successService.deleteSuccess(sno, cno);
        return SUCCESS;
    }


    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }

    public SuccessService getSuccessService() {
        return successService;
    }

    public void setSuccessService(SuccessService successService) {
        this.successService = successService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public ClassesService getClassesService() {
        return classesService;
    }

    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
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
