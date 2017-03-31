1、消费者消费服务，通过ribbon和fegin两种方式
2、ribbon和fegin两种使用断路器
   PS：fegin已经依赖了hystrix，不需要单独在pom中引入
3、为了符合maven的package规范，新建一个全局的application，maven package用，没实际意义，需要放开各自包中的Application，应该四个