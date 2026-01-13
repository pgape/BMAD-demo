# 项目源码树结构

## 概述

本文档详细描述了四人麻将游戏项目的完整源码树结构，包括前后端模块的组织方式和各目录的用途。

## 完整目录结构

```
mahjong-game/
├── .gitignore                    # Git忽略文件配置
├── PROJECT_SETUP.md              # 项目初始化文档
├── README.md                     # 项目主说明文档
├── docker-compose.yml            # Docker编排配置文件
├── backend/                      # 后端模块
│   ├── Dockerfile                # 后端Docker配置
│   ├── pom.xml                   # Maven配置文件
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── pgape/
│   │   │   │           └── games/
│   │   │   │               └── mahjong/
│   │   │   │                   ├── MahjongApplication.java    # Spring Boot启动类
│   │   │   │                   ├── controller/               # 控制器层
│   │   │   │                   │   ├── GameController.java   # 游戏相关控制器
│   │   │   │                   │   └── TileController.java   # 麻将牌相关控制器
│   │   │   │                   ├── service/                  # 服务层
│   │   │   │                   │   ├── GameService.java      # 游戏业务逻辑
│   │   │   │                   │   └── TileService.java      # 麻将牌业务逻辑
│   │   │   │                   ├── entity/                   # 实体类
│   │   │   │                   │   ├── Game.java             # 游戏实体
│   │   │   │                   │   ├── Player.java           # 玩家实体
│   │   │   │                   │   ├── MahjongTile.java      # 麻将牌实体
│   │   │   │                   │   └── GameRecord.java       # 游戏记录实体
│   │   │   │                   ├── repository/               # 数据访问层
│   │   │   │                   │   ├── GameRepository.java   # 游戏数据访问
│   │   │   │                   │   ├── PlayerRepository.java # 玩家数据访问
│   │   │   │                   │   └── TileRepository.java   # 麻将牌数据访问
│   │   │   │                   └── config/                   # 配置类
│   │   │   │                       ├── WebSocketConfig.java  # WebSocket配置
│   │   │   │                       └── SecurityConfig.java   # 安全配置
│   │   │   └── resources/
│   │   │       ├── application.yml         # 主配置文件
│   │   │       ├── application-dev.yml     # 开发环境配置
│   │   │       ├── application-prod.yml    # 生产环境配置
│   │   │       ├── static/                 # 静态资源
│   │   │       └── templates/              # 模板文件
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── pgape/
│   │                   └── games/
│   │                       └── mahjong/
│   │                           ├── MahjongApplicationTests.java
│   │                           ├── service/
│   │                           │   ├── GameServiceTest.java
│   │                           │   └── TileServiceTest.java
│   │                           └── controller/
│   │                               ├── GameControllerTest.java
│   │                               └── TileControllerTest.java
│   └── target/                           # Maven构建输出目录
├── frontend/                     # 前端模块
│   ├── Dockerfile                # 前端Docker配置
│   ├── package.json              # npm配置文件
│   ├── package-lock.json         # npm锁定版本文件
│   ├── tsconfig.json             # TypeScript配置
│   ├── tsconfig.node.json        # TypeScript节点配置
│   ├── vite.config.ts            # Vite构建配置
│   ├── index.html                # 主HTML文件
│   ├── public/                   # 公共资源
│   │   ├── favicon.ico           # 网站图标
│   │   └── manifest.json         # 应用清单
│   ├── src/                      # 源码目录
│   │   ├── App.tsx               # 主应用组件
│   │   ├── main.tsx              # 应用入口
│   │   ├── index.css             # 全局样式
│   │   ├── components/           # 可复用组件
│   │   │   ├── GameBoard.tsx     # 游戏面板组件
│   │   │   ├── PlayerPanel.tsx   # 玩家面板组件
│   │   │   ├── Tile.tsx          # 麻将牌组件
│   │   │   ├── ChatBox.tsx       # 聊天框组件
│   │   │   └── GameControls.tsx  # 游戏控制组件
│   │   ├── pages/                # 页面组件
│   │   │   ├── LobbyPage.tsx     # 大厅页面
│   │   │   ├── GamePage.tsx      # 游戏页面
│   │   │   ├── ProfilePage.tsx   # 个人资料页面
│   │   │   └── RankingPage.tsx   # 排行榜页面
│   │   ├── hooks/                # 自定义React Hooks
│   │   │   ├── useGame.ts        # 游戏状态Hook
│   │   │   ├── useWebSocket.ts   # WebSocket连接Hook
│   │   │   └── useAuth.ts        # 认证相关Hook
│   │   ├── services/             # API服务
│   │   │   ├── api.ts            # API基础配置
│   │   │   ├── gameService.ts    # 游戏相关API
│   │   │   ├── authService.ts    # 认证相关API
│   │   │   └── playerService.ts  # 玩家相关API
│   │   ├── store/                # Redux状态管理
│   │   │   ├── index.ts          # Store配置
│   │   │   ├── slices/           # State切片
│   │   │   │   ├── gameSlice.ts  # 游戏状态切片
│   │   │   │   ├── playerSlice.ts # 玩家状态切片
│   │   │   │   └── uiSlice.ts    # UI状态切片
│   │   │   └── types/            # Redux类型定义
│   │   │       ├── gameTypes.ts  # 游戏相关类型
│   │   │       └── playerTypes.ts # 玩家相关类型
│   │   ├── utils/                # 工具函数
│   │   │   ├── constants.ts      # 常量定义
│   │   │   ├── helpers.ts        # 辅助函数
│   │   │   └── validators.ts     # 验证函数
│   │   ├── styles/               # 样式文件
│   │   │   ├── globals.css       # 全局样式
│   │   │   ├── components.css    # 组件样式
│   │   │   └── responsive.css    # 响应式样式
│   │   └── types/                # TypeScript类型定义
│   │       ├── global.d.ts       # 全局类型
│   │       └── api.d.ts          # API类型定义
│   ├── dist/                     # 构建输出目录
│   └── node_modules/             # npm依赖包目录
└── docs/                         # 文档目录
    ├── architecture/             # 架构文档
    │   ├── architecture-mvp-design.md    # MVP架构设计
    │   ├── architecture-full-design.md   # 完整架构设计
    │   ├── tech-stack.md         # 技术栈文档
    │   ├── coding-standards.md   # 编码标准文档
    │   └── source-tree.md        # 源码树文档
    ├── stories/                  # 用户故事文档
    │   └── 1.1.初始化麻将牌系统.md # 故事1.1文档
    └── prd.md                    # 产品需求文档
```

## 目录说明

### backend/
- **src/main/java/com/pgape/games/mahjong/**: 后端Java源码
  - **controller/**: Spring MVC控制器，处理HTTP请求
  - **service/**: 业务逻辑层，实现核心业务功能
  - **entity/**: JPA实体类，对应数据库表结构
  - **repository/**: 数据访问层，处理数据库操作
  - **config/**: 应用配置类

- **src/main/resources/**: 资源文件
  - **application.yml**: 主配置文件，包含数据库、服务器等配置
  - **static/**: 静态资源文件（CSS, JS, 图片等）
  - **templates/**: 模板文件（Thymeleaf等）

- **src/test/**: 测试代码
  - 包含单元测试和集成测试

### frontend/
- **src/components/**: 可复用的UI组件
- **src/pages/**: 页面级别的组件
- **src/hooks/**: 自定义React Hooks
- **src/services/**: API服务和网络请求
- **src/store/**: Redux状态管理
- **src/utils/**: 工具函数和常量
- **src/styles/**: CSS样式文件

### docs/
- **architecture/**: 系统架构相关文档
- **stories/**: 用户故事和需求文档
- **其他文档**: 产品需求文档等

这个目录结构遵循了前后端分离的原则，便于团队协作开发和后期维护。