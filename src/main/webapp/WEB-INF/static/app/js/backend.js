// 修改 系统 seo
function modify_system_seo(id, title, keywords, description, author){
    $.ajax({
        url: '/backend/seo',
        type: 'PUT',
        data: {id: id, pid: '', pageTitle: title, keywords: keywords, description: description, author: author},
        success:function (d, s) {
            alert(d);
            // console.log(d);
        },
        error:function(d, s){
            console.log(d + s);
        }
    });
}

// 修改 系统配置
function modify_system_config(id, webName, icon, logo, sharesName, sharesCode, email, phone, licensing) {
    $.ajax({
        url: '/backend/sysConfig',
        type: 'PUT',
        data:{id:id,webName:webName, icon: icon, logo: logo, sharesName: sharesName, sharesCode: sharesCode, email: email, phone : phone, licensing: licensing},
        success:function (d, s) {
            alert(d);
        },
        error:function (d, s) {
            console.log(d + s);
        }
    });
}

// 新增 展示页面
function push_display(pid, content, iframeUrl, bannerImg, publisher, state) {

    $.ajax({
        url:'/api/upload/display',
        type:'post',
        data:{pid:pid, content: content, iframeUrl: iframeUrl, bannerImg: bannerImg, publisher:publisher, state:state},
        success:function (d, s) {
            alert(d);
        },
        error:function (d, s) {
            console.log(d + s);
        }
    });
}

// 修改 展示页面
function update_display(id, pid, content, iframeUrl, bannerImg, publisher, state) {

    $.ajax({
        url:'/api/upload/display',
        type:'put',
        data:{id:id, pid:pid, content: content, iframeUrl: iframeUrl, bannerImg: bannerImg, publisher:publisher, state:state},
        success:function (d, s) {
            alert(d);
        },
        error:function (d, s) {
            console.log(d + s);
        }
    });
}

// 删除 展示页面
function delete_display(id) {
    $.ajax({
        url:'/api/upload/display/' + id,
        type:'delete',
        data:{},
        success:function (d, s) {
            alert(d);
        },
        error:function (d, s) {
            console.log(d + s);
        }
    });
}

// 新增 文章
function push_info(title, description, content, clicks, publisher, state, updateDate, createDate, bannerImg, coverImg, class1, class2) {

    $.ajax({
        url:'/api/upload/info',
        type:'post',
        data:{title:title, description: description, content: content, clicks: parseInt(clicks), publisher: publisher, state: state, updateDate: updateDate, createDate: createDate, bannerImg: bannerImg, coverImg: coverImg, class1: class1, class2:class2},
        success:function (d, s) {
            alert(d);
        },
        error:function (d, s) {
            console.log(d + s);
        }
    });
}

// 修改 文章
function update_info(id, title, description, content, clicks, publisher, state, updateDate, createDate, bannerImg, coverImg, class1, class2) {
    $.ajax({
        url:'/api/upload/info',
        type:'put',
        data:{id: id, title:title, description: description, content: content, clicks: parseInt(clicks), publisher: publisher, state: state, updateDate: updateDate, createDate: createDate, bannerImg: bannerImg, coverImg: coverImg, class1: class1, class2:class2},
        success:function (d, s) {
            alert(d);
        },
        error:function (d, s) {
            console.log(d + s);
        }
    });
}

// 删除 文章
function delete_info(id) {
    $.ajax({
        url:'/api/upload/info/' + id,
        type:'delete',
        data:{},
        success:function (d, s) {
            alert(d);
        },
        error:function (d, s) {
            console.log(d + s);
        }
    });
}

// 上传图片
function pushImg(id, alt, title, class1, showId) {

    var formData = new FormData();

    var $x = $('#' + id);


    for(var i = 0; i < $x[0].files.length; i++) {
        formData.append('files', $x[0].files[i]);
    }

    formData.append('alt', alt);
    formData.append('title', title);

    $.ajax({
        url:'/api/images/' + class1,
        type:'POST',
        contentType: false,
        processData:false,
        data:formData,
        success:function (d, s) {
            console.log(d);
            if(showId != '') {
            var json = JSON.parse(d);

                var $show = $('#' + showId);

                $.each(json, function (index, info) {
                    $show.attr('src',info);
                });
            }
        },
        error:function (d, s) {
            console.log(d + s);
        }
    });
}

// ====================information list assemble=====================
function assembleTable4info(json) {
    var str =   '<tr class="bg-aqua">\n' +
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
        str +=  '<tr>' +
                '<td>'+ info["title"] +'</td>' +
                '<td>'+ info["description"] +'</td>' +
                '<td>'+ info["clicks"] +'</td>' +
                '<td>'+ info["publisher"] +'</td>' +
                '<td>'+ info["state"] +'</td>' +
                '<td>'+ info["createDate"] +'</td>' +
                '<td>'+ info["class1"] +'</td>' +
                '<td>'+ info["class2"] +'</td>' +
                '<td><a href="/backend/p-information/'+ info["id"] +'">编辑 </a><a href="javascript:void(0)" onclick="delete_info(\''+ info["id"] +'\')"> 删除</a></td>' +
                '</tr>';
    });

    $('#infoList').html(str);

}

function getINfoList() {
    $.ajax({
        url:'/api/details',
        type:'get',
        data:{},
        success:function (d, s) {
            var json = JSON.parse(d);
            assembleTable4info(json['records']);
        },
        error:function (d, s) {
            console.log(d+s);
        }
    });
}

// ====================display list assemble=====================
function assembleTable4dpl(json) {
    var str =   '            <tr class="bg-aqua">\n' +
                '                <th>id</th>\n' +
                '                <th>pid</th>\n' +
                '                <th>iFrameUrl</th>\n' +
                '                <th>bannerImg</th>\n' +
                '                <th>作者</th>\n' +
                '                <th>状态</th>\n' +
                '                <th>创建日期</th>\n' +
                '                <th class="bg-orange">编辑</th>\n' +
                '            </tr>'

    $.each(json, function (index, info) {
        str +=  '<tr>' +
                '<td>'+ info["id"] +'</td>' +
                '<td>'+ info["pid"] +'</td>' +
                '<td>'+ info["iframeUrl"] +'</td>' +
                '<td>'+ info["bannerImg"] +'</td>' +
                '<td>'+ info["publisher"] +'</td>' +
                '<td>'+ info["state"] +'</td>' +
                '<td>'+ info["createTime"] +'</td>' +
                '<td><a href="/backend/p-display/'+ info["id"] +'">编辑 </a> <a href="javascript:void(0)" onclick="delete_info(\''+ info["id"] +'\')"> 删除</a></td>' +
                '</tr>';
    });

    $('#dplList').html(str);

}

function getDisplayList(page) {
    $.ajax({
        url:'/api/splContents',
        type:'get',
        data:{page: page},
        success:function (d, s) {
            var json = JSON.parse(d);
            assembleTable4dpl(json['records']);
        },
        error:function (d, s) {
            console.log(d+s);
        }
    });
}