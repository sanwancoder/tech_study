1. 安装jdk
2. Zookeeper环境搭建
3. 安装kafka
- 3.1 修改配置 kafka_2.11-2.2.1\config\server.properties
```
#zookeeper连接地址 保证kafka创建节点位置在kafka节点下
zookeeper.connect=localhost:2181/kafka
#日志地址
log.dirs=/tmp/kafka-logs
```
- 3.2启动kafka
```
1. 启动server
.\bin\windows\kafka-server-start.bat .\config\server.properties
2. 创建topic
.\kafka-topics.bat --create --zookeeper localhost:2181/kafka --replication-factor 1 --partitions 1 --topic testDemo
3. 创建Producer
.\kafka-console-producer.bat --broker-list localhost:9092 --topic testDemo
4. 创建consumer
.\kafka-console-consumer.bat --zookeeper localhost:2181/kafka --topic testDemo
``` 

### 效果图如下
![avatar](https://github.com/sanwancoder/tech_study/blob/master/images/windows%E4%B8%8Bkafka%E6%B6%88%E6%81%AF.jpg?raw=true)


## 4.1Kafka三款监控工具之Kafka Web Console
//TODO 

## 4.2Kafka三款监控工具之Kafka Manager
- [https://github.com/yahoo/kafka-manager](https://github.com/yahoo/kafka-manager)

## 4.3Kafka三款监控工具之KafkaOffsetMonitor
- [https://github.com/quantifind/KafkaOffsetMonitor](https://github.com/quantifind/KafkaOffsetMonitor)

## 4.4 Kafka Tool
- [http://www.kafkatool.com/](http://www.kafkatool.com/)

## Kafka Eagle

- [比Kafka Mangaer更优秀的开源监控工具-Kafka Eagle](https://www.cnblogs.com/yinzhengjie/p/9957389.html)

4.3.1修改配置 \kafka-manager-1.3.3.17\conf\application.conf 
```
修改配置(这里主要是连接你的zookeeper服务的端口)
kafka-manager.zkhosts="localhost:2181/kafka"
```