# 编码风格指南文档

## 1. 项目概述

本文档总结了在项目开发过程中应遵循的具体编码风格和实践指南，特别强调了对已有依赖库的使用方式。这些指南旨在确保代码的一致性、可读性和可维护性。

## 2. 依赖库使用指南

### 2.1 Hutool 工具库使用规范

Hutool是一个功能丰富且全面的Java工具库，应当优先使用它来替代手动编写常见工具方法。

#### 2.1.1 字符串处理
```java
// 推荐：使用Hutool的StrUtil
import cn.hutool.core.util.StrUtil;

String result = StrUtil.format("Hello {}", name);
String cleanStr = StrUtil.trim(str);
boolean isEmpty = StrUtil.isEmpty(str);
boolean hasContent = StrUtil.hasText(str);

// 不推荐：手动实现或使用原生方法
String result = String.format("Hello %s", name);
String cleanStr = str != null ? str.trim() : null;
```

#### 2.1.2 集合处理
```java
// 推荐：使用Hutool的CollUtil
import cn.hutool.core.collection.CollUtil;

List<String> list = CollUtil.newArrayList("a", "b", "c");
boolean isEmpty = CollUtil.isEmpty(collection);
Set<T> union = CollUtil.union(set1, set2);

// 不推荐：手动实现集合操作
List<String> list = new ArrayList<>();
list.add("a");
list.add("b");
list.add("c");
```

#### 2.1.3 对象处理
```java
// 推荐：使用Hutool的ObjectUtil
import cn.hutool.core.util.ObjectUtil;

boolean isNull = ObjectUtil.isNull(obj);
boolean isNotNull = ObjectUtil.isNotNull(obj);
T defaultValue = ObjectUtil.defaultIfNull(obj, defaultValue);

// 不推荐：手动实现对象判断
if (obj == null) { ... }
```

#### 2.1.4 日期时间处理
```java
// 推荐：使用Hutool的DateUtil
import cn.hutool.core.date.DateUtil;

String dateStr = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
Date date = DateUtil.parse(dateStr, "yyyy-MM-dd");
long between = DateUtil.between(date1, date2, DateUnit.SECOND);

// 不推荐：使用原生Date或Calendar
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String dateStr = sdf.format(new Date());
```

#### 2.1.5 JSON处理
```java
// 推荐：使用Hutool的JSONUtil
import cn.hutool.json.JSONUtil;

String jsonStr = JSONUtil.toJsonStr(obj);
T obj = JSONUtil.toBean(jsonStr, clazz);

// 不推荐：手动实现JSON序列化
// 或使用其他未在依赖中定义的JSON库
```

### 2.2 Apache Commons 工具库使用规范

当Hutool无法满足特定需求时，可使用Apache Commons系列工具库。

#### 2.2.1 Commons Lang3
```java
// 字符串处理
import org.apache.commons.lang3.StringUtils;

boolean isEmpty = StringUtils.isEmpty(str);
String[] parts = StringUtils.split(str, delimiter);

// 对象处理
import org.apache.commons.lang3.ObjectUtils;

Object defaultObj = ObjectUtils.defaultIfNull(obj, defaultValue);
```

#### 2.2.2 Commons Collections4
```java
// 集合处理
import org.apache.commons.collections4.CollectionUtils;

boolean isEmpty = CollectionUtils.isEmpty(collection);
Collection intersection = CollectionUtils.intersection(coll1, coll2);
```

#### 2.2.3 Commons IO
```java
// IO操作
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.FileUtils;

String content = IOUtils.toString(inputStream, charset);
FileUtils.copyFile(srcFile, destFile);
```

### 2.3 Lombok 使用规范

Lombok用于减少样板代码，提高代码简洁性。

```java
// 推荐：使用Lombok注解
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayer {
    private String playerId;
    private String playerName;
    private Integer score;
}

// 不推荐：手动编写getter/setter等方法
public class GamePlayer {
    private String playerId;
    private String playerName;
    private Integer score;
    
    public String getPlayerId() { return playerId; }
    public void setPlayerId(String playerId) { this.playerId = playerId; }
    // ... 其他getter/setter方法
}
```

## 3. Java编码风格

### 3.1 类和方法设计
- 优先使用组合而非继承
- 遵循单一职责原则(SRP)
- 保持方法简短，通常不超过20行

### 3.2 异常处理
- 使用具体的异常类型
- 提供有意义的错误信息
- 记录适当的日志

```java
// 推荐
try {
    // 业务逻辑
} catch (SpecificException e) {
    log.error("处理游戏数据失败: {}", e.getMessage(), e);
    throw new BusinessException("游戏数据处理失败", e);
}
```

### 3.3 注释规范
- 类和公共方法必须有Javadoc注释
- 复杂逻辑需要内联注释解释意图
- 避免冗余注释

## 4. 代码组织

### 4.1 包结构
- 按功能模块组织包
- 遵循`com.pgape.mahjong.[module].[layer]`的结构

```
com.pgape.mahjong
├── core          # 核心领域模型和逻辑
├── game          # 游戏逻辑相关
├── websocket     # WebSocket通信
├── controller    # 控制器层
├── service       # 服务层
├── repository    # 数据访问层
└── util          # 工具类
```

### 4.2 文件命名
- 遵循Java命名约定(PascalCase类名，camelCase方法名)
- 测试文件以Test结尾
- 配置类以Config结尾

## 5. 代码质量检查

### 5.1 代码审查要点
- 是否合理使用了项目依赖的工具库
- 代码是否遵循既定的编码标准
- 是否有适当的错误处理和日志记录
- 性能考虑是否得当

### 5.2 测试要求
- 业务逻辑代码必须有单元测试
- 测试覆盖率目标不低于80%
- 关键路径必须有集成测试