package com.powernode.transation;

import com.powernode.transation.mapper.ActMapper;
import com.powernode.transation.service.ActService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson11TransationApplicationTests {
	@Resource
	private ActMapper actMapper;

	@Resource
	private ActService actService;
	@Test
	void tran() {
		actService.transfer(1001,1002,10000);
	}

	//无效的事物1:方法的引用
	@Test
	void tran2() {
		actService.transfer2(1001,1002,10000);
	}

	//无效事物2,开启新的线程,在子的线程中执行业务代码,事物失效
	@Test
	void newThread() {
		actService.otherThread(1001,1002,10000);
	}
}
