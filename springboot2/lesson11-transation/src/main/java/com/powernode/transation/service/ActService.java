package com.powernode.transation.service;


/**
 * User: hallen
 * Date: 2023/8/18
 * Time: 17:16
 */

public interface ActService {
    boolean transfer(Integer fromNo, Integer toNo, double money);
    boolean transfer2(Integer fromNo, Integer toNo, double money);

    boolean otherThread(Integer fromNo, Integer toNo, double money);
}
