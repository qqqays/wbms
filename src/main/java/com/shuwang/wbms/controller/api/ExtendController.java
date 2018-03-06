package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.common.util.SysCmdUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Some controllers I do not know where should placed.
 * <p>
 * Created by Q-ays.
 * whosqays@gmail.com
 * 03-06-2018 13:16
 */
@RestController
@RequestMapping("/api/extend")
public class ExtendController {

    @PostMapping("/backupDatabase")
    public String backupDatabase(@RequestParam(defaultValue = "backup.sql") String filename) {
        return SysCmdUtil.backupDatebase(filename);
    }
}
