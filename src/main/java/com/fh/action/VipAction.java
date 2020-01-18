package com.fh.action;

import com.fh.action.YH.ServletRequest;
import com.fh.action.ZJ.login;
import com.fh.model.Vip;
import com.fh.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("vip")
@CrossOrigin
public class VipAction {
    @Autowired
    private VipService vipService;

    @RequestMapping("queryVipName")
    @login
    public Map queryByName(String name){
        Map map=new HashMap();
        map.put("valid",vipService.queryVipName(name));
        return map;
    }
    @RequestMapping("iscode")
    @login
    public ServletRequest iscode(String code,String shouji){
    return vipService.iscode(code,shouji);
    }
    @RequestMapping("addVip")
    @login
    public ServletRequest addVip(Vip vip){
        return vipService.addVip(vip);
    }


    @RequestMapping("sendCode")
    @login
    public ServletRequest sendCode(String shouji){
        try {
            boolean b = vipService.sendCode(shouji);
            return  ServletRequest.success(b);
        }catch (Exception e){
            return ServletRequest.error(e.getMessage());
        }
    }

    @RequestMapping("login")
    @login
    public ServletRequest login(Vip vip){
        return vipService.login(vip);
    }

}
