package cn.blog.service;

import cn.blog.entity.Video;

import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/8 19:13
 */
public interface FileService {

    /**
     * 插入文件视频
     * @param video
     * @return
     */
    int insertVideo(Video video);

    List<Video> selectAllVideo();
}
