# DDL

## 建表保持幂等ddl
```
DROP TABLE IF EXISTS testdb.audit_tb;
```

### limit知识
```
mysql> select * from test where val=4 limit 300000,5;
+---------+-----+--------+
| id      | val | source |
+---------+-----+--------+
| 3327622 |   4 |      4 |
| 3327632 |   4 |      4 |
| 3327642 |   4 |      4 |
| 3327652 |   4 |      4 |
| 3327662 |   4 |      4 |
+---------+-----+--------+
5 rows in set (15.98 sec)
为了达到相同的目的，我们一般会改写成如下语句：

mysql> select * from test a inner join (select id from test where val=4 limit 300000,5) b on a.id=b.id;
+---------+-----+--------+---------+
| id      | val | source | id      |
+---------+-----+--------+---------+
| 3327622 |   4 |      4 | 3327622 |
| 3327632 |   4 |      4 | 3327632 |
| 3327642 |   4 |      4 | 3327642 |
| 3327652 |   4 |      4 | 3327652 |
| 3327662 |   4 |      4 | 3327662 |
+---------+-----+--------+---------+
5 rows in set (0.38 sec)


覆盖索引（covering index）指一个查询语句的执行只用从索引中就能够取得，不必从数据表中读取。也可以称之为实现了索引覆盖。
```

###  

- [mysql 证明为什么用limit时，offset很大会影响性能 #117](https://github.com/zhangyachen/zhangyachen.github.io/issues/117)
- [MySQL覆盖索引](https://www.jianshu.com/p/77eaad62f974)
- [Mysql 分页语句 Limit原理](https://blog.csdn.net/helloxiaozhe/article/details/78106709)

