package com.sast.atSast.controller;

import com.alibaba.fastjson.JSON;
import com.sast.atSast.model.Contest;
import com.sast.atSast.model.Stage;
import com.sast.atSast.service.impl.ContestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContestController {

    @Autowired
    private ContestServiceImpl contestService;

    @ResponseBody
    @PostMapping("/admin/createcontest")
    public void createContest(@RequestBody String data){
        Contest contest = JSON.parseObject(data, Contest.class);
        List<Stage> stages = JSON.parseArray(contest.getStages(), Stage.class);
		contestService.createContest(contest);
        for (Stage stage : stages) {
            contestService.createStage(stage);
        }
    }

    @ResponseBody
    @PostMapping("/admin/uploadlink")
    public void addpushLink(@RequestParam("contestId") int contestId,@RequestParam("pushLink") String pushLink){
        contestService.updatepushLink(contestId, pushLink);
    }

}
