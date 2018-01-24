/*
 * bumpyText 1.1 - jQuery plugin for making characters in a text element bumpy.
 * http://www.alexanderdickson.com/projects/jquery-plugins/bumpytext/
 *
 * Dependicies: jQuery Easing Plugin (http://gsgd.co.uk/sandbox/jquery/easing/)
 *
 * Copyright (c) 2009 Alex Dickson
 * Licensed under the MIT licenses.
 * See website for more info.
 *
 * Date: 2009-08-30 09:03:00 +1000 (Sunday, 23 Aug 2009)
 */

(function($) {
    $.fn.bumpyText = function(options) {
        var defaults = {
            bounceHeight: '1.3em',
            bounceUpDuration: 500,
            bounceDownDuration: 700,
        };
        var options = $.extend(defaults, options);
        return this.each(function() {
            var obj = $(this);
            if (obj.text() !== obj.html()) {
                return
            };
            var text = obj.text();
            var newMarkup = '';
            for (var i = 0; i <= text.length; i++) {
                var character = text.slice(i, i + 1);
                newMarkup += ($.trim(character)) ? '<span class="bumpy-char">' + character + '</span>' : character
            }
            obj.html(newMarkup);
            obj.find('span.bumpy-char').each(function() {
                $(this).mouseover(function() {
                    $(this).animate({
                        bottom: options.bounceHeight
                    }, {
                        queue: false,
                        duration: options.bounceUpDuration,
                        easing: 'easeOutCubic',
                        complete: function() {
                            $(this).animate({
                                bottom: 0
                            }, {
                                queue: false,
                                duration: options.bounceDownDuration,
                                easing: 'easeOutBounce'
                            })
                        }
                    })
                })
            })
        })
    }
})(jQuery);