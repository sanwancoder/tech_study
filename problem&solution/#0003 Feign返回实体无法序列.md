# Feign


- 无法序列化

	- 问题：Feign返回实体无法序列

	- 解决方法： [https://www.programcreek.com/java-api-examples/?api=org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder](https://www.programcreek.com/java-api-examples/?api=org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder)

```java
@Configuration
public class GlobalFeignConfig implements RequestInterceptor {


  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

 
  @Bean
  public Decoder feignDecoder() {
    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
    ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(fastConverter);
    return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
  }

}
```