/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 11.
 * Time: 오전 10:04
 * To change this template use File | Settings | File Templates.
 */

/* image lightbox effect. */
var activityIndicatorOn = function() {
    $( '<div id="imagelightbox-loading"><div></div></div>' ).appendTo( 'body' );
},
activityIndicatorOff = function() {
    $( '#imagelightbox-loading' ).remove();
},
overlayOn = function() {
    $( '<div id="imagelightbox-overlay"></div>' ).appendTo( 'body' );
},
overlayOff = function() {
    $( '#imagelightbox-overlay' ).remove();
};

