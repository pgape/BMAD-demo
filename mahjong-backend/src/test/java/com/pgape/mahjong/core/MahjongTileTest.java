package com.pgape.mahjong.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MahjongTileTest {

    @Test
    public void testMahjongTileCreation() {
        // 测试麻将牌创建
        MahjongTile tile = new MahjongTile(SuitType.WAN, 1);
        assertEquals(SuitType.WAN, tile.getSuit());
        assertEquals(1, tile.getValue());
        assertNotNull(tile.getTileId());
        assertTrue(tile.getTileId().startsWith("wan_1_"));
    }

    @Test
    public void testEqualsAndHashCode() {
        // 测试相等性和哈希码
        MahjongTile tile1 = new MahjongTile(SuitType.WAN, 1);
        MahjongTile tile2 = new MahjongTile(SuitType.WAN, 1);
        MahjongTile tile3 = new MahjongTile(SuitType.TONG, 1);

        assertEquals(tile1, tile2);
        assertNotEquals(tile1, tile3);
    }
}