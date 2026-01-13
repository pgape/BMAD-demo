# 编码标准规范文档

## 1. 项目概述

本文档定义了四人麻将游戏项目的编码标准和最佳实践。这些标准旨在确保代码质量、提高可维护性，并为AI开发代理提供明确的编码指导。

## 2. 通用编码标准

### 2.1 语言和运行时
- **Java**: 使用Java 17+版本
- **JavaScript/TypeScript**: 使用最新ES标准兼容版本
- **编码**: 统一使用UTF-8编码
- **换行符**: 使用Unix风格换行符(\n)

### 2.2 代码风格与格式化
- **缩进**: 使用4个空格进行缩进（不要使用Tab字符）
- **行长度**: 每行不超过120个字符
- **命名**: 使用有意义的英文命名，避免缩写
- **注释**: 重要逻辑必须添加中文注释，说明设计意图

### 2.3 代码组织
- 按功能模块组织代码文件
- 保持类和方法的单一职责原则
- 合理使用包(package)和命名空间(namespace)进行代码分层

## 3. Java编码标准

### 3.1 命名约定
| 元素类型 | 约定 | 示例 |
|----------|------|------|
| 类名 | PascalCase | `GameRoomService` |
| 方法名 | camelCase | `getPlayerHand()` |
| 变量名 | camelCase | `playerCount` |
| 常量名 | UPPER_SNAKE_CASE | `MAX_PLAYERS = 4` |
| 接口名 | PascalCase | `GameLogicService` |
| 抽象类名 | PascalCase，以Abstract开头 | `AbstractGameRule` |

### 3.2 代码结构
- 类成员按以下顺序排列：
  1. 字段声明
  2. 构造函数
  3. 公共方法
  4. 私有方法
- 每个文件只包含一个公共类
- 使用适当的访问修饰符(private, protected, public)

### 3.3 注释标准
```java
/**
 * 游戏房间服务类
 * 管理游戏房间的创建、玩家加入和游戏状态管理
 */
public class GameRoomService {
    
    /**
     * 获取当前房间内的玩家数量
     * @return 玩家数量
     */
    public int getPlayerCount() {
        // 实现细节
    }
}
```

### 3.4 关键规则
- 所有数据库查询必须使用预编译语句防止SQL注入
- 异常处理必须记录日志并返回适当的错误信息
- 业务逻辑与数据访问逻辑必须分离
- 使用Spring的事务管理注解(@Transactional)处理数据库事务

## 4. JavaScript/TypeScript编码标准

### 4.1 命名约定
| 元素类型 | 约定 | 示例 |
|----------|------|------|
| 变量/函数 | camelCase | `getPlayerHand()` |
| 类名 | PascalCase | `MahjongTile` |
| 常量 | UPPER_SNAKE_CASE | `MAX_PLAYERS` |
| 文件名 | kebab-case | `game-board.jsx` |

### 4.2 代码结构
- 使用ES6+语法特性
- 优先使用const和let，避免var
- 使用箭头函数适当场景下
- 使用解构赋值简化代码

### 4.3 注释标准
```javascript
/**
 * 处理玩家摸牌操作
 * @param {string} playerId - 玩家ID
 * @param {string} roomId - 房间ID
 * @returns {Promise<Object>} 摸牌结果
 */
const drawTile = async (playerId, roomId) => {
  // 实现细节
};
```

## 5. 前端开发标准

### 5.1 React组件标准
- 使用函数组件和Hooks
- 组件名称以大写字母开头
- Props类型使用TypeScript接口定义
- 合理使用Context和Redux进行状态管理

```jsx
// 示例：麻将牌组件
interface MahjongTileProps {
  suit: 'wan' | 'tong' | 'tiao' | 'zi';
  value: number;
  onClick?: () => void;
}

const MahjongTile: React.FC<MahjongTileProps> = ({ suit, value, onClick }) => {
  return (
    <div className="mahjong-tile" onClick={onClick}>
      {/* 组件实现 */}
    </div>
  );
};
```

### 5.2 样式标准
- 使用Tailwind CSS进行样式设计
- 保持一致的颜色主题和间距规范
- 响应式设计适配不同设备尺寸

## 6. 数据模型标准

### 6.1 实体定义
- 使用接口定义数据模型
- 包含必要的验证注解
- 为每个字段提供中文注释

```java
/**
 * 麻将牌实体
 */
public class MahjongTile {
    @NotBlank(message = "牌ID不能为空")
    private String tileId;  // 唯一标识符
    
    @NotNull(message = "牌面类型不能为空")
    private SuitType suit;  // 万、筒、条、字
    
    @Min(value = 1, message = "牌值不能小于1")
    @Max(value = 9, message = "牌值不能大于9")
    private Integer value;  // 1-9 for numbered suits, 1-7 for zi
}
```

## 7. 错误处理标准

### 7.1 异常处理
- 定义统一的异常基类
- 不要忽略异常，必须进行适当处理
- 记录错误日志，但不要暴露敏感信息

### 7.2 返回格式
- 使用统一的响应包装类
- 包含状态码、消息和数据字段

```java
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;
    
    // 构造函数和getter/setter
}
```

## 8. 测试标准

### 8.1 单元测试
- 使用JUnit 5进行单元测试
- 测试覆盖率目标不低于80%
- 遵循AAA模式（Arrange, Act, Assert）

### 8.2 集成测试
- 测试组件之间的交互
- 使用Testcontainers进行数据库集成测试
- 模拟外部服务调用

## 9. 安全标准

### 9.1 输入验证
- 所有外部输入必须验证
- 使用白名单验证而非黑名单
- 防止SQL注入、XSS攻击

### 9.2 认证授权
- 使用JWT进行身份验证
- 实现适当的会话管理
- 敏感操作需要额外验证

## 10. 性能优化标准

### 10.1 代码优化
- 避免不必要的计算和循环
- 使用缓存减少重复计算
- 优化数据库查询，使用适当索引

### 10.2 前端优化
- 实现代码分割和懒加载
- 使用虚拟滚动处理大量数据
- 优化图片资源和缓存策略

## 11. Git提交标准

### 11.1 提交信息格式
```
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

### 11.2 类型定义
- feat: 新功能
- fix: 修复bug
- docs: 文档更新
- style: 代码格式调整
- refactor: 重构代码
- test: 测试相关
- chore: 构建过程或辅助工具变动

## 12. 代码审查标准

### 12.1 审查要点
- 代码是否符合本标准
- 是否存在潜在的安全漏洞
- 性能是否经过考虑
- 是否有足够的测试覆盖
- 文档是否更新

### 12.2 审查流程
- 至少一名团队成员审查
- 使用Pull Request进行代码合并
- CI检查通过后方可合并