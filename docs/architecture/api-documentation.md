# API文档说明

## 1. 概述

本项目使用Swagger（通过springdoc-openapi）来自动生成和展示API文档。API文档提供了交互式的接口测试功能，方便开发和调试。

## 2. 访问方式

### 2.1 Swagger UI
- 访问地址：`http://localhost:8080/swagger-ui.html`
- 功能：提供交互式的API文档界面，可以直接在界面上测试API接口

### 2.2 OpenAPI规范文档
- 访问地址：`http://localhost:8080/v3/api-docs`
- 格式：JSON格式的OpenAPI 3.0规范文档
- 功能：可用于导入到Postman等工具或生成客户端代码

## 3. 配置说明

### 3.1 主要配置项
```yaml
springdoc:
  swagger-ui:
    path: /swagger-ui.html          # Swagger UI访问路径
    tags-sorter: alpha              # 标签排序方式（按字母顺序）
    operations-sorter: alpha        # 操作排序方式（按字母顺序）
  api-docs:
    path: /v3/api-docs              # OpenAPI文档路径
  show-actuator: true               # 是否显示Spring Boot Actuator端点
```

### 3.2 API分组配置
可以为不同的API模块创建不同的文档分组：
```java
@Bean
public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
            .group("public")
            .pathsToMatch("/api/public/**")
            .build();
}
```

## 4. 注解使用

### 4.1 基本注解
- `@Tag`: 为API分类打标签
- `@Operation`: 描述单个API操作
- `@Parameter`: 描述API参数
- `@Schema`: 描述数据模型
- `@ApiResponse`: 描述API响应

### 4.2 示例代码
```java
@RestController
@RequestMapping("/api/v1/game")
@Tag(name = "游戏管理", description = "游戏相关的API接口")
public class GameController {

    @PostMapping("/create")
    @Operation(summary = "创建游戏", description = "创建一个新的麻将游戏房间")
    public ResponseEntity<GameResponse> createGame(
            @RequestBody @Valid GameRequest request) {
        // 实现代码
    }
}
```

## 5. 安全配置

### 5.1 认证信息
如果API需要认证，可以在Swagger中配置认证方式：
```java
@Bean
public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .components(new Components()
                    .addSecuritySchemes("bearer-key",
                            new SecurityScheme()
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("bearer")
                                    .bearerFormat("JWT")));
}
```

### 5.2 隐藏敏感接口
使用`@Hidden`注解可以隐藏不需要展示的接口：
```java
@Hidden
@GetMapping("/internal/status")
public ResponseEntity<String> internalStatus() {
    // 内部接口，不在API文档中展示
}
```

## 6. 最佳实践

### 6.1 接口文档化
- 为每个API接口添加清晰的描述
- 为参数和响应添加详细的说明
- 使用合适的标签对接口进行分类

### 6.2 版本管理
- 在路径中包含API版本号（如`/api/v1/`）
- 为不同版本的API创建不同的文档分组

### 6.3 测试验证
- 定期使用Swagger UI测试API接口
- 确保文档与实际实现保持一致

## 7. 高级功能

### 7.1 服务器配置
可以在OpenAPI配置中定义服务器地址：
```java
.servers(List.of(
    new Server().url("https://api.example.com").description("生产环境"),
    new Server().url("https://staging-api.example.com").description("预发布环境")
))
```

### 7.2 请求示例
使用`@ExampleObject`注解为API提供请求示例：
```java
@Operation(summary = "创建游戏")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "创建成功",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = GameResponse.class),
            examples = @ExampleObject(name = "success", value = """
            {
                "id": "game-123",
                "status": "waiting",
                "players": []
            }
            """)))
})
```

## 8. 常见问题

### 8.1 接口未显示
- 检查控制器类是否使用了正确的Spring注解（@RestController、@RequestMapping等）
- 确认接口方法是否使用了HTTP方法注解（@GetMapping、@PostMapping等）

### 8.2 参数未正确显示
- 确保使用了合适的验证注解（@Valid、@NotNull等）
- 检查DTO类的字段是否使用了正确的注解

### 8.3 响应模型未显示
- 确保响应类有合适的getter方法
- 检查是否正确使用了@Schema注解描述模型