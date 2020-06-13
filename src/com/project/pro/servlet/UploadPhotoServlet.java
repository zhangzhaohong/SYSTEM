package com.project.pro.servlet;

import com.project.LogUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/**
 * Servlet implementation class UploadPhotoServlet
 */
@WebServlet("/UploadPhotoServlet")
public class UploadPhotoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        response.getWriter().append("Served at: ").append(request.getContextPath());
        String filename = null;

        DiskFileItemFactory factory = new DiskFileItemFactory();    //磁盘文件条目工厂
        ServletFileUpload upload = new ServletFileUpload(factory); //负责处理上传的文件数据，并将表单中每个输入项封装成一个fileitem对象中
        //设置上传文件的大小为10M
        factory.setSizeThreshold(2 * 1024 * 1024);
        List items = null;

        try {
            //parse  解析
            items = upload.parseRequest(request);   //得到一个保存了所有上传内容的List对象
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Iterator iter = items.iterator();   //迭代上传的文件数据
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (!item.isFormField()) {  //如果不是上传的
                //根据时间戳创建头像文件
                filename = System.currentTimeMillis() + ".jpg";
                //通过getrealpath获取上传文件夹，如果项目存在将存在当前项目下  不存在的话创建项目文件夹
                //图片文件夹
                String photoFolder = request.getServletContext().getRealPath("uploaded");
                new LogUtil().printLn(photoFolder);
                File f = new File(photoFolder, filename);
                f.getParentFile().mkdirs();  //如果父文件夹不存在则自动创建
                //通过item.getInputStream() 获取浏览器上传的文件
                InputStream is = item.getInputStream();   //将文件读进来
                //复制文件
                FileOutputStream fos = new FileOutputStream(f);  //往界面上显示
                byte[] b = new byte[2 * 1024 * 1024];
                int len = 0;
                while ((len = is.read(b)) != -1) {
                    fos.write(b, 0, len);
                }
                fos.close();

            } else {
                System.out.println(item.getFieldName());//heroName
                String value = item.getString();
                value = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                System.out.println(value);   //桑葚
            }
        }
        String html = "<img width='200' height='150' src='uploaded/%s'/>";
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.format(html, filename);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

