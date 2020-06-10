package com.project.pro.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.UserTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class LoginValidateAction extends ActionSupport {

    private UserTable user;

    /**
     * @return
     */
    public String execute() {
        String usr = user.getUsername();
        String pwd = user.getPassword();
        String urt = user.getUserType();
        boolean validated = false;

        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();

        UserTable sessionUser = null;
        //HttpSession session = request.getSession();

        sessionUser = (UserTable) session.get("user");
        if (sessionUser == null) {
            String sql = "select * from userTable";
            SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
            ResultSet rs = SqlSrvDB.executeQuery(sql);
            System.out.println("[SystemLog]" + sql);
            try {
                //pstmt = conn.prepareStatement(sql);
                while (rs.next()) {
                    if ((rs.getString("username").trim().compareTo(usr) == 0)
                            && (rs.getString("password").compareTo(pwd) == 0)
                            && (rs.getString("userType").compareTo(urt) == 0)) {
                        sessionUser = new UserTable();
                        sessionUser.setId(rs.getInt("id"));
                        sessionUser.setUsername(rs.getString("username"));
                        sessionUser.setPassword(rs.getString(3));
                        sessionUser.setUserType(rs.getString(4));
                        session.put("user", sessionUser);
                        validated = true;
                        break;
                    }
                }
                rs.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            SqlSrvDB.closeStmt();
            SqlSrvDB.closeConn();
        } else {
            validated = true;
        }


        if (validated) {
            return "success";
        } else {
            return "error";
        }


    }

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }
}