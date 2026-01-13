package com.pgape.mahjong.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MahjongTileFactoryTest {

    @Test
    public void testInitializeMahjongTiles() {
        // 初始化麻将牌
        List<MahjongTile> tiles = MahjongTileFactory.initializeMahjongTiles();
        
        // 验证总数为136张
        assertEquals(136, tiles.size(), "麻将牌总数应该是136张");
        
        // 验证各种牌的数量
        // 万子牌 (1-9万，每种4张)
        for (int value = 1; value <= 9; value++) {
            int count = MahjongTileFactory.getCountBySuitAndValue(tiles, "wan", value);
            assertEquals(4, count, "万子牌 " + value + " 应该有4张");
        }
        
        // 筒子牌 (1-9筒，每种4张)
        for (int value = 1; value <= 9; value++) {
            int count = MahjongTileFactory.getCountBySuitAndValue(tiles, "tong", value);
            assertEquals(4, count, "筒子牌 " + value + " 应该有4张");
        }
        
        // 条子牌 (1-9条，每种4张)
        for (int value = 1; value <= 9; value++) {
            int count = MahjongTileFactory.getCountBySuitAndValue(tiles, "tiao", value);
            assertEquals(4, count, "条子牌 " + value + " 应该有4张");
        }
        
        // 字牌 (东南西北中发白，每种4张)
        for (int value = 1; value <= 7; value++) {
            int count = MahjongTileFactory.getCountBySuitAndValue(tiles, "zi", value);
            assertEquals(4, count, "字牌 " + value + " 应该有4张");
        }
        
        // 验证各花色牌的总数
        assertEquals(36, MahjongTileFactory.getCountBySuit(tiles, "wan"), "万子牌应该有36张 (9种×4张)");
        assertEquals(36, MahjongTileFactory.getCountBySuit(tiles, "tong"), "筒子牌应该有36张 (9种×4张)");
        assertEquals(36, MahjongTileFactory.getCountBySuit(tiles, "tiao"), "条子牌应该有36张 (9种×4张)");
        assertEquals(28, MahjongTileFactory.getCountBySuit(tiles, "zi"), "字牌应该有28张 (7种×4张)");
    }
}