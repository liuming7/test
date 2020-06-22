package org.example.module.controller;

import org.example.module.service.MultiThreadInsertProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping(value = "/MultiThreadInsertProblem")
public class MultiThreadInsertProblemController {

    @Autowired
    private MultiThreadInsertProblemService multiThreadInsertProblemService;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insert() throws ExecutionException, InterruptedException {

        return multiThreadInsertProblemService.insert();
    }
}
