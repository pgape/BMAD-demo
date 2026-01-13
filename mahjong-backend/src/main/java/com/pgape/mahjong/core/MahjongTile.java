package com.pgape.mahjong.core;

import cn.hutool.core.util.RandomUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 麻将牌实体类
 */
@Data
@EqualsAndHashCode(exclude = "tileId")  // 排除tileId字段，只基于suit和value比较
public class MahjongTile {
    /**
     * 花色类型：万(wan)、筒(tong)、条(tiao)、字(zi)
     */
    private String suit;

    /**
     * 数值：数字牌为1-9，字牌为1-7(东南西北中发白)
     */
    private int value;

    /**
     * 唯一标识符
     */
    private String tileId;

    public MahjongTile(String suit, int value) {
        this.suit = suit;
        this.value = value;
        this.tileId = String.format("%s_%d_%d_%d", suit, value, System.currentTimeMillis(), RandomUtil.randomInt(10000));
    }
}