# SpringBoot
- 网址
  - [SpringBoot官方文档](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/)
- SpringBoot版本介绍


## 知识点

1. SpringBoot Starter工作原理
![avatar](https://github.com/sanwancoder/it_study_lib/blob/master/images/Spring%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86.png?raw=true)

2. Spring Boot 解决的问题？
   - 使编码变得简单
	- 使配置变得简单
	- 使部署变得简单
	- 使监控变得简单
3. 源码学习

- @SpringBootApplication --->>> @EnableAutoConfiguration -->>>
  - 1 @AutoConfigurationPackage
  - 2 @Import(EnableAutoConfigurationImportSelector.class)  --->>> AutoConfigurationImportSelector --->>> org.springframework.boot.autoconfigure.AutoConfigurationImportSelector#selectImports --->>> org.springframework.boot.autoconfigure.AutoConfigurationImportSelector#getCandidateConfigurations

springboot加载配置
[https://blog.csdn.net/puhaiyang/article/details/78335703](https://blog.csdn.net/puhaiyang/article/details/78335703)
[SpringBoot SpringApplication底层源码分析与自动装配](https://www.cnblogs.com/jimisun/p/10077033.html)
[SpringBoot2 | @SpringBootApplication注解 自动化配置流程源码分析（三）](https://juejin.im/post/5ce3c173f265da1b8a4ef1ee)


# Spring、SpringMVC、SpringBoot与SpringCloud关系
- Spring 是一个“引擎”;
- SpringMVC 是基于Spring的一个 MVC 框架;
- SpringBoot 是基于Spring4+的条件注册的一套快速开发整合包；
- SpringCloud 是基于SpringBoot的一套SOA解决方案；


# 其他补充

- [SpringBoot非官方教程 | 终章：文章汇总](https://blog.csdn.net/forezp/article/details/70341818)


# 书籍推荐
- 《Java EE开发的颠覆者 SpringBoot实战》 汪云飞著
