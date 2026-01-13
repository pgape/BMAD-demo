# 四人麻将游戏系统

## 项目简介

四人麻将游戏系统是一个基于Web的在线麻将游戏平台，支持四人在线对战。该项目采用前后端分离的架构设计，使用现代技术栈构建，旨在提供流畅的游戏体验和可扩展的系统架构。

## 技术栈

### 后端技术栈
- **语言**: Java 17+
- **框架**: Spring Boot 3.x
- **持久层**: Spring Data JPA
- **数据库**: PostgreSQL
- **构建工具**: Maven
- **测试框架**: JUnit 5, Mockito, AssertJ

### 前端技术栈
- **框架**: React 18+
- **语言**: TypeScript
- **状态管理**: Redux Toolkit
- **路由**: React Router
- **构建工具**: Vite
- **样式**: Tailwind CSS
- **测试框架**: Jest + React Testing Library

## 项目结构

```
mahjong-game/
├── backend/                    # 后端模块
│   ├── src/main/java/com/pgape/games/mahjong/
│   │   ├── controller/         # 控制器层
│   │   ├── service/            # 服务层
│   │   ├── entity/             # 实体类
│   │   ├── repository/         # 数据访问层
│   │   └── config/             # 配置类
│   ├── src/main/resources/
│   │   ├── application.yml     # 应用配置文件
│   │   └── application-dev.yml # 开发环境配置
│   └── pom.xml                 # Maven配置文件
├── frontend/                   # 前端模块
│   ├── src/
│   │   ├── components/         # React组件
│   │   ├── pages/              # 页面组件
│   │   ├── hooks/              # 自定义hooks
│   │   ├── utils/              # 工具函数
│   │   ├── services/           # API服务
│   │   ├── store/              # Redux store
│   │   └── styles/             # 样式文件
│   ├── public/
│   ├── package.json            # npm配置文件
│   ├── tsconfig.json           # TypeScript配置
│   └── vite.config.ts          # Vite配置
├── docker-compose.yml          # Docker编排文件
└── README.md                   # 项目说明文档
```

## 环境要求

### 开发环境
- Java 17+
- Maven 3.8+
- Node.js 18+
- PostgreSQL 15+

### 运行环境
- Java 17+ (后端)
- Node.js 18+ (前端构建)
- PostgreSQL 15+
- Docker (可选，用于容器化部署)

## 快速开始

### 1. 克隆项目

```bash
git clone <repository-url>
cd mahjong-game
```

### 2. 后端设置

```bash
# 进入后端目录
cd backend

# 安装依赖并启动应用
mvn clean install
mvn spring-boot:run
```

后端服务默认运行在 `http://localhost:8080`

### 3. 前端设置

```bash
# 在另一个终端窗口中，进入前端目录
cd frontend

# 安装依赖
npm install

# 启动开发服务器
npm run dev
```

前端开发服务器默认运行在 `http://localhost:3000`

### 4. 使用Docker启动

```bash
# 使用Docker Compose启动整个应用
docker-compose up --build
```

## 配置说明

### 数据库配置

后端使用PostgreSQL数据库，默认配置如下：

- 数据库名: `mahjong_game`
- 用户名: `mahjong_user`
- 密码: `mahjong_password`
- 端口: `5432`

如需修改，请更新 `backend/src/main/resources/application.yml` 文件中的数据库连接信息。

### API接口

后端提供RESTful API接口，基础路径为 `/api/v1`。

## 开发指南

### 后端开发

1. **实体类**: 在 `entity` 包中定义JPA实体类
2. **数据访问**: 在 `repository` 包中定义数据访问接口
3. **业务逻辑**: 在 `service` 包中实现业务逻辑
4. **控制器**: 在 `controller` 包中定义REST API端点
5. **配置**: 在 `config` 包中添加应用配置

### 前端开发

1. **页面组件**: 在 `pages` 目录中创建页面级组件
2. **通用组件**: 在 `components` 目录中创建可复用组件
3. **状态管理**: 使用Redux Toolkit管理全局状态
4. **API调用**: 在 `services` 目录中封装API调用
5. **工具函数**: 在 `utils` 目录中放置通用工具函数

## 测试

### 后端测试

运行后端测试：

```bash
cd backend
mvn test
```

### 前端测试

运行前端测试：

```bash
cd frontend
npm run test
```

## 部署

### 构建生产版本

1. **构建后端**:
   ```bash
   cd backend
   mvn clean package -DskipTests
   ```

2. **构建前端**:
   ```bash
   cd frontend
   npm run build
   ```

### Docker部署

使用Docker Compose进行部署：

```bash
docker-compose up -d --build
```

## API文档

API文档将在 `/api/v1/swagger-ui.html` 路径下提供（如果启用了Swagger）。

## 贡献指南

1. Fork项目
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 创建Pull Request

## 许可证

本项目采用 MIT 许可证 - 详见 [LICENSE](LICENSE) 文件。

## 联系方式

项目维护者: pgape
邮箱: [你的邮箱地址]

## 致谢

- 感谢所有为项目做出贡献的开发者
- 感谢使用的开源框架和库的开发者