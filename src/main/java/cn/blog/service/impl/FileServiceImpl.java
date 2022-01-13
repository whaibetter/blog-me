package cn.blog.service.impl;

import cn.blog.entity.Video;
import cn.blog.mapper.VideoMapper;
import cn.blog.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/8 19:13
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    VideoMapper videoMapper;
    @Override
    public int insertVideo(Video video) {
        int insert = videoMapper.insert(video);
        return insert;
    }

    @Override
    public List<Video> selectAllVideo() {
        return videoMapper.selectAllVideo();
    }
}
