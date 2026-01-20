package com.pgape.mahjong.controller;

import com.pgape.mahjong.entity.MahjongTile;
import com.pgape.mahjong.entity.SuitType;
import com.pgape.mahjong.service.TileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiles")
@RequiredArgsConstructor
public class TileController {

    private final TileService tileService;

    /**
     * 获取所有麻将牌
     *
     * @return 麻将牌列表
     */
    @GetMapping
    public ResponseEntity<List<MahjongTile>> getAllTiles() {
        List<MahjongTile> tiles = tileService.getAllTiles();
        return ResponseEntity.ok(tiles);
    }

    /**
     * 根据花色获取麻将牌
     *
     * @param suit 花色
     * @return 指定花色的麻将牌列表
     */
    @GetMapping("/suit/{suit}")
    public ResponseEntity<List<MahjongTile>> getTilesBySuit(@PathVariable SuitType suit) {
        List<MahjongTile> tiles = tileService.getTilesBySuit(suit);
        return ResponseEntity.ok(tiles);
    }

    /**
     * 根据花色和数值获取麻将牌
     *
     * @param suit  花色
     * @param value 数值
     * @return 指定花色和数值的麻将牌列表
     */
    @GetMapping("/suit/{suit}/value/{value}")
    public ResponseEntity<List<MahjongTile>> getTilesBySuitAndValue(
            @PathVariable SuitType suit,
            @PathVariable int value) {
        List<MahjongTile> tiles = tileService.getTilesBySuitAndValue(suit, value);
        return ResponseEntity.ok(tiles);
    }

    /**
     * 初始化麻将牌（如果数据库为空）
     *
     * @return 初始化结果信息
     */
    @PostMapping("/initialize")
    public ResponseEntity<String> initializeTiles() {
        tileService.initializeTilesIfEmpty();
        return ResponseEntity.ok("麻将牌初始化完成");
    }
}