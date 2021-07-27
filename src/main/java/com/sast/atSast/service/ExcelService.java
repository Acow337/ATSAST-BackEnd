package com.sast.atSast.service;

import com.sast.atSast.pojo.JugdeTemp;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Acow337
 * @Date: 2021/07/19/10:10
 * @Description:
 */
public interface ExcelService {
    //根据比赛ID导出比赛结果的EXCEL并返回URL
    String exportresult(Long contestId) throws IOException;

    String importresult(MultipartFile file, long contestId);

    String generatelist(long contestId) throws IOException;

    //导入名单报名
    String uploadlist(long contestId, MultipartFile file);

    List<JugdeTemp> importjudge(MultipartFile file);
}
