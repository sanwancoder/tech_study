# Spring

- 官网
   - [https://spring.io/](https://spring.io/) 


## 知识点细节

1. IOC（Inversion of Control）和 DI（Dependecy Injection）
	- 对象的创建不是再像原来通过new来创建,而是交给Spring配置来创建,因此称为控制反转（IOC）。
	- 创建对象的工作由Spring来完成,然后注入调用者,因此也称为依赖注入(DI)。
2. AOP
3. 注入方法
	- Setter注入
	- Contructor注入
  
4. 常用注解
- 网址 
     - [https://juejin.im/post/5aed577c6fb9a07aca7a0c4e](https://juejin.im/post/5aed577c6fb9a07aca7a0c4e)
     - [https://my.oschina.net/Alamien/blog/608663](https://my.oschina.net/Alamien/blog/608663)  
- @Autowired
   - 默认 byType 装配
- @Resource
  - 默认 byName 装配
- @Service：
   - 标注一个业务逻辑组件类




# SpringMVC
- 网址
   -  [SpringMVC官方文档](https://docs.spring.io/spring/docs/4.3.22.RELEASE/spring-framework-reference/htmlsingle/#spring-web)
- 特点
   - 单例模式
   - SpringMVC用 ***ModelMap对象*** 对象从后台向前台传递数据的  

## 知识点学习
#### 日志输出
1. [springboot 打印 RequestMapping 信息配置](https://blog.csdn.net/tengdazhang770960436/article/details/88979738)





# Spring、SpringMVC、SpringBoot与SpringCloud关系
- Spring 是一个“引擎”;
- SpringMVC 是基于Spring的一个 MVC 框架;
- SpringBoot 是基于Spring4+的条件注册的一套快速开发整合包；
- SpringCloud 是基于SpringBoot的一套SOA解决方案；