package t1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Project name(项目名称)：MyBatis注解
 * Package(包名): PACKAGE_NAME
 * Interface(接口名): t1.SiteMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/3/15
 * Time(创建时间)： 20:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface SiteMapper
{
    @Insert("insert into website values (#{id},#{name},#{url},#{age},#{country},#{createTime})")
    public int insert(Site site);

    @Select("Select * from website")
    public List<Site> select();

    @Select("Select * from website")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "url", property = "url"),
            @Result(column = "country", property = "country"),
            @Result(column = "createTime", property = "createTime")
    })
    public List<Site> select1();
}
