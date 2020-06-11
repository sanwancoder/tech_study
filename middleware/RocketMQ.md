介绍: Apache RocketMQ是一个分布式消息传递和流媒体平台，具有低延迟、高性能和可靠性、万亿级别的容量和灵活的可伸缩性。

- [RocketMQ介绍及集群部署](https://www.jianshu.com/p/23e04d8178b8)


官网: [https://rocketmq.apache.org/](https://rocketmq.apache.org/)
源码: [https://github.com/apache/rocketmq/](https://github.com/apache/rocketmq/) 


学习

- 部署方式
   - 为什么要使用消息队列,使用消息队列的好处？
      - 解藕
      - ***削峰:*** 传统模式的缺点：并发量大的时候，所有的请求直接怼到数据库，造成数据库连接异常。中间件模式的的优点：系统 A 慢慢的按照数据库能处理的并发量，从消息队列中慢慢拉取消息。在生产中，这个短暂的高峰期积压是允许的
      - 异步
   - 使用了消息队列会有什么缺点？
      - 系统可用性降低
      - 系统复杂性提高
      - 一致性问题 