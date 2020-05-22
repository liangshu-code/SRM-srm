package com.ilp3.system.dao;
import com.ilp3.system.entity.SupplierDo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SupplierMapper {
    @Select("<script>" +
            "select * from supplier_info " +
            "<where>" +
//            "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" +
            "<if test=\"name != null and name != ''\">"+ "and name_cn = #{name} " + "</if>" +
            "</where>"+
            "<if test=\"offset != null and limit != null\">"+
            "limit #{offset}, #{limit}" +
            "</if>"+
            "</script>")
    List<SupplierDo> list(Map<String,Object> param);
    @Select("select * from supplier_info where supplier_id=id")
    List<SupplierDo> Alllist(int id);
    @Select("select count(*) from supplier_info")
    int count(Map<String, Object> map);
    @Insert("INSERT INTO supplier_info(name_cn,name_en,abbreviation,code,nature,property,mailing_address,post_code,company_website,business_registration,registered_capital,date_establishment,organization_code,staff_size,contact_id,staus)VALUES(#{nameCn},#{nameEn},#{abbreviation},#{code},#{nature},#{property},#{mailingAddress},#{postCode},#{companyWebsite},#{businessRegistration},#{registeredCapital},#{dateEstablishment},#{organizationCode},#{staffSize},#{contactId},#{staus})")
    int add(SupplierDo supplierDo);
    @Update("update  supplier_info set staus = 0  where supplier_id =#{id}")
    int remove(Long id);
    @Select("select * from supplier_info where supplier_id=#{id}")
    SupplierDo get(Long id);
    @Update("update supplier_info set name_cn = #{nameCn},name_en = #{nameEn},abbreviation = #{abbreviation},code = #{code},nature = #{nature},property = #{property},mailing_address = #{mailingAddress},post_code = #{postCode},company_website = #{companyWebsite},business_registration = #{businessRegistration},registered_capital = #{registeredCapital},date_establishment = #{dateEstablishment},organization_code = #{organizationCode},staff_size = #{staffSize},contact_id = #{contactId},staus = #{staus}  where supplier_id=#{supplierId}")
    int update(SupplierDo supplierDo);
}
