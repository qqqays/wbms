package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.common.util.DBUtil;
import com.shuwang.wbms.common.util.FileUtil;
import com.shuwang.wbms.common.util.SKTUtil;
import org.springframework.web.bind.annotation.*;

/**
 * Some controllers I do not know where should placed.
 * <p>
 * Created by Q-ays.
 * whosqays@gmail.com
 * 03-06-2018 13:16
 */
@RestController
@RequestMapping("/api/extend/")
public class ExtendController{

//    ================database operating==================
    @PostMapping("/database/backup")
    public String backupDatabase(@RequestParam(defaultValue = "backup.sql") String filename) {
        return DBUtil.backupDatabase(filename);
    }

    @GetMapping("/database/lookup")
    public String lookup() {
        return DBUtil.lookupDBFile();
    }

    @PostMapping("/database/recovery")
    public String recovery(@RequestParam(defaultValue = "backup.sql") String filename) {
        return DBUtil.recoverDatabaseByAbsolute(filename);
    }

    @PostMapping("/database/delete")
    public String delete(String filename){
        if (filename.replace("\\", "/").startsWith(FileUtil.getBackPath())) {
            return FileUtil.deleteFile(filename) + " delete";
        } else {
            return "Can not operate the path you selected!";
        }
    }
}
