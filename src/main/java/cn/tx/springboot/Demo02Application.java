package cn.tx.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @author zhangchuan
 */
@SpringBootApplication
public class Demo02Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo02Application.class, args);
	}

	/**
	 * 将自定义的servlet注册到springboot容器中，并配置相关路径
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getTxServlet(){
		ServletRegistrationBean<TxServlet> txs = new ServletRegistrationBean<TxServlet>(new TxServlet(), "/txservlet");
		return txs;
	}

	/**
	 * 将自定义的filter过滤器注册到springboot容器中，并配置相关过滤哪些路径
	 * @return
	 */
	@Bean
	public FilterRegistrationBean  getTxFilter(){
		FilterRegistrationBean <TxFilter> txf = new FilterRegistrationBean<TxFilter>();
		txf.setFilter(new TxFilter());
		txf.setUrlPatterns(Arrays.asList("/txservlet"));
		return txf;
	}


	/**
	 * 将自定义的listener监听器注册到springboot容器中，spring容器启动的时候，执行监听器
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean myListener(){
		ServletListenerRegistrationBean<TxListener> registrationBean = new ServletListenerRegistrationBean<>(new TxListener());
		return registrationBean;
	}




}
