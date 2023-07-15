package com.powernode.bank.service;

import com.powernode.bank.exceptions.MonenNotEnougException;
import com.powernode.bank.exceptions.TransferException;

public interface AccountService {
    void transfer(String fromActno,String toActno,double money) throws MonenNotEnougException, TransferException;
}
