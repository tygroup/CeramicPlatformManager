/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights
 *          reserved. For licensing, see LICENSE.md or
 *          http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// 界面语言，默认为 'en'
    config.language = 'zh-cn';

	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.image_previewText = ' ';
	config.filebrowserImageUploadUrl = "/NationalAgingManager/ckUpload_imgUpload.action";
	//是否强制复制来的内容去除格式 plugins/pastetext/plugin.js
	config.forcePasteAsPlainText =false//不去除
	//是否使用等标签修饰或者代替从word文档中粘贴过来的内容 plugins/pastefromword/plugin.js
	config.pasteFromWordKeepsStructure = false;
	//从word中粘贴内容时是否移除格式 plugins/pastefromword/plugin.js
	config.pasteFromWordRemoveStyle = false
	config.pasteFromWordRemoveFontStyles = false;
	config.enterMode = CKEDITOR.ENTER_BR;  
	config.shiftEnterMode = CKEDITOR.ENTER_P;
	//config.resize_enabled = false;
	config.width = "800"; // 文本域宽度
	config.height = "300";// 文本域高度
	config.toolbarGroups = [
	                		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
	                		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
	                		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
	                		{ name: 'forms', groups: [ 'forms' ] },
	                		'/',
	                		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
	                		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
	                		{ name: 'links', groups: [ 'links' ] },
	                		{ name: 'insert', groups: [ 'insert' ] },
	                		'/',
	                		{ name: 'styles', groups: [ 'styles' ] },
	                		{ name: 'colors', groups: [ 'colors' ] },
	                		{ name: 'tools', groups: [ 'tools' ] },
	                		{ name: 'others', groups: [ 'others' ] },
	                		{ name: 'about', groups: [ 'about' ] }
	                	];

	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.font_names='宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'+ config.font_names;
	config.removeButtons = 'Cut,Copy,Source,Save,Print,Anchor,Language,CreateDiv,Flash,Smiley,Iframe,ShowBlocks,ImageButton,Preview';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;image:Link';
};
