# JVM知识汇总
- 视频
- 其他补充
  - [JVM知识点总览-高级Java工程师面试必备](http://www.importnew.com/23792.html) 

***知识细节***

- JVM内存模型

![avatar](https://github.com/sanwancoder/it_study_lib/blob/master/images/jvm%E5%86%85%E5%AD%98%E7%BB%93%E6%9E%84.jpg?raw=true)

   - 堆区:Java虚拟机所管理的内存中最大的一块。Java堆是被所有线程共享的一块内存区域，在虚拟机启动时创建。此内存区域的唯一目的就是存放对象实例，几乎所有的对象实例都在这里分配内存。
   - 方法区:方法区（Method Area）与Java堆一样，是各个线程共享的内存区域，它用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。
   - 虚拟机栈:线程私有的，它的生命周期与线程相同。虚拟机栈描述的是Java方法执行的内存模型：每个方法被执行的时候都会同时创建一个栈帧（Stack Frame）用于存储局部变量表、操作栈、动态链接、方法出口等信息。
   - 本地方法栈:为虚拟机使用到的Native方法服务。
   - 程序计算器
- JDK和JRE
   - JDK是Java Development Kit	,它是功能齐全的Java SDK。它拥有JRE所拥有的一切，还有编译器（javac）和工具（如javadoc和jdb）。它能够创建和编译程序。
   - JRE是Java运行时环境。它是运行已编译Java程序所需的所有内容的集合，包括 Java虚拟机（JVM），Java 类库，java命令和其他的一些基础构件。但是，它不能用于创建新程序。

   
# jdk命令行工具
|命令|作用|参考文档|常用选项|备注|
|------------|-----------|-----------------|---------------|--------------|
|jps|可以列出本机所有java进程的pid |[jps命令详解](https://blog.csdn.net/gtuu0123/article/details/6025520)|-l -v -q -m||
   

# 书籍推荐
  - 《深入理解Java虚拟机  JVM高级特性与最佳实践》 周志明 著
