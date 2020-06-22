package org.example.module.process;

import org.example.common.ReflectUtils;
import org.example.common.SpringUtils;
import org.example.module.dao.MultiThreadInsertProblemDao;
import org.example.module.po.MultiThreadInsertProblemPo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.util.concurrent.Callable;

@Component
public class MultiThreadInsertProcess implements Callable<String> {

    private MultiThreadInsertProblemPo multiThreadInsertProblemPo;

    public void setMultiThreadInsertProblemPo(MultiThreadInsertProblemPo multiThreadInsertProblemPo) {
        this.multiThreadInsertProblemPo = multiThreadInsertProblemPo;
    }

    @Override
    public String call() throws Exception {
        MultiThreadInsertProblemDao multiThreadInsertProblemDao = SpringUtils.getBean("MultiThreadInsertProblemDao");
        multiThreadInsertProblemDao.insert(multiThreadInsertProblemPo);
        Thread.sleep(1000);
        System.out.println("+1");
        return "success";
    }
}
