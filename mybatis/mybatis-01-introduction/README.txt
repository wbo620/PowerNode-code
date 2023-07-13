开发我的第一个MyBatis程序

1.resources目录：
        放在这个目录当中的，一般都是资源文件，配置文件。
        直接放到resources目录下的资源，等同于放到了类的根路径下。
2.开发步骤
    第一步：打包方式jar
    第二步：引入依赖
        - mybatis依赖
        - mysql驱动依赖
    第三步：编写mybatis核心配置文件：mybatis-config.Xml
    注意：
        第一：这个文件名不是必须叫做nybatis-config.xmL,可以用其他的名字。只是大家都采用这个名字。
        第二：这个文件存放的位置也不是固定的，可以随意，但一般情况下，会放到类的根路径下。
    *第四步：编写XxxxMapper.xmL文件
        在这个配置文件当中编写S0L语句。
        这个文件名也不是固定的，放的位置也不是固定，我们这里给它起个名字，叫做：CarMapper.xml
        把它暂时放到类的根路径下。
    *第五步：在mybatis-config.XmL文件中指定XxxxMapper.Xml文件的路径：
         <mapper resource="CarMapper.xml"/>
         注意：resource.属性会自动从类的根路径下开始查找资源。
    *第六步：编写MyBatis程序。（使用mybatis的类库，编写mybatis程序，连接数据库，做增删改查就行了。）
        在MyBatis当中，负责执行SQL语句的那个对象叫做什么呢？T
        SqlSession
            SqlSession是专门用来执行SQL语句的，是一个Java程序和数据库之间的一次会话。
            要想获取SqlSession对象，需要先获取SqlSessionFactory对象，通过SqlSessionFactory.工厂来生产SqlSession对象。
            怎么获取SqlSessionFactory对象呢？
            需要首先获取SqlSessionFactoryBuilder对象。
            通过SqlSessionFactoryBuilder对象的bvild>方法，来获取一个SqlSessionFactory对象。
        mybatis的核心对象包括：
            SqlSessionFactoryBuilder
            SqlSessionFactory
            SqlSession
        SqlSessionFactoryBuilder --SqlSessionFactory --SqlSession
3.从XML中构建SqlSessionFactory
    通过官方的这句话，你能想到什么呢？
        第一：在MyBatis中一定是有一个很重要的对象，这个对象是：SqlSessionFactory对象。
        第二：SqlSessionFactory对象的创建需要XML。
    XML是什么？
           它一定是一个配置文件。
4.mybatis中有两个主要的配置文件：
    其中一个是：mybatis-config.xmL,这是核心配置文件，主要配置连接数据库的信息等。（一个）
    另一个是：XxxxMapper.XmL,这个文件是专门用来编写SQL语句的配置文件。（一个表一个）】
        t_-User表，一般会对应，个UserMapper.Xml
        t_student表，一般会对应-个StudentMapper.Xml