# Spring Cloud Module Usage Demo

## Security
- 配置中心里加入**Spring Security**后，需要登录login接口（built-in）获取key为**JSESSIONID**的cookie,之后才能访问配置中心；
## Refresh
- actuator的refresh endpoint 虽然默认是enabled的，但是默认是不**exposed**的，所以需要配置其暴露出来；
- 动态配置更新，因此使用相关配置的bean需要是**refreshScope**的