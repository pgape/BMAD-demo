package com.pgape.mahjong.core;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import com.pgape.mahjong.entity.MahjongTile;
import com.pgape.mahjong.entity.SuitType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 麻将牌工厂类，负责初始化136张标准麻将牌
 */
public class MahjongTileFactory {

    private static final int COUNT_PER_TILE = 4; // 每种牌有4张

    /**
     * 初始化136张标准麻将牌（不含花牌）
     *
     * @return 包含136张麻将牌的列表
     */
    public static List<MahjongTile> initializeMahjongTiles() {
        List<MahjongTile> tiles = CollUtil.newArrayList();

        // 创建万子牌 (1-9万，每种4张)
        addTilesForSuit(tiles, SuitType.WAN, 1, 9);

        // 创建筒子牌 (1-9筒，每种4张)
        addTilesForSuit(tiles, SuitType.TONG, 1, 9);

        // 创建条子牌 (1-9条，每种4张)
        addTilesForSuit(tiles, SuitType.TIAO, 1, 9);

        // 创建字牌 (东南西北中发白，每种4张)
        // 1-4 代表东南西北，5-7 代表中发白
        addTilesForSuit(tiles, SuitType.ZI, 1, 7);

        return tiles;
    }

    /**
     * 为指定花色添加麻将牌
     *
     * @param tiles  麻将牌列表
     * @param suit   花色
     * @param start  起始数值
     * @param end    结束数值
     */
    private static void addTilesForSuit(List<MahjongTile> tiles, SuitType suit, int start, int end) {
        for (int value = start; value <= end; value++) {
            for (int count = 0; count < COUNT_PER_TILE; count++) {
                tiles.add(new MahjongTile(suit, value));
            }
        }
    }

    /**
     * 获取指定花色和数值的麻将牌数量
     *
     * @param tiles 麻将牌列表
     * @param suit  花色
     * @param value 数值
     * @return 指定牌的数量
     */
    public static int getCountBySuitAndValue(List<MahjongTile> tiles, SuitType suit, int value) {
        return (int) tiles.stream()
                .filter(tile -> suit.equals(tile.getSuit()) && value == tile.getValue())
                .count();
    }

    /**
     * 按花色统计麻将牌数量
     *
     * @param tiles 麻将牌列表
     * @param suit  花色
     * @return 指定花色的牌数量
     */
    public static int getCountBySuit(List<MahjongTile> tiles, SuitType suit) {
        return (int) tiles.stream()
                .filter(tile -> suit.equals(tile.getSuit()))
                .count();
    }

    /**
     * 将麻将牌列表转换为按花色和数值分组的Map
     *
     * @param tiles 麻将牌列表
     * @return 分组后的Map，键为"花色_数值"格式的字符串
     */
    public static Map<String, List<MahjongTile>> groupTilesBySuitAndValue(List<MahjongTile> tiles) {
        return tiles.stream()
                .collect(Collectors.groupingBy(tile -> tile.getSuit().name() + "_" + tile.getValue()));
    }
}