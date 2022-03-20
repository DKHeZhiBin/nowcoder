package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes=CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	@Test
	void contextLoads() {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public  void  testApplicationContext(){
//		System.out.println(applicationContext);
//		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
//		AlphaDao alphaDao = applicationContext.getBean("jojo",AlphaDao.class);
		AlphaService alphaDao = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaDao);
	}

	@Test
	public  void  testConfig(){
		SimpleDateFormat format = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(format.format(new Date()));
	}


	//重要 依赖注入
	@Autowired
	private AlphaService alphaService;
	@Autowired
	@Qualifier("jojo")
	private AlphaDao alphaDao;
	@Autowired
	private  SimpleDateFormat simpleDateFormat;

	@Test
	public  void  testDI(){
		System.out.println(alphaService);
		System.out.println(alphaDao.select());
		System.out.println(simpleDateFormat);
	}
}
