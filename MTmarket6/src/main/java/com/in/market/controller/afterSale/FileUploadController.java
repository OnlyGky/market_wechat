package com.in.market.controller.afterSale;



import com.in.market.service.afterSale.FileUploadService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RequestMapping("/file")
@Controller
public class FileUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request) throws IOException {
        if(null == file){
            LOGGER.info("上传文件不能为空！");
            return "上传失败！文件为空！";
        }
//        System.out.println(fileUploadService.FILE_URL + "afterSale+***************");
//        File truePath = ResourceUtils.getFile("classpath:static/images/");

        String fileName = file.getOriginalFilename();
        final String FILE_PATH = fileUploadService.FILE_URL;
        //    final String FILE_PATH = truePath.getAbsolutePath();

        byte[] bytes = file.getBytes();
        LOGGER.info("开始上传文件..."+ FILE_PATH + fileName);

//       File realFile = new File(request.getSession().getServletContext().getRealPath("/images/")+ fileName);


        Path path = Paths.get(FILE_PATH + fileName);
        Files.write(path,bytes);
        System.out.println(FILE_PATH + fileName+"***************");
        LOGGER.info("上传成功!"+fileName);
        return "https://linlisx.com/images/"+fileName;
    }


}
