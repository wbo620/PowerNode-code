package com.powernode.http;

import com.powernode.http.modle.Album;
import com.powernode.http.record.AlbumRecord;
import com.powernode.http.service.AlbumService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * User: hallen
 * Date: 2023/8/24
 * Time: 16:49
 */

@SpringBootTest
public class AlbumTest {
    @Resource
    private AlbumService albumService;

    @Test
    void selectById() {
        Album album = albumService.getById(1);
        System.out.println(album);
    }

    @Test
    void queryByIdReturnRecord() {
        AlbumRecord albumRecord = albumService.getByIdReturnRecord(19999);
        System.out.println(albumRecord);
    }
}
