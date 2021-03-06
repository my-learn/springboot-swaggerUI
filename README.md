# springboot-swaggerUI

## 自定义

- 修改默认的 `api` 排序方式

  1. 解压 `springfox-swagger-ui` 的内容到 `resources` 下
  2. 找到 `springfox.js` `window.swaggerUi = new SwaggerUi({` 添加 `operationsSorter : "method",`
  3. 参考 [sort-api-methods-in-swagger-ui](https://stackoverflow.com/questions/24951268/sort-api-methods-in-swagger-ui)

- `methods` 排序

- https://github.com/springfox/springfox/blob/master/springfox-swagger2/src/main/java/springfox/documentation/swagger2/mappers/ServiceModelToSwagger2Mapper.java#L156

```java
   protected Map<String, Path> mapApiListings(Multimap<String, ApiListing> apiListings) {
     Map<String, Path> paths = newTreeMap();
     for (ApiListing each : apiListings.values()) {
       for (ApiDescription api : each.getApis()) {
         paths.put(api.getPath(), mapOperations(api, Optional.fromNullable(paths.get(api.getPath()))));
       }
     }
     return paths;
   }
```

## 控制API页面展示

```java
public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
```

## 页面编辑API

http://editor.swagger.io/
http://editor2.swagger.io/

## 依赖

```xml
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.6.1</version>
</dependency>

<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.6.1</version>
</dependency>
```

## api列表

```java
@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("edu.maskleo.swaggerui.controller"))
                .paths(PathSelectors.any())
                .build();
    }

private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("springboot利用swagger构建api文档")
            .description("简单优雅的restfun风格，http://blog.csdn.net/saytime")
            .termsOfServiceUrl("http://blog.csdn.net/saytime")
            .version("1.0")
            .build();
}

```

```java
@EnableSwagger2
@SpringBootApplication
public class SwaggeruiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggeruiApplication.class, args);
	}
}
```

## 相关注解

- `@Api`：修饰整个类，描述 `Controller` 的作用
- `@ApiOperation`：描述一个类的一个方法，或者说一个接口
- `@ApiParam`：单个参数描述
- `@ApiModel`：用对象来接收参数
- `@ApiProperty`：用对象接收参数时，描述对象的一个字段
- `@ApiResponse`：HTTP响应其中1个描述
- `@ApiResponses`：HTTP响应整体描述
- `@ApiIgnore`：使用该注解忽略这个API
- `@ApiError` ：发生错误返回的信息
- `@ApiImplicitParam`：一个请求参数
- `@ApiImplicitParams`：多个请求参数

## LICENSE

### [CC-BY-SA-3.0](https://creativecommons.org/licenses/by-nc-sa/3.0/cn/)

[![](LICENSE.png)](https://creativecommons.org/licenses/by-nc-sa/3.0/cn/)
