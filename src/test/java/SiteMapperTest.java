import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import t1.Site;
import t1.SiteMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Project name(项目名称)：MyBatis注解
 * Package(包名): PACKAGE_NAME
 * Class(测试类名): SiteMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/3/15
 * Time(创建时间)： 20:42
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SiteMapperTest
{

    @Test
    void insert() throws IOException
    {
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        SiteMapper siteMapper = sqlSession.getMapper(SiteMapper.class);

        Site site=new Site();
        site.setName("百度");
        site.setUrl("www.baidu.com");
        site.setAge(15);
        site.setId(15);
        site.setCountry("cn");

        int i = siteMapper.insert(site);
        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();
    }
}