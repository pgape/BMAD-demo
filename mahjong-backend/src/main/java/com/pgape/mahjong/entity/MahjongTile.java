package com.pgape.mahjong.entity;

import cn.hutool.core.util.RandomUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

/**
 * 麻将牌实体类
 */
@Entity
@Table(name = "mahjong_tile")
@Data
@EqualsAndHashCode(exclude = "tileId")  // 排除tileId字段，只基于suit和value比较
public class MahjongTile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 唯一标识符
     */
    @Column(unique = true, nullable = false)
    private String tileId;

    /**
     * 花色类型：万、筒、条、字
     */
    @Enumerated(EnumType.STRING)
    @NotNull
    private SuitType suit;

    /**
     * 数值：数字牌为1-9，字牌为1-7(东南西北中发白)
     */
    @Min(1)
    @Max(9)
    @NotNull
    private int value;

    public MahjongTile() {}

    public MahjongTile(SuitType suit, int value) {
        this.suit = suit;
        this.value = value;
        this.tileId = String.format("%s_%d_%d_%d", suit.name().toLowerCase(), value, System.currentTimeMillis(), RandomUtil.randomInt(10000));
    }
}