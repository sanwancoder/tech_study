# ZooKeeper
- 官网
   - [https://zookeeper.apache.org/](https://zookeeper.apache.org/) 
- GitHub源码
   - [https://github.com/apache/zookeeper](https://github.com/apache/zookeeper)
- **视频讲解资料**
   - [尚硅谷大数据之Zookeeper](https://www.bilibili.com/video/av32093417)
   - [Zookeeper：分布式系统入门到实战](https://www.youtube.com/watch?v=BhosKsE8up8)
- zk核心算法部分
   - ZAB算法
   - Paxos算法
- 其他补充
   - [ ZooKeeper集群搭建过程](https://juejin.im/post/5ba879ce6fb9a05d16588802) 
   - Znode 
      - [ZooKeeper系列(3)：znode说明和znode状态](https://www.cnblogs.com/f-ck-need-u/p/9233249.html)
      - [ZooKeeper的Znode剖析](https://blog.csdn.net/lihao21/article/details/51810395)
   - zk监听器原理
      - [监听器原理](https://www.bilibili.com/video/av32093417/?p=14)
      - [品味ZooKeeper之Watcher机制
](https://www.jianshu.com/p/4c071e963f18)
      - [ZooKeeper的监听原理
](https://blog.csdn.net/qq_34913075/article/details/79017255)
   - zookeeper leader选举机制
      - LeaderElection
      - AuthFastLeaderElection
      - ***FastLeaderElection(默认选举机制)*** 举例:目前有 5 台服务器，每台服务器均没有数据，它们的编号分别是 1，2，3，4，5 按编号依次启动，它们的选择举过程如下：
          - 服务器 1 启动，给自己投票，然后发投票信息，由于其它机器还没有启动所以它收不到
反馈信息，服务器 1 的状态一直属于 Looking。
          - 服务器 2 启动，给自己投票，同时与之前启动的服务器 1 交换结果，由于服务器 2 的编
号大所以服务器 2 胜出，但此时投票数没有大于半数，所以两个服务器的状态依然是
LOOKING。
          - 服务器 3 启动，给自己投票，同时与之前启动的服务器 1,2 交换信息，由于服务器 3 的
编号最大所以服务器 3 胜出，此时投票数正好大于半数，所以服务器 3 成为领导者，服
务器 1,2 成为小弟。
          - 服务器 4 启动，给自己投票，同时与之前启动的服务器 1,2,3 交换信息，尽管服务器 4
的编号大，但之前服务器 3 已经胜出，所以服务器 4 只能成为小弟。
         - 服务器 5 启动，后面的逻辑同服务器 4 成为小弟。
         
# zk客户端工具
- ##ZooInspector##


# zk开源客户端
- **zkclient** ZkClient是由Datameer的工程师开发的开源客户端，对Zookeeper的原生API进行了包装，实现了超时重连、Watcher反复注册等功能。

```
<dependency>
     <groupId>org.apache.zookeeper</groupId>
     <artifactId>zookeeper</artifactId>
     <version>${zookeeper.version}</version>
 </dependency>
 <dependency>
     <groupId>com.github.sgroschupf</groupId>
     <artifactId>zkclient</artifactId>
     <version>${zkclient.version}</version>
 </dependency>
```

- [Curator](https://curator.apache.org/)

```
<!-- https://mvnrepository.com/artifact/org.apache.curator/curator-framework -->
<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-framework</artifactId>
    <version>4.0.1</version>
</dependency>

```

- zookeeper与Eureka比较

![avatar](https://github.com/sanwancoder/it_study_lib/blob/master/images/zk%E4%B8%8Eeureka%E6%AF%94%E8%BE%83.png?raw=true)


- 书籍推荐
