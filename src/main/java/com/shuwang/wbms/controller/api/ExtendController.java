package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.common.util.SysCmdUtil;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/backup-database")
    public String backupDatabase(@RequestParam(defaultValue = "backup.sql") String filename) {
        return SysCmdUtil.backupDatabase(filename);
    }

    @GetMapping("/lookup-backup")
    public String lookup() {
        return SysCmdUtil.lookupDB();
    }

    @PostMapping("/recovery")
    public String recovery(@RequestParam(defaultValue = "backup.sql") String filename) {
        return SysCmdUtil.recoverDatabase(filename);
    }
}
