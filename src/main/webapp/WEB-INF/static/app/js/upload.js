// 公共 ajax
function generalAjax(url, type, data, tip) {

    var sure = true;

    if (tip != '')
        sure = confirm("确认" + tip + "?");

    if (sure)
        $.ajax({
            url: url,
            type: type,
            data: data,
            success: function (d, s) {
                alert(d);
            },
            error: function (d, s) {
                console.log(d + s);
            }
        });
}

function generalAjaxPro(url, type, data) {

    var tip = '操作';
    if (type.toUpperCase() == 'PUT')
        tip = '修改';
    if (type.toUpperCase() == 'POST')
        tip = '增加';
    if (type.toUpperCase() == 'DELETE')
        tip = '删除';

    generalAjax(url, type, data, tip);

}

function generalAjaxSimple(url, type, tip) {
    var sure = confirm("确认" + tip + "?");
    if (sure)
        $.ajax({
            url: url,
            type: type,
            data: {},
            success: function (d, s) {
                alert(d);
            },
            error: function (d, s) {
                console.log(d + s);
            }
        });
}

function general_post(url, data) {
    generalAjax(url, 'POST', data, '新增');
}

function general_put(url, data) {
    generalAjax(url, 'PUT', data, '修改');
}

function general_delete(url) {
    generalAjaxSimple(url, 'DELETE', '删除');
    window.location.reload();
}

function generalAjax4img(formData, class1, showId) {
    var url = '/api/images/system';

    if(class1 != '')
        url = '/api/images/' + class1;

    $.ajax({
        url: url,
        type: 'POST',
        contentType: false,
        processData: false,
        data: formData,
        success: function (d, s) {
            console.log(d);
            if (showId != '') {
                var json = JSON.parse(d);

                var $show = $('#' + showId);

                $.each(json, function (index, info) {
                    $show.attr('src', info);
                });
            }
        },
        error: function (d, s) {
            console.log(d + s);
        }
    });
}

// =======================================================================common ajax above

// 修改 系统 seo
function modify_system_seo(id, title, keywords, description, author) {

    var url = '/api/upload/seo';

    var data = {
        id: id,
        pid: '',
        pageTitle: title,
        keywords: keywords,
        description: description,
        author: author
    };

    general_put(url, data);
}

// 修改 系统配置
function modify_system_config(id, webName, icon, logo, sharesName, sharesCode, email, phone, licensing) {

    var url = '/api/upload/sysConfig';

    var data = {
        id: id,
        webName: webName,
        icon: icon,
        logo: logo,
        sharesName: sharesName,
        sharesCode: sharesCode,
        email: email,
        phone: phone,
        licensing: licensing
    };

    general_put(url, data);
}

//put 修改菜单， post 新增菜单
function operate_menu(id, menuName, pid, url, icon, sort, deep, display, hasSub, bannerImg, contentType, type) {
    var up_url = "/api/upload/menu";

    var data = {
        id: id,
        menuName: menuName,
        pid: pid,
        url: url,
        icon: icon,
        sort: sort,
        deep: deep,
        display: display,
        hasSub: hasSub,
        bannerImg: bannerImg,
        contentType: contentType
    };

    generalAjaxPro(up_url, type, data);
}


// 删除 菜单
function delete_menu(id) {
    var url = '/api/upload/menu/' + id;
    general_delete(url)
}

// 新增 展示页面
function push_display(pid, content, iframeUrl, bannerImg, publisher, state) {

    var url = '/api/upload/display';

    var data = {
        pid: pid,
        content: content,
        iframeUrl: iframeUrl,
        bannerImg: bannerImg,
        publisher: publisher,
        state: state
    };

    general_post(url, data);
}

// 修改 展示页面
function update_display(id, pid, content, iframeUrl, bannerImg, publisher, state) {

    var url = '/api/upload/display';

    var data = {
        id: id,
        pid: pid,
        content: content,
        iframeUrl: iframeUrl,
        bannerImg: bannerImg,
        publisher: publisher,
        state: state
    };

    general_put(url, data);
}

// 删除 展示页面
function delete_display(id) {
    var url = '/api/upload/display/' + id;
    general_delete(url);
}

// 新增 文章
function push_info(title, description, content, clicks, publisher, state, updateDate, createDate, bannerImg, coverImg, class1, class2) {

    var url = '/api/upload/info';

    var data = {
        title: title,
        description: description,
        content: content,
        clicks: parseInt(clicks),
        publisher: publisher,
        state: state,
        updateDate: updateDate,
        createDate: createDate,
        bannerImg: bannerImg,
        coverImg: coverImg,
        class1: class1,
        class2: class2
    };

    general_post(url, data);
}

// 修改 文章
function update_info(id, title, description, content, clicks, publisher, state, updateDate, createDate, bannerImg, coverImg, class1, class2) {

    var url = '/api/upload/info';

    var data = {
        id: id,
        title: title,
        description: description,
        content: content,
        clicks: parseInt(clicks),
        publisher: publisher,
        state: state,
        updateDate: updateDate,
        createDate: createDate,
        bannerImg: bannerImg,
        coverImg: coverImg,
        class1: class1,
        class2: class2
    };

    general_put(url, data);
}

// 删除 文章
function delete_info(id) {

    var url = '/api/upload/info/' + id;

    general_delete(url);
}

// 上传图片
function pushImg(id, alt, title, class1, showId) {

    var formData = new FormData();

    var $x = $('#' + id);

    formData.append('alt', alt);
    formData.append('title', title);


    for (var i = 0; i < $x[0].files.length; i++) {

        var file = $x[0].files[i];

        var reader = new FileReader;

        formData.append('files', file);

        reader.onload = function () {

            var image = new Image();

            image.onload = function () {
                formData.append('width', this.width);
                formData.append('height', this.height);

                generalAjax4img(formData, class1, showId);//上传图片ajax
            };
            image.src = this.result;
        };

        reader.readAsDataURL(file);
    }
}

// =====================修改图片信息====================
function put_img(id, alt, title) {

    var url = '/api/images/' + id;

    var data = {
        alt:alt,
        title:title
    };

    generalAjaxPro(url, 'PUT', data);
}

function delete_img(id) {
    var url = '/api/images/' + id;

    general_delete(url);
}

//增加案例，  修改案例
function operate_case(id, name, description, img, class1, class2, contents, type) {
    
    var url = '/api/upload/case';
    
    var data = {
        id: id,
        name:name,
        description:description,
        img:img,
        class1:class1,
        class2:class2,
        contents:contents
    };

    generalAjaxPro(url, type, data);

}

//删除案例
function delete_case(id) {
    var url = '/api/upload/case/' + id;

    general_delete(url);
}

//增加产品， 修改产品
function operate_product(id, name, description, img, class1, class2,class3, page, type) {
   var url = '/api/upload/product';


    var data = {
        id: id,
        name:name,
        description:description,
        img:img,
        class1:class1,
        class2:class2,
        class3:class3,
        page:page
    };

   generalAjaxPro(url, type, data);

}

//删除 产品
function delete_product(id) {
    var url = '/api/upload/product/' + id;

    general_delete(url);
}

//新增用户, 修改用户
function operate_user(userName, password, state, createTime, desc, avadar, type) {
    var url = '/api/manager/users';
    
    var data = {
        userName:userName,
        password:password,
        state:state,
        createTime:createTime,
        desc:desc,
        avadar:avadar
    };
    
    generalAjaxPro(url,type,data);
}

// 删除用户
function delete_user(username) {
    var url = '/api/manager/users/' + username;
    general_delete(url);
}

// 用户添加角色
function addRole4User(roleList, username, type) {

    var json = [];

    for(var i = 0; i < roleList.length; i ++){
        var data = {
            userName:username,
            roleName:roleList[i]
        };

        json.push(data);
    }

    $.ajax({
        url: "/api/manager/user-role",
        type: "POST",
        contentType : 'application/json;charset=utf-8', //设置请求头信息
        dataType:"json",
        data: JSON.stringify(json),    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
        // data: $.toJSON(json),            //将Json对象序列化成Json字符串，toJSON()需要引用jquery.json.min.js
        success: function(data){
            alert(data);
        },
        error: function(res){
            alert(res.responseText);
        }
    });

}

// 新增角色
function operate_role(roleName, desc, state, createTime, type) {
    var url = '/api/manager/role';
    
    var data = {
        roleName:roleName,
        desc:desc,
        state:state,
        createTime:createTime
    };
    
    generalAjaxPro(url, type, data);
}

function delete_role(role) {
    var url = '/api/manager/role/' + 'role';

    general_delete(url);
}

// 新增权限
function operate_auth(authName, desc, state, type) {
    var url = '/api/manager/authorities';

    var data = {
        authName:authName,
        desc:desc,
        state:state
    };

    generalAjaxPro(url, type, data);
}

function delete_auth(authorities) {
    var url = '/api/manager/authorities/' + authorities;

    general_delete(url);
}

// 修改个人信息
function update_profile(userName, desc, avadar, type) {
    var url = '/api/profile/me';

    var data = {
        userName:userName,
        desc:desc,
        avadar:avadar
    };

    generalAjaxPro(url, type, data);
}

// 修改密码

function update_password(origin, now, type) {
    var url = '/api/profile/password';

    var data = {
        originPwd:origin,
        newPwd:now
    };

    generalAjaxPro(url, type, data);
}