# 四人麻将游戏 - AI前端生成提示

## 高层次目标
创建一个响应式的四人麻将游戏用户界面，支持桌面端和移动端，实现直观的游戏体验，包含游戏大厅、游戏主界面和结算界面。

## 详细步骤说明
1. 创建一个名为MahjongGame的React应用
2. 使用TypeScript和Tailwind CSS进行开发
3. 实现三个主要页面：游戏大厅(Lobby)、游戏主界面(GameBoard)、结算界面(Settlement)
4. 使用Socket.io进行实时多人游戏通信
5. 实现麻将牌组件，包含万子、筒子、条子、字牌的视觉表示
6. 创建玩家信息面板，显示手牌数量、昵称和状态
7. 添加游戏控制面板，包含操作按钮（吃、碰、杠、胡、跳过）
8. 实现响应式设计，确保在桌面端和移动端都有良好体验

## 代码示例、数据结构和约束
- 使用React 18+、TypeScript、Tailwind CSS
- 麻将牌数据结构示例：
```typescript
interface MahjongTile {
  id: string;
  suit: 'wan' | 'tong' | 'tiao' | 'zi'; // 万、筒、条、字
  value: number; // 1-9 for wan/tong/tiao, 1-7 for zi (东南西北中发白)
  isExposed?: boolean; // 是否明牌
}
```
- 玩家状态数据结构：
```typescript
interface Player {
  id: string;
  nickname: string;
  avatar: string;
  tiles: MahjongTile[];
  exposedGroups: MahjongTile[][];
  isCurrentTurn: boolean;
  score: number;
}
```
- 游戏状态数据结构：
```typescript
interface GameState {
  players: Player[];
  wallTiles: number; // 牌墙剩余牌数
  discardPile: MahjongTile[];
  currentPlayer: string;
  gameStatus: 'waiting' | 'playing' | 'ended';
}
```

- 不要包含复杂的动画效果，优先实现功能性
- 不要实现AI玩家逻辑，仅实现UI和用户交互
- 使用中国传统文化色彩搭配，主色调为深红(#8B0000)、金色(#FFD700)和米白色(#F5F5DC)

## 严格范围定义
- 你只需要创建前端UI组件，不需要实现后端逻辑
- 创建以下组件文件：
  - components/GameBoard.tsx (游戏主界面)
  - components/PlayerPanel.tsx (玩家信息面板)
  - components/MahjongTile.tsx (麻将牌组件)
  - components/GameControls.tsx (游戏控制面板)
  - pages/Lobby.tsx (游戏大厅页面)
  - pages/Settlement.tsx (结算页面)
- 不要修改package.json或其他配置文件
- 不要实现游戏逻辑，仅实现UI展示和用户交互界面
- 所有样式使用Tailwind CSS类，不要引入额外的CSS框架

## 视觉风格描述
- 背景使用深红色(#8B0000)或米白色(#F5F5DC)作为主色调
- 麻将牌使用传统的象牙白色背景，黑色或红色数字
- 按钮使用金色(#FFD700)突出显示重要操作
- 字体使用微软雅黑或苹方，确保中文显示清晰
- 界面布局清晰，突出显示当前玩家和可操作项
- 在移动端采用垂直布局，桌面端采用更宽的水平布局