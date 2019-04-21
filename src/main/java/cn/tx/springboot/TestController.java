package cn.tx.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

@Controller
public class TestController
{

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestParam("pic")MultipartFile file, HttpServletRequest request){
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
    /*System.out.println("fileName-->" + fileName);
    System.out.println("getContentType-->" + contentType);*/
        //String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        String filePath = "D:/imgup/";
        try {
            this.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return "success";
    }


    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }


    @ResponseBody
    @RequestMapping("/hello1")
    public Person getJson(){
        Person p = new Person();
        p.setAge(10);
        p.setBirth(new Date());
        p.setName("txjava");

        return p;
    }


    @ResponseBody
    @RequestMapping("/hello2")
    public String hello2(Date birth){
        System.out.println(birth);

        return "success";
    }



}
