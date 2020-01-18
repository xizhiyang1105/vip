package com.fh.service;

import com.fh.action.YH.ServletRequest;
import com.fh.model.Vip;

public interface VipService {
    boolean queryVipName(String name);

    boolean sendCode(String shouji);

    ServletRequest iscode(String code,String shouji);

    ServletRequest addVip(Vip vip);

    ServletRequest login(Vip vip);
}
