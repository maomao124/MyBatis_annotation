package t1;

import org.apache.ibatis.annotations.*;

import java.util.Date;
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


    @Insert("insert into website(id,name,url,age) values(#{id},#{name},#{url},#{age})")
    @SelectKey(statement = "select last_insert_id()",
            keyProperty = "id",
            keyColumn = "id",
            resultType = Integer.class,
            before = false)
    public int insert1(Site site);

    @Update("update website set name=#{name},age=#{age} where id=#{id}")
    public int update(Site site);

    @Delete("delete from website where id=#{id}")
    public int delete(Integer id);

    @Insert("insert into website values (#{id},#{name},#{url},#{age},#{country},#{createTime})")
    public int insert2(@Param("id") Integer id, @Param("name") String name, @Param("url") String url,
                       @Param("age") Integer age, @Param("country") String country,
                       @Param("createTime") Date createTime);
}
