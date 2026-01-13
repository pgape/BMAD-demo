# Brownfield MadCore 项目

## 项目概述

这是一个位于 `E:\Code\demo1` 的 Brownfield MadCore 项目。Brownfield MadCore 是一个旨在促进棕地（现有代码库）和绿地（新项目）开发工作流程的开发框架。该项目包含一套全面的工具、模板和工作流程，以支持敏捷软件开发。

### 关键组件

- **配置系统**: 通过 `.bmad-core/core-config.yaml` 进行管理
- **工作流程**: 为不同类型项目预定义的开发工作流程
- **模板**: 用于文档和项目结构的标准化模板
- **代理**: 开发团队中定义的专业角色
- **清单**: 质量保证和过程清单

## 架构

该项目遵循 MadCore 架构，具有以下关键目录：

- `.bmad-core/`: 核心框架文件和配置
  - `agent-teams/`: 团队构成定义
  - `agents/`: 个人代理角色定义（PO、PM、Dev、QA等）
  - `checklists/`: 过程和质量检查清单
  - `data/`: 支持数据文件
  - `tasks/`: 定义的任务和过程
  - `templates/`: 文档模板
  - `utils/`: 实用脚本和文档
  - `workflows/`: 预定义的项目工作流程

## 配置

项目通过 `core-config.yaml` 进行配置，定义了：

- PRD（产品需求文档）处理
- 架构文档设置
- 开发故事位置
- 调试日志路径

## 构建和运行

由于这是 MadCore 框架项目，传统的构建/运行命令不直接适用。相反，框架提供：

1. **工作流程管理**: 为不同类型项目使用预定义的工作流程
2. **故事创建**: 基于需求生成开发故事
3. **文档生成**: 从模板自动生成文档

要使用此项目：

1. 熟悉 `.bmad-core/workflows/` 中可用的工作流程
2. 查看 `.bmad-core/agents/` 中的代理角色以了解团队职责
3. 使用 `.bmad-core/templates/` 中的模板进行一致的文档编写

## 开发约定

MadCore 框架强制执行某些开发约定：

- 使用 `.bmad-core/tasks/create-next-story.md` 流程进行故事驱动开发
- 在 `.bmad-core/tasks/qa-gate.md` 中定义的质量门
- 通过 `.bmad-core/tasks/trace-requirements.md` 进行需求跟踪

## 关键文件

- `.bmad-core/core-config.yaml`: 主项目配置
- `.bmad-core/install-manifest.yaml`: 框架安装详情
- `.bmad-core/user-guide.md`: 框架的用户文档
- `.bmad-core/enhanced-ide-development-workflow.md`: 增强IDE工作流程文档

## 使用方法

此项目作为使用 Brownfield MadCore 框架的模板。要开始开发：

1. 从 `.bmad-core/workflows/` 中选择适当的工作流程
2. 根据需要自定义 `core-config.yaml` 中的配置
3. 遵循定义的过程和清单进行一致的开发
4. 使用代理系统分配角色和职责