package com.pgape.mahjong.repository;

import com.pgape.mahjong.entity.MahjongTile;
import com.pgape.mahjong.entity.SuitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TileRepository extends JpaRepository<MahjongTile, Long> {
    List<MahjongTile> findBySuit(SuitType suit);
    
    List<MahjongTile> findBySuitAndValue(SuitType suit, int value);
}