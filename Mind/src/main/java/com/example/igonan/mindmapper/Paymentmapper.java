package com.example.igonan.mindmapper;

import com.example.igonan.dto.PaymentDTO;
import com.example.igonan.util.countDTO;
import com.example.igonan.util.myPageTotalDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;
@Mapper
@Transactional
public interface Paymentmapper {

@Select("select * from ubuy;")
 List<PaymentDTO> userBuyList();

@Select("select * from ubuy u where u.u_id = #{buyerid} and u_date >= subdate(now(), 180);")
List<PaymentDTO> oneUsersAllIgonanBuyListReturn(String buyerid);

 @Select("select * from ubuy u where u.u_id = #{buyerid} and u.u_num = #{num} ;")
 PaymentDTO oneUsersOneRowWithNum(String buyerid,int num);
@Select("select * from ubuy u where u.u_id = #{buyerid} and u.u_prname= #{productname} order by u.u_num desc limit 1; ")
PaymentDTO finduserbuyresult(String buyerid, String productname);

@Select("select * from ubuy u where u.u_id = #{buyerid} order by u.u_num desc limit #{startnum}, #{endnum} ;")
//"select * from ubuy u where u.u_name = #{buyername} order by u.u_date asc limit #{startnum}, #{endnum} ;"
List<PaymentDTO> mypageuserbuylist(String buyerid, int startnum, int endnum);

@Select("select u.u_name,count(*) as u_count,sum(u_totalpay) as u_totalpay from ubuy u where u.u_id = #{buyerid};")
List<myPageTotalDTO> mypageuserbuytotal(String buyerid);

 @Select("select u.u_name,count(*) as u_count,sum(u_totalpay) as u_totalpay from ubuy u where u.u_id = #{buyerid} and u.u_date like #{thisdate};")
 List<myPageTotalDTO> mypageuserbuytotalmonth(String buyerid,String thisdate);

 @Select("select * from ubuy u where u.u_id = #{buyerid} and u.u_del = #{deliveryStatus};")
 List<PaymentDTO> oneUsersDeliveryStatusDataReturn(String buyerid, String deliveryStatus);


@Select("select u.u_id,count(*) as u_count from ubuy u where u.u_id = #{buyerid} and u.u_del like #{deliveryStatus};")
PaymentDTO oneUsersDeliveryStatuscountReturn(String buyerid, String deliveryStatus);

@Select("select * from ubuy u where u.u_id = #{buyerId} and u.u_date >= #{startDate} and u.u_date <= #{endDate} and u.u_del like #{status};")
List<PaymentDTO> oneUsersBuyListWireDateRange(String buyerId, String startDate, String endDate,String status);

 Integer mindpaymentinsert(String id,String name, String phone, String addr, String saddr, String prName, int totalPay, String memo, int count, String cashsel, LocalDate buydate);
// insert명령문의 id인 mindpaymentinsert 호출과 컬럼에 맞게 파라미터 전달

 Integer paymentDeleveryStatusUpdate(String Status,int num);



}


 /*
@Select("select u.u_id,count(*) from ubuy u where u.u_id = #{buyerid} and u.u_del like #{deliveryStatus};")
countDTO oneUsersDeliveryStatuscountReturn(String buyerid, String deliveryStatus);
*/
//SELECT SUBDATE('2008-01-02', INTERVAL 30 DAY);
//select subdate(u_date,30) from ubuy;
//select * from ubuy where u_date >= subdate(now(), 30);