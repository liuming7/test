package org.example.module.service;

import org.example.module.dao.MultiThreadInsertProblemDao;
import org.example.module.po.MultiThreadInsertProblemPo;
import org.example.module.process.MultiThreadInsertProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class MultiThreadInsertProblemService {

    @Autowired
    private MultiThreadInsertProblemDao multiThreadInsertProblemDao;

    private ThreadPoolExecutor threadPoolExecutor = null;

    public String insert() throws ExecutionException, InterruptedException {
        if(threadPoolExecutor == null){
            threadPoolExecutor = new ThreadPoolExecutor(4,8,5000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(128),new ThreadPoolExecutor.DiscardPolicy());
        }
        Future<String> a = null;
        for(int i=0;i<100;i++){
            MultiThreadInsertProblemPo multiThreadInsertProblemPo = new MultiThreadInsertProblemPo();
            multiThreadInsertProblemPo.setId("aaaa");
            multiThreadInsertProblemPo.setName("bb");

            MultiThreadInsertProcess multiThreadInsertProcess = new MultiThreadInsertProcess();
            multiThreadInsertProcess.setMultiThreadInsertProblemPo(multiThreadInsertProblemPo);
            a = threadPoolExecutor.submit(multiThreadInsertProcess);
        }
        a.get().toString();
        return "finished";
    }
}
