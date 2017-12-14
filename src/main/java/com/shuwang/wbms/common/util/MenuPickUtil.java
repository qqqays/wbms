package com.shuwang.wbms.common.util;

import com.shuwang.wbms.common.enums.DisplayEnum;
import com.shuwang.wbms.entity.MenuEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Q-ays.
 * 12-10-2017 23:21
 */
public class MenuPickUtil {

    public static List<MenuEntity> pickMenu(List<MenuEntity> list, DisplayEnum dpl, String act) {

        List<MenuEntity> rList = new ArrayList<>();

        Iterator<MenuEntity> it = list.iterator();

        boolean canSetActive = true;

        while (it.hasNext()) {
            MenuEntity me = it.next();
            if ((me.getDisplay() & dpl.getDpl()) == dpl.getDpl()) {

                if (act.equals("") && canSetActive) {
//                    me.setActive(true); //如果未选择子菜单则不设置标记活动菜单
                    canSetActive = false;
                } else if (me.getId().equals(act)) {
                    me.setActive(true);
                }else {
                    me.setActive(false);
                }

                rList.add(me);
            }
        }

        return rList;
    }

    public static List<MenuEntity> topMenus(List<MenuEntity> list, String act) {
        return pickMenu(list, DisplayEnum.TOP, act);
    }

    public static List<MenuEntity> topSubMenus(List<MenuEntity> list, String act, String pId) {
        List<MenuEntity> rList = new ArrayList<>();

        Iterator<MenuEntity> it = list.iterator();

        while (it.hasNext()) {
            MenuEntity me = it.next();

            if (me.getPid().equals(pId)) {
                rList.add(me);
            }
        }
        return pickMenu(rList, DisplayEnum.TOP, act);
    }
}
