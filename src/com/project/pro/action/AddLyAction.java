package com.project.pro.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.LogUtil;
import com.project.pro.dao.ILyTableDAO;
import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.LyTable;
import com.project.pro.vo.Test;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Map;

/**
 * ZHANGZHAOHONG 2018128338
 * */
public class AddLyAction extends ActionSupport {
    private LyTable ly;
    private String titleErr;
    private String lyContentErr;
    ApplicationContext ac;

    public String getTitleErr() {
        return titleErr;
    }
    public void setTitleErr(String titleErr) {
        this.titleErr = titleErr;
    }
    public String getLyContentErr() {
        return lyContentErr;
    }
    public void setLyContentErr(String lyContentErr) {
        this.lyContentErr = lyContentErr;
    }
    public LyTable getLy() {
        return ly;
    }
    public void setLy(LyTable ly) {
        this.ly = ly;
    }

    @Override
    public void validate() {
        String title = ly.getTitle();
        String content = ly.getLyContent();
        if (title==null || "".equals(title)){
            //保存错误信息
            super.addFieldError("title","数据不能为空！");
        }

        if (content==null || "".equals(content)){
            super.addFieldError("content","数据不能为空");
        }
    }

    /**
     * @return
     */
    public String execute() {
        ac = ContextLoader.getCurrentWebApplicationContext();
        if (ac == null) ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        Map session = ActionContext.getContext().getSession();

        Test user = (Test) session.get("user");
        if(user==null){
            return "loginerr";
        }

        HttpServletRequest request = ServletActionContext.getRequest();

        String id = request.getParameter("id");
        String method = request.getMethod();
        if (method.equalsIgnoreCase("get")) {

            ILyTableDAO lyDao = (ILyTableDAO)ac.getBean("lyTableDAO");		//new LyTableDAO();



            ly = lyDao.getOneLy(Integer.parseInt(id));
            return "modify";

        }else {
            ILyTableDAO lyDao = (ILyTableDAO)ac.getBean("lyTableDAO");		//new LyTableDAO();

            String type = request.getParameter("type");
            if (type!=null && type.equalsIgnoreCase("delete")) { 	//也可以('delete'.equalsIgnoreCase(type))

                String delid = request.getParameter("delid");
                if (ly==null) {
                    ly = new LyTable();
                }
                ly.setId(Integer.parseInt(delid));
                lyDao.delete(ly);

                return "delsucc";

            }

            if (ly==null) {
                return "error";
            }
            Date lydate = new Date(System.currentTimeMillis());
            ly.setTest(user);
            ly.setLydate(lydate);

            int num = lyDao.save(ly);

            if(num>0){

                request.setAttribute("action", "添加留言");
                request.setAttribute("oper_info", "添加留言成功");
                request.setAttribute("next_info", "留言列表页");
                request.setAttribute("next_url", "pageLy.action");

                return SUCCESS;

            }else {
                return ERROR;
            }
        }
//        Map session = ActionContext.getContext().getSession();
//        Test user = (Test) session.get("user");
//        if (user == null) {
//            return "loginerr";
//        }
//        if (ly == null) {
//            return "error";
//        }
//        String title = ly.getTitle();
//        String content = ly.getLyContent();
//        int userid = user.getId();
//        Date lydate = new Date(System.currentTimeMillis());
//        String sql = "insert lyTable (userid,lydate,title,lyContent) values('" + userid + "','" + lydate + "','" + title + "','" + content + "')";
//        SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
//        new LogUtil().printLn(sql);
////        Connection conn = SqlSrvDB.getConn();
////        PreparedStatement pstmt = null;
//        int num = 0;
//        num = SqlSrvDB.executeInsert(sql);
//        SqlSrvDB.closeStmt();
//        SqlSrvDB.closeConn();
////        try {
////            pstmt = conn.prepareStatement(sql);
////            pstmt.setInt(1, userid);
////            pstmt.setDate(2, lydate);
////            pstmt.setString(3, title);
////            pstmt.setString(4, content);
////            num = pstmt.executeUpdate(sql);
////            pstmt.close();
////            conn.close();
////        } catch (Exception e) {
////            System.out.println("[SystemLog]" + e.toString());
////        }
//        if (num > 0) {
//            return SUCCESS;
//        } else {
//            return ERROR;
//        }
    }

}