#### 注册中心、服务注册
#### 服务发现、负载均衡
#### 断路器（熔断）--服务隔离、降级
#### 分布式配置中心
#### 分布式配置中心（HA）
#### 服务网关
#### 注册中心（HA）
#### TimeOut
#### 监控(HystrixDashboard，Turbine)
#### 分布式追踪数据模型（Zipkin，Spring-Cloud-Sleuth）


Hystrix's default request timeout: **1000ms** 

In order to change Hystrix's default request timeout set the following property :
`hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=2000`
          
          
