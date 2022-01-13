package cn.blog.utils;

import cn.blog.entity.User;
import cn.blog.entity.Video;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.UnknownServiceException;
import java.util.UUID;

/**
 * @author whai
 * @Date: 2020/4/1 16:48
 */
public class FileUpDownLoadUtil {

    //文件上传工具类
    public static Video upload(HttpServletRequest request, MultipartFile upload) throws IOException {
        // 使用fileupload组件完成文件上传
        // 上传的位置，获取绝对路径 即往upload文件夹上传文件
        String path = request.getSession().getServletContext().getRealPath("/")+"uploads";
        User user = (User) request.getSession().getAttribute("user");
        String userName;
        if (null == user){
            userName="admin";
        }else {
            userName = user.getUserName();
        }

        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        // 说明上传文件项
        // 获取上传文件的原来名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString();
        //文件名格式 16位uuid_用户名_文件名
        filename = uuid+"_"+userName+"_"+filename;

        // 完成文件上传 指定名称到指定路径
        upload.transferTo(new File(path,filename));
        Video video = new Video();
        video.setVideoTitle(filename);
        video.setVideoLocation(path+"\\"+filename);
        return video;
    }

    /*public static ResponseEntity<byte[]> download(String filename) throws IOException {

        String realPath = "E:\\uploads\\file";
        //获取下载文件的路径
        File file = new File(realPath, filename);
        //把下载文件构成一个文件处理   filename:前台传过来的文件名称

        //设置头信息
        HttpHeaders headers = new HttpHeaders();

        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // MediaType:互联网媒介类型 contentType：具体请求中的媒体类型信息
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }*/
}
