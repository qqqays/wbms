
// ===================paging==================
function paging(pages, current, showId, method) {
    pagingPro(pages, current, showId, method, '');

}

function assembleParam(method, first, params) {

    var paramStr = first;

    for(var i = 0; i < params.length; i++){
        paramStr += ',\'' + params[i] + '\'';
    }

    return method + '(' + paramStr + ')';
}

function pagingPro(pages, current, showId, method, paramGroup) {

    var str = '<ul class="pagination pagination-sm no-margin pull-right">';

    if (current < 2) {
        str += '<li><a class="bg-blue disabled" href="javascript:void(0)">«</a></li>';
    } else {
        str += '<li><a onclick=' + assembleParam(method, (current - 1), paramGroup) + ' class="bg-blue">«</a></li>';
    }

    for (var i = 1; i <= pages; i++) {

        if (current == i) {
            str += '<li><a class="bg-maroon" href="javascript:void(0)">' + i + '</a></li>';
        } else {
            str += '<li><a onclick=' + assembleParam(method, i, paramGroup) + ' href="javascript:void(0)">' + i + '</a></li>';
        }
    }

    if (current >= pages) {
        str += '<li><a class="bg-blue disabled" href="javascript:void(0)">»</a></li>'
    } else {
        str += '<li><a onclick=' + assembleParam(method, (current + 1), paramGroup) + ' class="bg-blue">»</a></li>';
    }

    str += '</ul>';

    $('#' + showId).html(str);
}


// =========================base assemble=========================

function table_head(field) {
    var str = '<tr class="bg-aqua">\n';

    for(var p in field){
        str += '<th>' + field[p] + '</th>\n';
    }

    str += '<th class="bg-orange">编辑</th>\n';

    str += '</tr>';

    return str;
}

function table_body(data, field, menu, deleteFunction) {

    var str = '';

    $.each(data, function (index, info) {
        str += '<tr>';
        for(var p in field){
            str += '<td>' + info[p] + '</td>';
        }
        str += '<td><a href="/backend/'+ menu +'/' + info["id"] + '">编辑 </a> ' +
            '<a class="pull-right" href="javascript:void(0)" onclick="'+
            deleteFunction +'(\'' + info["id"] + '\')"> 删除</a></td>';
        str += '</tr>';
    });

    return str
}

function baseAssemble(data,field,menu,deleteFunction) {

    return table_head(field) + table_body(data,field,menu, deleteFunction);

}

// ====================information list assemble=====================
function assembleTable4info(json) {

    var field = {
        title:'文章标题',
        description:'描述',
        clicks:'点击数',
        publisher:'作者',
        state:'状态',
        createDate:'创建日期',
        class1:'父菜单',
        class2:'子菜单'
    }

    $('#infoList').html(baseAssemble(json,field,'p-information','delete_info'));

}

function getInfoList(page) {
    $.ajax({
        url: '/api/gains/details',
        type: 'get',
        data: {pageNumber: page},
        success: function (d, s) {
            var json = JSON.parse(d);
            assembleTable4info(json['records']);
            paging(json['pages'], json['current'], 'info-footer', 'getInfoList');
        },
        error: function (d, s) {
            console.log(d + s);
        }
    });
}

// ====================display list assemble=====================
function assembleTable4dpl(json) {

    var field = {
        pid:'pid',
        iframeUrl:'iframeUrl',
        bannerImg:'bannerImg',
        publisher:'publisher',
        state:'state'
    }

    $('#dplList').html(baseAssemble(json,field,'p-display','delete_display'));

}

function getDisplayList(page) {
    $.ajax({
        url: '/api/gains/splContents',
        type: 'get',
        data: {pageNumber: page},
        success: function (d, s) {
            var json = JSON.parse(d);
            assembleTable4dpl(json['records']);
            paging(json['pages'], json['current'], 'dpl-footer', 'getDisplayList');
        },
        error: function (d, s) {
            console.log(d + s);
        }
    });
}

// ==========================menu list assemble=====================
function assembleTable4menu(json) {

    var str = '<tr class="bg-aqua">\n' +
        '    <th>id</th>\n' +
        '    <th>栏目名</th>\n' +
        '    <th>父菜单</th>\n' +
        '    <th>url</th>\n' +
        '    <th>sort</th>\n' +
        '    <th>display</th>\n' +
        '    <th>hasSub</th>\n' +
        '    <th>bannerImg</th>\n' +
        '    <th>contentType</th>\n' +
        '    <th class="bg-orange">编辑</th>\n' +
        '</tr>';

    $.each(json, function (index, info) {
        if (info['deep'] == 0) {
            str += '<tr>\n' +
                '    <td>' + info["id"] + '</td>\n' +
                '    <td><i class="fa ' + info['icon'] + '"></i>' + info["menuName"] + '</td>\n' +
                '    <td>' + info["pid"] + '</td>\n' +
                '    <td>' + info["url"] + '</td>\n' +
                '    <td>' + info["sort"] + '</td>\n' +
                '    <td>' + info["display"] + '</td>\n' +
                '    <td>' + info["hasSub"] + '</td>\n' +
                '    <td>' + info["bannerImg"] + '</td>\n' +
                '    <td>' + info["contentType"] + '</td>\n' +
                '<td><a href="/backend/e-menu/' + info["id"] + '">编辑 </a> <a class="pull-right" href="javascript:void(0)" onclick="delete_menu(\'' + info["id"] + '\')"> 删除</a></td>' +
                '</tr>';
        }

        $.each(json, function (subIndex, subInfo) {
            if (subInfo['pid'] == info['id']) {
                str += '<tr>\n' +
                    '    <td>' + subInfo["id"] + '</td>\n' +
                    '    <td class="bg-maroon">---<i class="fa ' + info['icon'] + '"></i>' + subInfo["menuName"] + '</td>\n' +
                    '    <td>' + subInfo["pid"] + '</td>\n' +
                    '    <td>' + subInfo["url"] + '</td>\n' +
                    '    <td>' + subInfo["sort"] + '</td>\n' +
                    '    <td>' + subInfo["display"] + '</td>\n' +
                    '    <td>' + subInfo["hasSub"] + '</td>\n' +
                    '    <td>' + subInfo["bannerImg"] + '</td>\n' +
                    '    <td>' + subInfo["contentType"] + '</td>\n' +
                    '<td><a href="/backend/e-menu/' + subInfo["id"] + '">编辑 </a> <a class="pull-right" href="javascript:void(0)" onclick="delete_menu(\'' + subInfo["id"] + '\')"> 删除</a></td>' +
                    '</tr>';
                this.deep = -1;
            }
        });
    });

    $.each(json, function (index, info) {
       if(info['deep'] == 1) {
           str += '<tr>\n' +
               '    <td>' + info["id"] + '</td>\n' +
               '    <td><i class="fa ' + info['icon'] + '"></i>' + info["menuName"] + '</td>\n' +
               '    <td>' + info["pid"] + '</td>\n' +
               '    <td>' + info["url"] + '</td>\n' +
               '    <td>' + info["sort"] + '</td>\n' +
               '    <td>' + info["display"] + '</td>\n' +
               '    <td>' + info["hasSub"] + '</td>\n' +
               '    <td>' + info["bannerImg"] + '</td>\n' +
               '    <td>' + info["contentType"] + '</td>\n' +
               '<td><a href="/backend/e-menu/' + info["id"] + '">编辑 </a> <a class="pull-right" href="javascript:void(0)" onclick="delete_menu(\'' + info["id"] + '\')"> 删除</a></td>' +
               '</tr>';
       }
    });

    $('#menuList').html(str);
}

function getMenuList(page) {
    $.ajax({
        url: '/api/gains/menus',
        type: 'get',
        data: {pageNumber: page},
        success: function (d, s) {
            var json = JSON.parse(d);
            assembleTable4menu(json['records']);
            paging(json['pages'], json['current'], 'menu-footer', 'getMenuList');
        },
        error: function (d, s) {
            console.log(d + s);
        }
    });
}

// ==========================images list assemble======================
function assembleImgList(json, listId) {
    var str = '';
    $.each(json, function (index, info) {
        str +=  '<div id="' + info['id'] + '" class="item">\n' +
            '      <div class="img_show">\n' +
            '       <img  src="' + info['url'] + '"/>\n' +
            '      </div>\n' +
            '      <div class="img_title">\n' +
            '       ' + info['originName'] +
            '      </div>\n' +
            '      <div class="img_isCheck">\n' +
            '       <i class="iconfont icon-xuanzhong"></i>\n' +
            '      </div>\n' +
            '</div>';

    });

    //selectItemDiv
    $('#' + listId).html(str);

    selectImgTake.init(listId, 1);

}

function setImgUrl(id, url) {
    $('#' + id).attr('src', url);
}

function assembleImg4modal(json, listId, showId) {

    var str = '';

    $.each(json, function (index, info) {
        str +=  '<div onclick="setImgUrl(\''+ showId +'\', this.dataset.value)" id="'+ info['id'] +'" data-value="'+ info['url'] +'" class="img-item" style="background-image: url('+ info["url"] +');">\n' +
                '    <div class="widget-image-meta">'+ info["width"] +'x'+ info["height"] +'</div>\n' +
                '</div>';
    });

    $('#' + listId).html(str);

}

function getImgList(page, dir, pagingArea, aFun, funName, listId, showId) {
    $.ajax({
        url: '/api/images/' + dir,
        type: 'get',
        data: {pageNumber:page},
        success: function (d, s) {
            var json = JSON.parse(d);

            var paramGroup = new Array(dir, pagingArea, listId, showId);

            aFun(json['records'], listId, showId);

            pagingPro(json['pages'], json['current'], pagingArea, funName, paramGroup);

        },
        error: function (d, s) {
            console.log(d + s);
        }
    });
}

function getImgList4edit(page, dir, pagingArea, listId) {

    getImgList(page, dir, pagingArea, assembleImgList, 'getImgList4edit', listId);
}

function getImgList4Modal(page, dir, pagingArea, listId, showId) {

    getImgList(page, dir, pagingArea, assembleImg4modal, 'getImgList4Modal', listId, showId);
}

// ========================case list assemble==================
function assembleTable4case(json) {

    var field = {
        name:'name',
        description:'description',
        img:'img',
        class1:'类1',
        class2:'class2'
    }

    $('#caseList').html(baseAssemble(json,field,'e-case','delete_case'));

}

function getCaseList(page) {
    $.ajax({
        url: '/api/gains/cases',
        type: 'get',
        data: {pageNumber: page},
        success: function (d, s) {
            var json = JSON.parse(d);
            assembleTable4case(json['records']);
            paging(json['pages'], json['current'], 'case-footer', 'getCaseList');
        },
        error: function (d, s) {
            console.log(d + s);
        }
    });
}

// ========================product assemble=======================
function assembleTable4product(json) {
    var filed = {
        name:'name',
        description:'description',
        img:'img',
        class1:'类1',
        class2:'class2'
    }

    $('#productList').html(baseAssemble(json,filed,'e-product','delete_product'));

}

function getProductList(page) {
    $.ajax({
        url: '/api/gains/products',
        type: 'get',
        data: {pageNumber: page},
        success: function (d, s) {
            var json = JSON.parse(d);
            assembleTable4product(json['records']);
            paging(json['pages'], json['current'], 'product-footer', 'getProductList');
        },
        error: function (d, s) {
            console.log(d + s);
        }
    });
}

// ===========================log assemble=========================

function assembleTable4log(json) {

    var field = {
        id:'id',
        user:'user',
        dateTime:'dateTime',
        ip:'ip',
        api:'api',
        reqMethod:'reqMethod',
        classMethod:'classMethod',
        note:'note'

    };

    $('#logList').html(baseAssemble(json,field,'logs','delete_log'));

}

function getLogList(page) {
    $.ajax({
        url: '/api/gains/logs',
        type: 'get',
        data: {pageNumber: page},
        success: function (d, s) {
            var json = JSON.parse(d);
            assembleTable4log(json['records']);
            paging(json['pages'], json['current'], 'log-footer', 'getLogList');
        },
        error: function (d, s) {
            console.log(d + s);
        }
    });
}
