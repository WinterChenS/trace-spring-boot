package com.winterchen.trace.starter.constants;

/**
 * @author purgeyao
 * @since 1.0
 */
public class Constants {

    /**
     * 布尔类型。表示是否要将该信息输出到类似Zipkin这样的聚合器进行收集和展示
     */
    public static final String LEGACY_EXPORTABLE_NAME = "X-Span-Export";

    /**
     * parent id
     */
    public static final String LEGACY_PARENT_ID_NAME = "X-B3-ParentSpanId";

    /**
     * parent service name
     */
    public static final String LEGACY_PARENT_SERVICE_NAME = "X-B3-ParentName";

    /**
     * 为一个请求分配的ID号，用来标识一条请求链路。
     */
    public static final String LEGACY_TRACE_ID_NAME = "X-B3-TraceId";

    /**
     * 表示一个基本的工作单元，一个请求可以包含多个步骤，每个步骤都拥有自己的spanId。
     * 一个请求包含一个TraceId，多个SpanId
     */
    public static final String LEGACY_SPAN_ID_NAME = "X-B3-SpanId";


}
