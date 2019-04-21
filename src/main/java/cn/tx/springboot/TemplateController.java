package cn.tx.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TemplateController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/test")
    public String test(Model model,HttpSession session){
        model.addAttribute("test","测试一下");

        Person person=new Person();
        person.setUsername("呵呵");
        person.setBirth(new Date());
        person.setGender(true);
        person.setPassword("eeewww12");
        model.addAttribute("p",person);

        List<Person> list=new ArrayList<Person>();
        for (int i=0;i<10;i++){
            Person person1=new Person();
            person1.setUsername("呵呵"+i);
            person1.setBirth(new Date());
            person1.setGender(true);
            person1.setPassword("eeewww12"+i);
            model.addAttribute("p",person1);
            list.add(person1);
        }

        //通过session对象传值
        session.setAttribute("user",person);

        model.addAttribute("list",list);

        return "test";
    }

    @RequestMapping("/test1")
    public String test1(Model model, HttpSession session){
        model.addAttribute("test","测试一下");

        Person person=new Person();
        person.setUsername("呵呵");
        person.setBirth(new Date());
        person.setGender(true);
        person.setPassword("eeewww12");
        model.addAttribute("p",person);

        List<Person> list=new ArrayList<Person>();
        for (int i=0;i<10;i++){
            Person person1=new Person();
            person1.setUsername("呵呵"+i);
            person1.setBirth(new Date());
            person1.setGender(true);
            person1.setPassword("eeewww12"+i);
            model.addAttribute("p",person1);
            list.add(person1);
        }

        //通过session对象传值
        session.setAttribute("user",person);

        return "test1";
    }
}
