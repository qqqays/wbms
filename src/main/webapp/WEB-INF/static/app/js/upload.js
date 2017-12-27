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
