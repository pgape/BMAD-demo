package com.pgape.mahjong.service;

import com.pgape.mahjong.entity.MahjongTile;
import com.pgape.mahjong.entity.SuitType;
import com.pgape.mahjong.repository.TileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class TileService {

    private final TileRepository tileRepository;

    /**
     * 初始化136张标准麻将牌（仅在数据库为空时）
     */
    @PostConstruct
    public void initializeTilesIfEmpty() {
        if (tileRepository.count() == 0) {
            List<MahjongTile> tiles = generateStandardTiles();
            tileRepository.saveAll(tiles);
        }
    }

    /**
     * 生成136张标准麻将牌
     *
     * @return 包含136张麻将牌的列表
     */
    public List<MahjongTile> generateStandardTiles() {
        List<MahjongTile> tiles = generateTilesForSuit(SuitType.WAN, 1, 9);      // 万子牌 (1-9万，每种4张)
        tiles.addAll(generateTilesForSuit(SuitType.TONG, 1, 9));    // 筒子牌 (1-9筒，每种4张)
        tiles.addAll(generateTilesForSuit(SuitType.TIAO, 1, 9));    // 条子牌 (1-9条，每种4张)
        tiles.addAll(generateTilesForSuit(SuitType.ZI, 1, 7));      // 字牌 (东南西北中发白，每种4张)

        return tiles;
    }

    /**
     * 为指定花色生成麻将牌
     *
     * @param suit  花色
     * @param start 起始数值
     * @param end   结束数值
     * @return 指定花色的麻将牌列表
     */
    private List<MahjongTile> generateTilesForSuit(SuitType suit, int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .flatMap(value -> IntStream.range(0, 4)  // 每种牌4张
                        .mapToObj(i -> new MahjongTile(suit, value)))
                .collect(Collectors.toList());
    }

    /**
     * 获取所有麻将牌
     *
     * @return 麻将牌列表
     */
    public List<MahjongTile> getAllTiles() {
        return tileRepository.findAll();
    }

    /**
     * 根据花色获取麻将牌
     *
     * @param suit 花色
     * @return 指定花色的麻将牌列表
     */
    public List<MahjongTile> getTilesBySuit(SuitType suit) {
        return tileRepository.findBySuit(suit);
    }

    /**
     * 根据花色和数值获取麻将牌
     *
     * @param suit  花色
     * @param value 数值
     * @return 指定花色和数值的麻将牌列表
     */
    public List<MahjongTile> getTilesBySuitAndValue(SuitType suit, int value) {
        return tileRepository.findBySuitAndValue(suit, value);
    }
}