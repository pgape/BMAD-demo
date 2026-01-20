package com.pgape.mahjong.service;

import com.pgape.mahjong.entity.MahjongTile;
import com.pgape.mahjong.entity.SuitType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

public class TileServiceTest {

    private TileService tileService;

    @BeforeEach
    void setUp() {
        // 由于TileService依赖于TileRepository，我们需要创建一个mock或使用内存数据库进行测试
        // 这里我们直接测试generateStandardTiles方法
        tileService = new TileService(null); // 传入null因为PostConstruct方法不会被调用
    }

    @Test
    public void testGenerateStandardTiles() {
        // 生成麻将牌
        List<MahjongTile> tiles = tileService.generateStandardTiles();

        // 验证总数为136张
        assertEquals(136, tiles.size(), "麻将牌总数应该是136张");

        // 验证各种牌的数量
        // 万子牌 (1-9万，每种4张)
        for (int value = 1; value <= 9; value++) {
            final int finalValue = value; // 使变量成为实际上的final
            long count = tiles.stream()
                    .filter(tile -> SuitType.WAN.equals(tile.getSuit()) && finalValue == tile.getValue())
                    .count();
            assertEquals(4, count, "万子牌 " + value + " 应该有4张");
        }

        // 筒子牌 (1-9筒，每种4张)
        for (int value = 1; value <= 9; value++) {
            final int finalValue = value; // 使变量成为实际上的final
            long count = tiles.stream()
                    .filter(tile -> SuitType.TONG.equals(tile.getSuit()) && finalValue == tile.getValue())
                    .count();
            assertEquals(4, count, "筒子牌 " + value + " 应该有4张");
        }

        // 条子牌 (1-9条，每种4张)
        for (int value = 1; value <= 9; value++) {
            final int finalValue = value; // 使变量成为实际上的final
            long count = tiles.stream()
                    .filter(tile -> SuitType.TIAO.equals(tile.getSuit()) && finalValue == tile.getValue())
                    .count();
            assertEquals(4, count, "条子牌 " + value + " 应该有4张");
        }

        // 字牌 (东南西北中发白，每种4张)
        for (int value = 1; value <= 7; value++) {
            final int finalValue = value; // 使变量成为实际上的final
            long count = tiles.stream()
                    .filter(tile -> SuitType.ZI.equals(tile.getSuit()) && finalValue == tile.getValue())
                    .count();
            assertEquals(4, count, "字牌 " + value + " 应该有4张");
        }

        // 验证各花色牌的总数
        long wanCount = tiles.stream().filter(tile -> SuitType.WAN.equals(tile.getSuit())).count();
        long tongCount = tiles.stream().filter(tile -> SuitType.TONG.equals(tile.getSuit())).count();
        long tiaoCount = tiles.stream().filter(tile -> SuitType.TIAO.equals(tile.getSuit())).count();
        long ziCount = tiles.stream().filter(tile -> SuitType.ZI.equals(tile.getSuit())).count();

        assertEquals(36, wanCount, "万子牌应该有36张 (9种×4张)");
        assertEquals(36, tongCount, "筒子牌应该有36张 (9种×4张)");
        assertEquals(36, tiaoCount, "条子牌应该有36张 (9种×4张)");
        assertEquals(28, ziCount, "字牌应该有28张 (7种×4张)");
    }
}