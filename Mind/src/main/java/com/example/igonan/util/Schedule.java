package com.example.igonan.util;

import com.example.igonan.mindmapper.Paymentmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
    @Autowired
    Paymentmapper paymentmapper;
    @Scheduled(cron = "0 0/5 * * * ?")
    public void cronRun() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                 String nowStatus = "배송중";
                String status = "배송완료";
        paymentmapper.paymentDeleveryStatusUpdateStatus(nowStatus,status);
        
        
        //System.out.println("### 1분마다 갱신 : " + simpleDateFormat.format(new Date()));
    }
}
