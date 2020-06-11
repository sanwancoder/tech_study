# Java基础

## 1. 基础知识
### 1.1 BigDecimal
#### 1.1.1 BigDecimal 的使用注意事项
注意：我们在使用BigDecimal时，为了防止精度丢失，推荐使用它的 **BigDecimal(String)** 构造方法来创建对象。《阿里巴巴Java开发手册》对这部分内容也有提到如下图所示。

### 1.2 基本数据类型与包装数据类型的使用标准
Reference:《阿里巴巴Java开发手册》

- 【强制】所有的 POJO 类属性必须使用包装数据类型。
- 【强制】RPC 方法的返回值和参数必须使用包装数据类型。
- 【推荐】所有的局部变量使用基本数据类型。

***知识细节*** 


- Java四大特性
   - 封装
   - 继承
   - 多态
   - 抽象 
- 注解
- 反射
- 代理
  - 动态代理
  - 静态代理
- 构造器初始化顺序

- abstract: abstract（抽象）修饰符，可以修饰类和方法
   - abstract修饰类，会使这个类成为一个抽象类，这个类将不能生成对象实例
   - abstract修饰方法，会使这个方法变成抽象方法，也就是只有声明（定义）而没有实现，实现部分以"；"代替。需要子类继承实现（覆盖）
   - 抽象类可以有构造函数，当被继承的时候，子类会用super()调用父类的构造函数
   - 继承自抽象类的子类必须覆盖实现父类中的抽象函数 
   - 类内含有抽象函数的类叫做抽象类，类需要用abstract修饰


- transient 关键字
   - java 的transient关键字为我们提供了便利，你只需要实现Serilizable接口，将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。
   - 1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。

     2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。

     3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。



- 接口
   - 接口是可以相互继承的
   - java.util.concurrent.Executor 是一个接口，java.util.concurrent.ExecutorService 接口继承java.util.concurrent.Executor 接口

- 抽象类
- 接口与抽象类比较
![avatar](https://github.com/sanwancoder/it_study_lib/blob/master/images/%E6%8E%A5%E5%8F%A3%E4%B8%8E%E6%8A%BD%E8%B1%A1%E7%B1%BB%E6%AF%94%E8%BE%83.jpg?raw=true)

## 2. 集合
### 2.1. List
#### 2.1.1 ArrayList
底层数据结构是 ***数组***
#### 2.1.2 LinkedList
底层数据结构是 ***链表*** 

### 2.2. Set 
#### 2.2.1 HashSet
底层实现: HashMap
   	- [GitHub HashSet参考资料](https://github.com/crossoverJie/JCSprout/blob/master/MD/collection/HashSet.md)
#### 2.2.2 TreeSet
   	      - 底层数据结构是 ***红黑树***
#### 2.2.3 LinkedHashSet 
   	      - [搞懂 HashSet & LinkedHashSet 源码以及集合常见面试题目](https://juejin.im/post/5ad6313df265da2386706662) 
   	      - 底层数据结构是 ***双向链表*** 

### 2.3 Map
#### 2.3.1 HashMap
   	      - 底层数据结构是 ***数组+链表***
   	      - 不是线程安全的
   	      - JDK 1.8中对HashMap的实现做了优化,当链表中的节点数据超过八个之后,该链表会转为红黑树来提高查询效率,从原来的 O(n)到 O(logn)
#### 2.3.2 HashTable

#### 2.3.3 Properties

#### 2.3.4  LinkedHashMap

- 锁
   - 可重入:若一个程序或子程序可以“在任意时刻被中断然后操作系统调度执行另外一段代码，这段代码又调用了该子程序不会出错”，则称其为可重入（reentrant或re-entrant）的。  
       - ReenTrantLock独有的能力：

           1. ReenTrantLock可以指定是公平锁还是非公平锁。而synchronized只能是非公平锁。所谓的公平锁就是先等待的线程先获得锁。
           2. ReenTrantLock提供了一个Condition（条件）类，用来实现分组唤醒需要唤醒的线程们，而不是像synchronized要么随机唤醒一个线程要么唤醒全部线程。
           3. ReenTrantLock提供了一种能够中断等待锁的线程的机制，通过lock.lockInterruptibly()来实现这个机制。


   - 参考资料
       - [ReenTrantLock可重入锁（和synchronized的区别）总结](https://blog.csdn.net/tianyaxingke1605/article/details/79264905) 
       - [Java多线程：synchronized的可重入性](https://www.cnblogs.com/cielosun/p/6684775.html)






- ==与equals比较
   - TODO 
- 
```java
public class Test {
	public static void main(String[] args) {
		String a = new String("ab"); // a 为一个引用
		String b = new String("ab"); // b 为另一个引用,对象的内容一样
		String aa = "ab"; // 放在常量池中
		String bb = "ab"; // 从常量池中查找
		if (aa == bb) // true
			System.out.println("aa==bb");
		if (a == b) // false，非同一对象
			System.out.println("a==b");
		if (a.equals(b)) // true
			System.out.println("aEQb");
		if (42 == 42.0) { // true
			System.out.println("true");
		}
	}
}
```


- 浅拷贝与深拷贝

- String StringBuffer StringBuilder比较
    - String 是final的，线程安全
    - StringBuffer 线程安全
    - StringBuilder 线程不安全

- Java 异常
![avatar](https://github.com/sanwancoder/it_study_lib/blob/master/images/Java%E5%BC%82%E5%B8%B8%E7%B1%BB%E5%B1%82%E6%AC%A1%E5%9B%BE.png?raw=true)
- 序列化
   - 对于不想进行序列化的变量，使用transient关键字修饰 


# JavaWeb
- 集群环境下如何实现Session共享
   - ***粘性Session:*** 是指将用户锁定到某一个服务器上；缺乏容错性，如果当前访问的服务器发生故障，用户被转移到第二个服务器上时，他的 session 信息都将失效。
   - ***Session复制:*** 任何一个服务器上的 session 发生改变（增删改），该节点会把这个 session 的所有内容序列化，然后广播给所有其它节点。如果 session 量大的话可能会造成网络堵塞，拖慢服务器性能。
   - ***Session共享:*** 使用分布式缓存方案如 redis 集群。可容错，session 实时响应。 



- Servlet
   - 参考地址
      - [JavaWeb学习总结(五)——Servlet开发(一)](https://www.cnblogs.com/xdp-gacl/p/3760336.html) 
      - [Servlet – 基础](http://www.importnew.com/20045.html)
      - [Java Servlet完全教程](http://www.importnew.com/14621.html)
      - [web服务器是如何运作的？](https://howtodoinjava.com/tomcat/a-birds-eye-view-on-how-web-servers-work/)



- RESTFul
   - 好处
      - 看Url就知道要什么
      - 看http method就知道干什么
      - 看http status  code就知道结果如何 
   - 网址参考
   	   - [阮一峰 RESTful API 最佳实践](http://www.ruanyifeng.com/blog/2018/10/restful-api-best-practices.html)   







# 计算机网络
- TCP与UDP
![avatar](https://github.com/sanwancoder/it_study_lib/blob/master/images/TCP%E4%B8%8EUDP%E6%AF%94%E8%BE%83.png?raw=true)


***Java基础面试***

- 参考网址
   - [JAVA面试精选【Java基础第一部分】博客园](https://www.cnblogs.com/hnlshzx/p/3491587.html)
   - [JAVA面试精选【Java基础第二部分】博客园](https://www.cnblogs.com/hnlshzx/p/3492197.html)
   - [JAVA面试精选【Java基础第三部分】博客园](https://www.cnblogs.com/hnlshzx/p/3493449.html)




# 书籍推荐



​      













# 测试

- [HelloWorld.java](<https://introcs.cs.princeton.edu/java/11hello/HelloWorld.java.html>)

执行方法:
   - Compilation:  javac HelloWorld.java
   - Execution:    java HelloWorld



```java
public class HelloWorld {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
    }

}
```

