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

function pushImg(id, alt, title, class1, showId) {

    var formData = new FormData();

    var $x = $('#' + id);


    for(var i = 0; i < $x[0].files.length; i++) {
        formData.append('files', $x[0].files[i]);
    }

    formData.append('alt', alt);
    formData.append('title', title);
    formData.append('class1', class1);

    $.ajax({
        url:'/api/images',
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
