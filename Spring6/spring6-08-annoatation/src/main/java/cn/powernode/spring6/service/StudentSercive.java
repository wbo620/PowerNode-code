package cn.powernode.spring6.service;

import cn.powernode.spring6.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("studentSercive")
public class StudentSercive {
    @Resource(name = "studentDaoImplForOrcle")
    private StudentDao studentDao;

    public void del(){
        studentDao.delete();
    }
}
