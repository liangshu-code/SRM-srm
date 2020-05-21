package com.ilp3.system.dao;
import com.ilp3.system.entity.SupplierDo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import java.util.List;
import java.util.Map;

@Mapper
public interface SupplierMapper {
    @Select("<script>" +
            "select * from supplier_info"+
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
    @Delete("delete from supplier_info where supplier_id =#{supplierId}")
    int remove(Long id);
}
