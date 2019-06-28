# springboot-mybatis-01
springboot不是注解的方式整合mybatis，用的是mapper.xml文件中写sql语句的方式
1、导包
 <dependencies>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.0.1</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!--mysbatis依赖-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
       <!--mysql驱动放进来-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--druid数据库连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.29</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        
        2、配置application.yml
        spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost/blog?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC
    username: root
    password: 123456
    type: com.alibaba.druid.pool.DruidDataSource

mybatis:
  mapper-locations: classpath:mapping/*Mapper.xml
  type-aliases-package: com.example.springbootmybatisdemo.bean

#showSql
logging:
  level:
    com:
      example:
        springbootmybatisdemo:
          bean: debug
          
3、写mapper文件
<mapper namespace="com.example.springbootmybatisdemo.mapper.UserMapper">

    <resultMap id="BaseResultMap" type="com.example.springbootmybatisdemo.bean.User">
        <result column="id" jdbcType="BIGINT" property="id" />
        <result column="name" jdbcType="VARCHAR" property="name" />
        <result column="email" jdbcType="VARCHAR" property="email" />
        <result column="userame" jdbcType="VARCHAR" property="userame" />
        <result column="password" jdbcType="VARCHAR" property="password" />
        <result column="avatar" jdbcType="VARCHAR" property="avatar" />
    </resultMap>

    <select id="getUserById" resultType="com.example.springbootmybatisdemo.bean.User">
        select * from user where id = #{id}
    </select>
<mapper/>

4、写mapper接口
@Repository
public interface UserMapper {
    User getUserById(Long id);
}

5、启动类上记得扫描mapper接口所在
@MapperScan("com.example.springbootmybatisdemo.mapper") //扫描的mapper
@SpringBootApplication
public class SpringbootMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisDemoApplication.class, args);
    }

}
