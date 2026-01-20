package com.pgape.mahjong.integration;

import com.pgape.mahjong.entity.MahjongTile;
import com.pgape.mahjong.entity.SuitType;
import com.pgape.mahjong.repository.TileRepository;
import com.pgape.mahjong.service.TileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
public class TileServiceIntegrationTest {

    @Container
    static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("mahjong_test")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlContainer::getUsername);
        registry.add("spring.datasource.password", mysqlContainer::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
    }

    @Autowired
    private TileService tileService;

    @Autowired
    private TileRepository tileRepository;

    @Test
    public void testInitializeTilesAndDatabasePersistence() {
        // 初始化麻将牌
        tileService.initializeTilesIfEmpty();

        // 验证数据库中的麻将牌数量
        long totalTiles = tileRepository.count();
        assertEquals(136, totalTiles, "数据库中应该有136张麻将牌");

        // 获取所有麻将牌
        List<MahjongTile> tiles = tileRepository.findAll();

        // 验证各种牌的数量
        // 万子牌 (1-9万，每种4张)
        for (int value = 1; value <= 9; value++) {
            List<MahjongTile> wanTiles = tileRepository.findBySuitAndValue(SuitType.WAN, value);
            assertEquals(4, wanTiles.size(), "万子牌 " + value + " 应该有4张");
        }

        // 筒子牌 (1-9筒，每种4张)
        for (int value = 1; value <= 9; value++) {
            List<MahjongTile> tongTiles = tileRepository.findBySuitAndValue(SuitType.TONG, value);
            assertEquals(4, tongTiles.size(), "筒子牌 " + value + " 应该有4张");
        }

        // 条子牌 (1-9条，每种4张)
        for (int value = 1; value <= 9; value++) {
            List<MahjongTile> tiaoTiles = tileRepository.findBySuitAndValue(SuitType.TIAO, value);
            assertEquals(4, tiaoTiles.size(), "条子牌 " + value + " 应该有4张");
        }

        // 字牌 (东南西北中发白，每种4张)
        for (int value = 1; value <= 7; value++) {
            List<MahjongTile> ziTiles = tileRepository.findBySuitAndValue(SuitType.ZI, value);
            assertEquals(4, ziTiles.size(), "字牌 " + value + " 应该有4张");
        }

        // 验证各花色牌的总数
        assertEquals(36, tileRepository.findBySuit(SuitType.WAN).size(), "万子牌应该有36张 (9种×4张)");
        assertEquals(36, tileRepository.findBySuit(SuitType.TONG).size(), "筒子牌应该有36张 (9种×4张)");
        assertEquals(36, tileRepository.findBySuit(SuitType.TIAO).size(), "条子牌应该有36张 (9种×4张)");
        assertEquals(28, tileRepository.findBySuit(SuitType.ZI).size(), "字牌应该有28张 (7种×4张)");
    }
}