package cn.powernode.spring6.dao.impl;

import cn.powernode.spring6.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImplForOrcle")
public class StudentDaoImplForOrcle implements StudentDao {
    @Override
    public void delete() {
        System.out.println("Orcle正在删除学生信息系");
    }
}
