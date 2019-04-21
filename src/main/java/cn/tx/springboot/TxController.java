package cn.tx.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TxController {

    @ResponseBody
    @RequestMapping("/helloTx")
    public String hello(){
        return "hello";
    }
}
