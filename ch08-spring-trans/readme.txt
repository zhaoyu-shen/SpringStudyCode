ch08-spring-trans:做事务的环境项目

实现步骤：
1.新建maven项目
2.加入maven依赖
    1）spring依赖
    2）mybatis依赖
    3）mysql驱动
    4）spring事务的依赖
    5）mybatis和spring集成的依赖：mybatis官方提供的，用来在spring项目中创建mybatis
       的SqlSessionFactory，dao对象的
3.创建实体类
    Sale,Goods
4.创建dao接口和mapper文件
    SaleDao接口，GoodsDao接口
    SaleDao.xml，GoodsDao.xml
5.创建mybatis主配置文件
6.创建Service接口和实现类，属性是saleDao,goodsDao
7.创建spring的配置文件：声明mybatis的对象交给spring创建
    1）数据源DataSource
    2）SqlSeeionFaactory
    3）Dao对象
    4）声明自定义Service

8.创建测试类，获取Service对象，通过Service调用dao完成数据库的访问