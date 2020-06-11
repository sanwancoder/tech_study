- 1、MD5 会有冲突吗？有，为什么我们密码还是会使用MD5进行加密？
    - MD5会有冲突，两个不同的值经过MD5算法后 md5值是相同的
    - 因为设置的密码一般比较短6~20位，很难冲突；冲突的产生一般是在value值特别大的情况下产生

- 2、代理
    - 静态代理实现比较较简单，就是对代理对象功能增强；如果目标对象过多，则会产生很多代理类
    - jdk代理必须实现接口，代理对象必须实现InvocationHandler接口，反射代理方法，比较消耗系统性能
    - cglib不必实现接口，会重写方法，所以方法不能是final修改的，生成类字节码实现代理，比反射稍快，不存在性能问题
    
- 3、starter手写过吗？ 
    - [springboot-custom-starter](https://github.com/gf-huanchupk/SpringBootLearning/tree/master/springboot-custom-starter)