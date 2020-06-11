# 手动删除eureka上节点

http://localhost:8761/eureka/apps/AUDIT1/192.168.56.1:22001 

```
curl -X DELETE \
  http://10.231.50.28:9099/eureka/apps/AUDIT/0.231.50.28:22001 \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 0' \
  -H 'Host: 10.231.50.28:9099' \
  -H 'Postman-Token: c8861f85-7e1a-44d8-9204-601555d2aedb,20f4e12f-465d-4c92-8eb6-663443fae8f0' \
  -H 'User-Agent: PostmanRuntime/7.18.0' \
  -H 'cache-control: no-cache'
```