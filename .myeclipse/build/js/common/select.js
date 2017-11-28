function changeOne(e,oldcss){
	if (e.checked){
		e.parentElement.parentElement.className="trLineSelected";
	}
	else{
		e.parentElement.parentElement.className=oldcss;
	}
}

function changeAll(frm,bOnload){
	var k = 0;
	for (var i=0;i<frm.elements.length;i++){
		var e = frm.elements[i];
		if ((e.name != 'allbox') && (e.type=='checkbox')){
			k++;
			j = (k+1)%2+1;
			if (bOnload){
				e.checked=false;
				e.parentElement.parentElement.className="trLine" +j;
			}
			else if (!bOnload){
				if (frm.allbox.checked){
					e.checked=true;
					e.parentElement.parentElement.className="trLineSelected";
				}
				else{
					e.checked=false;
					e.parentElement.parentElement.className="trLine" +j;
				}
			}
		}
	}
	if (bOnload) frm.allbox.checked=false;
}


function isChecked(frm){
	for (var i=0;i<frm.elements.length;i++){
		var e = frm.elements[i];
		if ((e.name != 'allbox') && (e.type=='checkbox')){
 			if (e.checked) return true;
 		}
 	}
 	alert("请至少选择一条记录！");
 	return false;
}

function chkForDelete(frm){
	if (isChecked(frm)) {
		if (confirm("确认删除所有选中的记录吗?")) frm.submit();
	}
}
function chkForXiaJia(frm){
	if (isChecked(frm)) {
		if (confirm("确认下架所有选中的记录吗?")) frm.submit();
	}
}
function chkForResetPass(frm){
	if (isChecked(frm)) {
		if (confirm("确认重置所有选中记录的密码吗?")) frm.submit();
	}
}
function getAllChecked(frm,obj_name){
	var data = "";
	var k = 0;
	var f = "";
	for (var i=0;i<frm.elements.length;i++){
		var e = frm.elements[i];
		if ((e.name == obj_name) && (e.type=='checkbox')){
			
			if(e.checked) 
				if(f == "")
			    {
				   data += e.value; 
				   f = "ok";
				}else data += "," + e.value;
		}
	}
	return data;
}
