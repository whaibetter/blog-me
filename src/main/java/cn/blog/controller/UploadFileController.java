package cn.blog.controller;

import cn.blog.entity.ResultVO;
import cn.blog.entity.Video;
import cn.blog.entity.vo.UploadFileVO;

import cn.blog.service.FileService;
import cn.blog.utils.FileUpDownLoadUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author whai_luo
 */
@Controller
public class UploadFileController {

    @Autowired
    FileService fileService;
    /**
     * ͼƬ�ļ��ϴ�
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO uploadImage(@Param("file")MultipartFile file) throws IOException {


        String rootPath = (".\\uploads/");
        //�ļ�����������,��spring.jpeg
        String filename = file.getOriginalFilename();
        //�ļ���,��spring
        String name = filename.substring(0,filename.indexOf("."));
        //�ļ���׺,��.jpeg
        String suffix = filename.substring(filename.lastIndexOf("."));

        //���������ļ���
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR)
                + File.separator + (date.get(Calendar.MONTH)+1));
        System.out.println(dateDirs.getPath());

        //Ŀ���ļ�
        File descFile = new File(rootPath+File.separator+dateDirs+File.separator+filename);
        int i = 1;
        //���ļ�����������
        String newFilename = filename;
        while(descFile.exists()) {
            newFilename = name+"("+i+")"+suffix;
            String parentPath = descFile.getParent();
            descFile = new File(parentPath+File.separator+newFilename);
            i++;
        }
        //�ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����
        if(!descFile.getParentFile().exists()) {
            //���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼
            descFile.getParentFile().mkdirs();
        }

        //���ڴ��е�����д�����
        file.transferTo(descFile);
        //������url
        String fileUrl =  "/uploads/"+dateDirs+ "/"+newFilename;

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("�ɹ�");

        UploadFileVO uploadFileVO = new UploadFileVO();
        uploadFileVO.setTitle(filename);
        uploadFileVO.setSrc(fileUrl);
        resultVO.setData(uploadFileVO);

        return resultVO;
    }



    /**
     * �ļ��б�
     * @return
     */
    @RequestMapping("/FileList")
    public ModelAndView FileList(){

        //��ѯ�����ļ�
        List<Video> videos = fileService.selectAllVideo();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("files",videos);
        modelAndView.setViewName("Main/Home/FileList");
        return modelAndView;
    }


    @RequestMapping("/uploadFile")
    @ResponseBody
    public String upload(HttpServletRequest request,
                       @Param("file")MultipartFile file){
        Map<String, Object> map = new HashMap<>();
        try {

            Video video = FileUpDownLoadUtil.upload(request, file);

            //��װΪvideo���� λ����Ϣ�ͱ���
            //�ɹ�ʱi=1
            int i = fileService.insertVideo(video);
            map.put("code",i);
            map.put("msg","�ϴ��ɹ�");
            return new JSONObject(map).toString();
        } catch (IOException e) {
            e.printStackTrace();
            map.put("code",0);
            map.put("msg","�ϴ�ʧ��");
            return new JSONObject(map).toString();
        }

    }


    @RequestMapping(value = "/download")
    public String downloadResource(Video video, HttpServletResponse response, HttpServletRequest request) {
        String dataDirectory = request.getSession().getServletContext().getRealPath("/") + "uploads";
//        String videoTitle = video.getVideoTitle();
        File file = new File(dataDirectory, video.getVideoTitle());
        if (file.exists()) {

            //����Content-Disposition������attachment��������ἤ���ļ����ؿ�filenameָ�����غ�Ĭ�ϱ�����ļ���
            //������Content-Disposition�Ļ����ļ�����������ڴ򿨣�����txt��img�ļ�
            response.addHeader("Content-Disposition",
                    "attachment; filename=" + video.getVideoTitle());

            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            // if using Java 7, use try-with-resources
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (IOException ex) {
                // do something,
                // probably forward to an Error page
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
        return null;
    }

}

