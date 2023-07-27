package cn.powernode.spring6.dao.impl;

import cn.powernode.spring6.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImplForMysql")
public class StudentDaoImplForMysql implements StudentDao {
    @Override
    public void delete() {
        System.out.println("Mysql正在删除学生信息");
    }
}
