package com.fh.service.Impl;

import com.fh.action.YH.ServletRequest;
import com.fh.dao.VipDao;
import com.fh.model.Vip;
import com.fh.service.VipService;
import com.fh.util.Common_Enum;
import com.fh.util.JWT;
import com.fh.util.RedisPools;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class VipServiceImpl implements VipService {
    @Resource
    private  VipDao vipDao;

    @Override
    public boolean queryVipName(String name) {
        Vip vip = vipDao.queryByName(name);
        if (vip == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sendCode(String shouji) {
        boolean rs=true;
       /* String code = RandomNumer.getFourRandom(4);//得到一个4位的随机数据*/
        String code ="1234";
        //发送短信
       /* boolean b = AliYunMsg.sendMsg(shouji, code);
        if(b){*/
            //将验证码存入redis
            // 设置String的值  同时设置失效时间60秒
            Jedis jedis = RedisPools.getJedis();
            jedis.set("msg_"+shouji,code);
            jedis.expire("msg_"+shouji,60);
            RedisPools.returnjedis(jedis);
            rs=true;
       /* }*/
        return rs;
    }

    @Override
    public ServletRequest iscode(String code,String shouji) {
        boolean a=false;
        Jedis jedis = RedisPools.getJedis();
        String s = jedis.get("msg_" + shouji);
        if(s!=null){
            if(code.equals(s)){
                a=true;
            }else {
                a=false;
            }
        }else {
            a=false;
        }
        return ServletRequest.success(a);
    }

    @Override
    public ServletRequest addVip(Vip vip) {
        vip.setCreaDate(new Date());
        vip.setZt(1);
        vipDao.insert(vip);
        return ServletRequest.success();
    }

    @Override
    public ServletRequest login(Vip vip) {
        Vip vip1 = vipDao.queryByName(vip.getName());
        if(vip1!=null){
            if(vip1.getZt()==1){
                if(vip1.getPassword().equals(vip.getPassword())){
                    vip1.setFalg(4);//登陆成功
                    String token = JWT.sign(vip1, 60 * 60);
                    Jedis jedis = RedisPools.getJedis();
                    jedis.set(vip1.getName(),token);
                    jedis.expire(vip1.getName(),1800);
                    String t=vip1.getName()+","+token;
                    byte[] encode = Base64.getEncoder().encode(t.getBytes());
                    String a=new String(encode);
                    vip1.setJwt(a);
                    RedisPools.returnjedis(jedis);
                    return ServletRequest.success(vip1);
                }else {
                    vip.setFalg(3);//密码错误
                    return ServletRequest.success(vip);
                }
            }else {
                vip.setFalg(2);//账号被锁定
                return ServletRequest.success(vip);
            }
        }else{
            vip.setFalg(1);//用户不存在
            return ServletRequest.success(vip);
        }
    }
}
