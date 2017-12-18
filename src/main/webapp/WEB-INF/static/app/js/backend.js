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
