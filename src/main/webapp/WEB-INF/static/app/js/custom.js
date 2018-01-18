// =============================common============================
function isnull(value) {
    if(value == '' || value == null || value == undefined)
        return true;
    else 
        return false;
}

function eleIsNull(eleId) {
    var eleVal = $('#' + eleId).val();

    return isnull(eleVal)
}

// ==========================qr-code=================
var fu = false;

var fa = true;


function show_code() {

    setTimeout(function () {
        $('#qr-code').removeClass('infinite');
        $('#qr-code').removeClass('tada');
        $('#qr-code').removeClass('hinge');
        $('#qr-code').addClass('zoomOut');
    },1000);

    setTimeout(function () {
        $('#qr-code').attr('src', '/images/qr-code-sw.jpg');
        fu = true;
        $('#qr-code').removeClass('zoomOut');
        $('#qr-code').addClass('zoomIn');
    }, 2000);
}

function qr_code() {
    $('#qr-code').mouseenter(function () {
        if(!fu){
            show_code();
        }
    });

    $('#qr-code').click(function () {
        if(fu) {
            $('#qr-code').removeClass('zoomIn');
            $('#qr-code').addClass('hinge');
            setTimeout(function () {
                $('#qr-code').removeClass('hinge');
                $('#qr-code').addClass('tada');
                $('#qr-code').addClass('infinite');
                $('#qr-code').attr('src', '/images/scan.png');
                fu = false;
                fa = false;
            },2000);
        }
    });
}

// ===============iframe===============
function setIframeHeight(iframe) {
    if (iframe) {
        var iframeWin = iframe.contentWindow /*|| iframe.contentDocument.parentWindow*/;
        if (iframeWin.document.body) {
            iframe.height = iframeWin.document.body.scrollHeight;/*iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;*/
        }
    }
};

$('document').ready(function () {
    // ================qr code=================
    qr_code();
    $('#qr-code').addClass('animated');
    $(window).scroll(function () {

        if($('#qr-code').position().top - window.scrollY < 860 && fa && !fu){
            show_code();
            fa = false;
        }

        if($('#qr-code').position().top - window.scrollY > 1200)
            fa = true;
    });

    // ================shares code ===================
    if(window.innerWidth < 350) {
        $('.shares-code').hide();
    }

    // ==================nav-bar========================
    $('.navbar-toggle').click(function () {
        $('#nav-wrapper').toggleClass('toggled');
    });

    // ===============iframe===============
    window.setInterval("setIframeHeight(document.getElementById('myFrame'));", 1000);

    // =================wow===================
    new WOW().init();

});

