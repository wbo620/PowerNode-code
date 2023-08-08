package com.powernode.service;

/**
 * User: hallen
 * Date: 2023/8/8
 * Time: 21:55
 */


import com.powernode.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */

public interface UserService {
    /**
     * url	/user/selectUserPage?userName=z&userSex=男&page=null
     */
    List<User> selectUserPage(String userName, String userSex, int startRow);

    /**
     * /user/createUser(参数见下面)
     */
    int createUser(User user);

    /**
     * user/ deleteUserById?userId= 15968162087363060
     */
    int deleteUserById(String userId);

    /**
     * /user/getRowCount?userName=z&userSex=男
     */
    int getRowCount(String userName, String userSex);
}

