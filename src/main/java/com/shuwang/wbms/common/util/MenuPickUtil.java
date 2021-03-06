package com.shuwang.wbms.common.util;

import com.shuwang.wbms.common.enums.DisplayEnum;
import com.shuwang.wbms.entity.MenuEntity;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Q-ays.
 * 12-10-2017 23:21
 */
public class MenuPickUtil {

    public static List<MenuEntity> pickMenu(List<MenuEntity> list, DisplayEnum dpl, String act, HttpServletRequest request) {

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
                    request.setAttribute("activeMenu", me.getMenuName());
                    if (StringUtils.isNotBlank(me.getBannerImg()))
                        request.setAttribute("bannerImg", me.getBannerImg());
                } else {
                    me.setActive(false);
                }

                rList.add(me);
            }
        }

        return rList;
    }

    public static List<MenuEntity> topMenus(List<MenuEntity> list, String act, HttpServletRequest request) {
        return pickMenu(list, DisplayEnum.TOP, act, request);
    }

    public static List<MenuEntity> topSubMenus(List<MenuEntity> list, String act, String pId, HttpServletRequest request) {
        List<MenuEntity> rList = new ArrayList<>();

        for (MenuEntity me : list) {

            if (me.getPid().equals(pId)) {
                rList.add(me);
            }
        }

        return pickMenu(rList, DisplayEnum.TOP, act, request);
    }
}
