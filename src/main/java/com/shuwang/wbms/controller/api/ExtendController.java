package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.common.util.DBUtil;
import com.shuwang.wbms.common.util.FileUtil;
import org.springframework.web.bind.annotation.*;

/**
 * Some controllers I do not know where should placed.
 * <p>
 * Created by Q-ays.
 * whosqays@gmail.com
 * 03-06-2018 13:16
 */
@RestController
@RequestMapping("/api/extend/database")
public class ExtendController {

    @PostMapping("/backup")
    public String backupDatabase(@RequestParam(defaultValue = "backup.sql") String filename) {
        return DBUtil.backupDatabase(filename);
    }

    @GetMapping("/lookup")
    public String lookup() {
        return DBUtil.lookupDBFile();
    }

    @PostMapping("/recovery")
    public String recovery(@RequestParam(defaultValue = "backup.sql") String filename) {
        return DBUtil.recoverDatabaseByAbsolute(filename);
    }

    @PostMapping("/delete")
    public String delete(String filename){
        if (filename.replace("\\", "/").startsWith(FileUtil.getBackPath())) {
            return FileUtil.deleteFile(filename) + " delete";
        } else {
            return "Can not operate the path you selected!";
        }
    }
}
