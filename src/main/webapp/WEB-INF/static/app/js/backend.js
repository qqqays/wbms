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
