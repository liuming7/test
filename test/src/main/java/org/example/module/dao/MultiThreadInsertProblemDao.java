package org.example.module.dao;

import org.example.module.po.MultiThreadInsertProblemPo;
import org.springframework.stereotype.Repository;

@Repository
public interface MultiThreadInsertProblemDao {

    public void insert(MultiThreadInsertProblemPo multiThreadInsertProblemPo);
}
