var layoutTreeFrame = function(){
    var layout, center;
    var tree,rootNode;
    var Tree = Ext.tree;
        
    return {
        init : function(docTitle, treeDiv,treeTitle,dataUrl,nodeUrl,leafUrl,pageUrl){
            // initialize state manager, we will use cookies
            Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
            
            // create the main layout
            layout = new Ext.BorderLayout(document.body, {
                west: {
                    split:true,
                    initialSize: 250,
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
            center.add(new Ext.ContentPanel('main', {fitToFrame:true}));
            
            layout.restoreState();
            layout.endUpdate();
    
    				var treeLoader;
    				if (dataUrl!=null){
    					treeLoader=new Tree.TreeLoader({dataUrl:dataUrl});
    				}else{
    					treeLoader=new Tree.TreeLoader();
    				}
    				
				    tree = new Tree.TreePanel(treeDiv, {
				        animate:false,
				        enableDD:false,
								rootVisible:true,
								loader: treeLoader, // ({dataUrl:'dependency.php'}),Note: no dataurl, register a TreeLoader to make use of createNode()
								lines: true,
				        containerScroll: false
				    });
		    

				    // set the root node
		    		if (dataUrl!=null){
		    			rootNode = new Tree.AsyncTreeNode({
					        text: treeTitle,
					        id:'-1',
					        title:'-1',
					        draggable:false
					    });
		    		}else{
			        // json data describing the tree
					    var json = [{"text":"root","cls":"folder","leaf":false,"id":"001","children":[{"text":"first","cls":"file","leaf":true,"id":"001001"},{"text":"second","cls":"file","leaf":true,"id":"001002"},{"text":"third","cls":"folder","leaf":false,"id":"001003","children":[{"text":"four","cls":"file","leaf":true,"id":"001003001"},{"text":"five","cls":"file","leaf":true,"id":"001003002"}]}]}];
					
		    			rootNode = new Tree.AsyncTreeNode({
					        text: treeTitle,
					        id:'-1',
					        title:'-1',
					        draggable:false,
					        children: json
					    });
		    		}
				
				    tree.setRootNode(rootNode);
		        tree.on('click', function(n){
		           if(n.isLeaf()){		           	
		           		layoutTreeFrame.loadDoc(leafUrl+'&id='+n.id+'&code='+n.attributes.title);
		           }else{
		           		layoutTreeFrame.loadDoc(nodeUrl+'&code='+n.attributes.title);
		          }
		        });
						tree.render();
						
						rootNode.expand(false,true);
						
		        if (pageUrl!=null)
		        	layoutTreeFrame.loadDoc(pageUrl);
		            
						if(Ext.isSafari || Ext.isOpera){
							layout.layout();
						}
        },
        
        loadDoc : function(url){
            Ext.get('main').dom.src = url;
        }
    };
}();