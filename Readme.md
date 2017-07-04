# README

#### 1: 注册中心、服务注册
#### 2: 服务发现、负载均衡
#### 3: 断路器（熔断）--服务隔离、降级
#### 4: 分布式配置中心
#### 5: 分布式配置中心（HA）
#### 6: 服务网关
#### 7: 注册中心（HA）
#### 8: TimeOut
#### 9: 监控(HystrixDashboard，Turbine)
#### 10: 分布式追踪数据模型（Zipkin，Spring-Cloud-Sleuth）



Hystrix's default request timeout: **1000ms** 

In order to change Hystrix's default request timeout set the following property :
`hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=2000`
          
          
