
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

// ====================information list assemble=====================
function assembleTable4info(json) {
    var str = '<tr class="bg-aqua">\n' +
        '    <th>文章标题</th>\n' +
        '    <th>描述</th>\n' +
        '    <th>点击数</th>\n' +
        '    <th>作者</th>\n' +
        '    <th>状态</th>\n' +
        '    <th>创建日期</th>\n' +
        '    <th>父菜单</th>\n' +
        '    <th>子菜单</th>\n' +
        '    <th class=bg-orange>编辑</th>\n' +
        '</tr>';

    $.each(json, function (index, info) {
        str += '<tr>' +
            '<td>' + info["title"] + '</td>' +
            '<td>' + info["description"] + '</td>' +
            '<td>' + info["clicks"] + '</td>' +
            '<td>' + info["publisher"] + '</td>' +
            '<td>' + info["state"] + '</td>' +
            '<td>' + info["createDate"] + '</td>' +
            '<td>' + info["class1"] + '</td>' +
            '<td>' + info["class2"] + '</td>' +
            '<td><a href="/backend/p-information/' + info["id"] + '">编辑 </a><a class="pull-right" href="javascript:void(0)" onclick="delete_info(\'' + info["id"] + '\')"> 删除</a></td>' +
            '</tr>';
    });

    $('#infoList').html(str);

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
    var str =   '<tr class="bg-aqua">\n' +
        // '    <th>id</th>\n' +
        '    <th>pid</th>\n' +
        '    <th>iFrameUrl</th>\n' +
        '    <th>bannerImg</th>\n' +
        '    <th>作者</th>\n' +
        '    <th>状态</th>\n' +
        // '    <th>创建日期</th>\n' +
        '    <th class="bg-orange">编辑</th>\n' +
        '</tr>';

    $.each(json, function (index, info) {
        str += '<tr>' +
            // '<td>' + info["id"] + '</td>' +
            '<td>' + info["pid"] + '</td>' +
            '<td>' + info["iframeUrl"] + '</td>' +
            '<td>' + info["bannerImg"] + '</td>' +
            '<td>' + info["publisher"] + '</td>' +
            '<td>' + info["state"] + '</td>' +
            // '<td>' + info["createTime"] + '</td>' +
            '<td><a href="/backend/p-display/' + info["id"] + '">编辑 </a> <a class="pull-right" href="javascript:void(0)" onclick="delete_info(\'' + info["id"] + '\')"> 删除</a></td>' +
            '</tr>';
    });

    $('#dplList').html(str);

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
    var str =   '<tr class="bg-aqua">\n' +
        '    <th>name</th>\n' +
        '    <th>description</th>\n' +
        '    <th>img</th>\n' +
        '    <th>class1</th>\n' +
        '    <th>class2</th>\n' +
        '    <th class="bg-orange">编辑</th>\n' +
        '</tr>';

    $.each(json, function (index, info) {
        str += '<tr>' +
            '<td>' + info["name"] + '</td>' +
            '<td>' + info["description"] + '</td>' +
            '<td>' + info["img"] + '</td>' +
            '<td>' + info["class1"] + '</td>' +
            '<td>' + info["class2"] + '</td>' +
            '<td><a href="/backend/e-case/' + info["id"] + '">编辑 </a> <a class="pull-right" href="javascript:void(0)" onclick="delete_case(\'' + info["id"] + '\')"> 删除</a></td>' +
            '</tr>';
    });

    $('#caseList').html(str);

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
    var str =   '<tr class="bg-aqua">\n' +
        '    <th>name</th>\n' +
        '    <th>description</th>\n' +
        '    <th>img</th>\n' +
        '    <th>class1</th>\n' +
        '    <th>class2</th>\n' +
        '    <th class="bg-orange">编辑</th>\n' +
        '</tr>';

    $.each(json, function (index, info) {
        str += '<tr>' +
            '<td>' + info["name"] + '</td>' +
            '<td>' + info["description"] + '</td>' +
            '<td>' + info["img"] + '</td>' +
            '<td>' + info["class1"] + '</td>' +
            '<td>' + info["class2"] + '</td>' +
            '<td><a href="/backend/e-product/' + info["id"] + '">编辑 </a> <a class="pull-right" href="javascript:void(0)" onclick="delete_product(\'' + info["id"] + '\')"> 删除</a></td>' +
            '</tr>';
    });

    $('#productList').html(str);

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