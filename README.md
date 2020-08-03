# trace-spring-boot
MDC 实现的日志链路追踪组件

### quick to start
 import maven 

```xml
<dependency>
  <groupId>com.winterchen</groupId>
  <artifactId>trace-spring-boot-starter</artifactId>
  <version>1.0.0-RELEASE</version>
</dependency>
```

logback-spring.xml or logback.xml properties change 

add
```
%5p [${spring.application.name:-},%X{X-B3-TraceId:-},%X{X-B3-ParentName:-},%X{X-B3-SpanId:-},%X{X-Span-Export:-}]
```

```xml
<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
        <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符-->
        <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %5p [${spring.application.name:-},%X{X-B3-TraceId:-},%X{X-B3-ParentName:-},%X{X-B3-SpanId:-},%X{X-Span-Export:-}] %-5level %logger{50} - %msg%n</pattern>
    </encoder>
</appender>
```

