var layoutFrame = function(){
    var layout, center;
    var tree,rootNode;
    var Tree = Ext.tree;
        
    return {
        init : function(docTitle){
            // initialize state manager, we will use cookies
            Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
            
            // create the main layout
            layout = new Ext.BorderLayout(document.body, {
                west: {
                    split:true,
                    initialSize: 180,
                    minSize: 175,
                    maxSize: 400,
                    titlebar: true,
                    collapsible: true,
                    animate: true,
                    useShim:true,
                    cmargins: {top:2,bottom:2,right:2,left:2}
                },
                center: {
                    titlebar: false,
                    autoScroll:false,
                    tabPosition: 'top',
                    closeOnTab: true,
                    //alwaysShowTabs: true,
                    resizeTabs: true
                }
            });
            // tell the layout not to perform layouts until we're done adding everything
            layout.beginUpdate();
            
            layout.add('west', new Ext.ContentPanel('left', {title: docTitle,autoScroll:true, fitToFrame:true}));
            center = layout.getRegion('center');
            center.add(new Ext.ContentPanel('list', {fitToFrame:true}));
            
            layout.restoreState();
            layout.endUpdate();
    
						if(Ext.isSafari || Ext.isOpera){
							layout.layout();
						}
        },
        
        loadDoc : function(url){
            Ext.get('list').dom.src = url;
        }
    };
}();