/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
    // config.filebrowserImageUploadUrl = "api/upload2directory"
    // config.filebrowser = "api/upload2directory";
    // config.removeDialogTabs = 'image:advanced;link:advanced';
    // config.callFunction()
    // filebrowserImageBrowseUrl
    // config.filebrowserImage2BrowseUrl = "/api/images";
    // The final output will also reflect this setting, including the <body> contents only if this setting is disabled.
    config.fullPage= true;
    // set editor html no display auto filter
    // config.allowedContent= true;
    config.toolbarCanCollapse = true;
    // config.entities = true;
    config.forcePasteAsPlainText =false;
    config.startupMode ='source';
    // config.startupOutlineBlocks = true;
    config.shiftEnterMode = CKEDITOR.ENTER_P;
    config.enterMode = CKEDITOR.ENTER_BR;
};
