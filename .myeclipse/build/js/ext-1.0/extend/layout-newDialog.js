var layoutDialog = function(){
    // everything in this space is private and only accessible in the HelloWorld block
    
    // define some private variables
    var dialog;
    var template;
    var panel;
    // return a public interface
    return {        
        show : function(width,height,title,linkUrl,scroll){
       		
            if(!dialog){ // lazy initialize the dialog and only create it once
            	  template = new Ext.Template('<iframe frameborder="no" style="border:0px none;" scrolling="{scroll}" src="{frameaddress}" width="100%", height="100%"></iframe>');

            		var div = Ext.DomHelper.append(Ext.get(document.body).dom, {tag:'div', style:'visibility:hidden;'}, true);
            		
                dialog = new Ext.LayoutDialog(div.id, {
                				title:title,
                        modal:true,
                        width:width,
                        height:height,
                        shadow:true,
                        minWidth:300,
                        minHeight:300,
                        proxyDrag: true,
	                    	center: {
	                        autoScroll:true
	                    }
                });
                dialog.addKeyListener(27, dialog.hide, dialog);
                var layout = dialog.getLayout();
                layout.beginUpdate();
	            	panel = layout.add('center', new Ext.ContentPanel(Ext.id(), {autoCreate:true}));

	            	layout.endUpdate();
            }else{
            	dialog.resizeTo(width,height);
            	dialog.setTitle(title);
            	dialog.center();
            }
	          var panelEl = panel.getEl(); 

						var frameObj = template.overwrite(panelEl.dom, {frameaddress:linkUrl,scroll:scroll},true); 
            dialog.show();
        },
        
        hide : function(){
            dialog.hide();
        }
    };
}();