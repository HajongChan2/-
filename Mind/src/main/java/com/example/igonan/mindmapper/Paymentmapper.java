package com.example.igonan.mindmapper;

import com.example.igonan.dto.PaymentDTO;
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

@Select("select * from ubuy u where u.u_name = #{buyername} ;")
PaymentDTO findOne(String buyername);

@Select("select * from ubuy u where u.u_id = #{buyerid} and u.u_prname= #{productname} order by u.u_num desc limit 1; ")
PaymentDTO finduserbuyresult(String buyerid, String productname);

@Select("select * from ubuy u where u.u_id = #{buyerid} order by u.u_num desc limit #{startnum}, #{endnum} ;")
//"select * from ubuy u where u.u_name = #{buyername} order by u.u_date asc limit #{startnum}, #{endnum} ;"
List<PaymentDTO> mypageuserbuylist(String buyerid, int startnum, int endnum);

//@Select("select u.u_name,count(*),sum(u_totalpay) from ubuy u where u.u_id = #{buyerid};")




 Integer mindpaymentinsert(String id,String name, String phone, String addr, String saddr, String prName, int totalPay, String memo, int count, String cashsel, LocalDate buydate);
// insert명령문의 id인 mindpaymentinsert 호출과 컬럼에 맞게 파라미터 전달
}
