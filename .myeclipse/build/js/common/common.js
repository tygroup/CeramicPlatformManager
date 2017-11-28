/*剔除空格*/
String.prototype.trim = function() {
    return this.replace(/^\s*|\s*$/g, "");
}

//判断浏览器类型
function getOs(){   
   		var OsObject = "";   
   		if(navigator.userAgent.indexOf("MSIE")>0) {   
        	return "MSIE";       //IE浏览器
   		}
	   	if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){   
	        return "Firefox";     //Firefox浏览器
	   	}
	   	if(isSafari=navigator.userAgent.indexOf("Safari")>0) {   
	        return "Safari";      //Safan浏览器
	   	}
	   	if(isCamino=navigator.userAgent.indexOf("Camino")>0){   
	        return "Camino";   //Camino浏览器
	   	}
	   	if(isMozilla=navigator.userAgent.indexOf("Gecko/")>0){   
	        return "Gecko";    //Gecko浏览器
	   	}   
	} 

function setActiveStyleSheet(title) {
	var i, a;
	for(i=0; (a = document.getElementsByTagName("link")[i]); i++) {
		if(a.getAttribute("rel").indexOf("style") != -1 && a.getAttribute("title")) {
			a.disabled = true;
			if(a.getAttribute("title") == title) a.disabled = false;
		}
	}
}

function getActiveStyleSheet() {
  var i, a;
  for(i=0; (a = document.getElementsByTagName("link")[i]); i++) {
    if(a.getAttribute("rel").indexOf("style") != -1 && a.getAttribute("title") && !a.disabled) return a.getAttribute("title");
  }
  return null;
}

function setCSS(title) {
	setCookie("cssfontstyle", title);
	loadCSS();
}

function loadCSS() {
	var i, a, title;
	title = getCookie("cssfontstyle") == "" ? "small" : getCookie("cssfontstyle");
	
	try {
		for(i=0; (a = top.mainFrame.document.getElementsByTagName("link")[i]); i++) {
			if(a.getAttribute("rel").indexOf("style") != -1 && a.getAttribute("title")) {
				a.disabled = true;
				if(a.getAttribute("title") == title) a.disabled = false;
			}
		}
		
		for(i=0; (a = top.menuFrame.document.getElementsByTagName("link")[i]); i++) {
			if(a.getAttribute("rel").indexOf("style") != -1 && a.getAttribute("title")) {
				a.disabled = true;
				if(a.getAttribute("title") == title) a.disabled = false;
			}
		}
	} catch (e) {
		//
	}
}

////////////////////cookie读写///////////////////////////////////////////////////////
function getCookieVal (offset) {
	var endstr = document.cookie.indexOf (";", offset);
	if (endstr == -1)
		endstr = document.cookie.length;
	return unescape(document.cookie.substring(offset, endstr));
}

function getCookie (name) {
	var arg = name + "=";
	var alen = arg.length;
	var clen = document.cookie.length;
	var i = 0;
	while (i < clen) {
		var j = i + alen;
		if (document.cookie.substring(i, j) == arg)
			return getCookieVal (j);
		i = document.cookie.indexOf(" ", i) + 1;
		if (i == 0)
			break;
	}
	return "";
}

function setCookie (name, value) {  
	var exp = new Date();  
	exp.setTime(exp.getTime() + (30*24*60*60*1000));
	document.cookie = name + "=" + escape (value) + "; expires=" + exp.toGMTString()+"; path=/";
}

//sec秒后失效
function setCookieWithExpire (name, value, sec) {  
	var exp = new Date();  
	exp.setTime(exp.getTime() + (sec*1000));
	document.cookie = name + "=" + escape (value) + "; expires=" + exp.toGMTString()+"; path=/";
}

function deleteCookie (name) {  
	var exp = new Date();  
	exp.setTime (exp.getTime() - 1);  
	var cval = getCookie (name);  
	document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString()+";";
}
///////////////////////////////////////////////////////////////////////////////////

//日历显示
//需要先引用   jscalendar-1.0/calendar.js
//以及         jscalendar-1.0/lang/calendar-zh.js
//调用必须声明元素Id
// This function gets called when the end-user clicks on some date.
function selected(cal, date) {
  cal.sel.value = date; // just update the date in the input field.
  if (cal.dateClicked)
    // if we add this call we close the calendar on single-click.
    // just to exemplify both cases, we are using this only for the 1st
    // and the 3rd field, while 2nd and 4th will still require double-click.
    cal.callCloseHandler();
}

// And this gets called when the end-user clicks on the _selected_ date,
// or clicks on the "Close" button.  It just hides the calendar without
// destroying it.
function closeHandler(cal) {
  cal.hide();                        // hide the calendar
//  cal.destroy();
  _dynarch_popupCalendar = null;
}

// This function shows the calendar under the element having the given id.
// It takes care of catching "mousedown" signals on document and hiding the
// calendar if the click was outside.
function showCalendar(el, format, showsTime, showsOtherMonths) {

  if (_dynarch_popupCalendar != null) {
    // we already have some calendar created
    _dynarch_popupCalendar.hide();                 // so we hide it first.
  } else {
    // first-time call, create the calendar.
    var cal = new Calendar(1, null, selected, closeHandler);
    // uncomment the following line to hide the week numbers
    // cal.weekNumbers = false;
    if (typeof showsTime == "string") {
      cal.showsTime = true;
      cal.time24 = (showsTime == "24");
    }
    if (showsOtherMonths) {
      cal.showsOtherMonths = true;
    }
    _dynarch_popupCalendar = cal;                  // remember it in the global var
    cal.setRange(1900, 2070);        // min/max year allowed.
    cal.create();
  }
  _dynarch_popupCalendar.setDateFormat(format);    // set the specified date format
  _dynarch_popupCalendar.parseDate(el.value);      // try to parse the text in field
  _dynarch_popupCalendar.sel = el;                 // inform it what input field we use

  // the reference element that we pass to showAtElement is the button that
  // triggers the calendar.  In this example we align the calendar bottom-right
  // to the button.
  _dynarch_popupCalendar.showAtElement(el, "Br");        // show the calendar

  return false;
}



//显示模式对话框   accessObj用来传递对象以便对话框交互
   function modalDialog(URL,dialogWidth,dialogHeight,accessObj)
   {
     showModalDialog(URL,accessObj,"dialogWidth:"+dialogWidth+"px;dialogHeight:"+dialogHeight+"px");
   }
   
/*  
**    ==================================================================================================  
**    类名：CLASS_LIANDONG_YAO  
**    功能：多级连动菜单  
**    
**    作者：YAODAYIZI  

**    ==================================================================================================  
**/  	
  function classChange(array)
  {
   //数组，联动的数据源
  	this.array=array; 
  	this.indexName='';
  	this.obj='';
  	//设置子SELECT
	// 参数：当前onchange的SELECT ID，要设置的SELECT ID
      this.subSelectChange=function(selectName1,selectName2)
  	{
  	//try
  	//{
    var obj1=document.all[selectName1];
    var obj2=document.all[selectName2];
    var objName=this.toString();
    var me=this;
  
    obj1.onchange=function()
    {
    	
    	me.optionChange(this.options[this.selectedIndex].value,obj2.id)
    }

  	}
  	//设置第一个SELECT
	// 参数：indexName指选中项,selectName指select的ID
  	this.firstSelectChange=function(indexName,selectName)  
  	{
  	this.obj=document.all[selectName];
  	this.indexName=indexName;
  	this.optionChange(this.indexName,this.obj.id)

  	}
  
  // indexName指选中项,selectName指select的ID
  	this.optionChange=function (indexName,selectName)
  	{
    var obj1=document.all[selectName];
    var me=this;
    obj1.length=0;
    obj1.options[0]=new Option("全部",'');
    for(var i=0;i<this.array.length;i++)
    {	
    
    	if(this.array[i][1]==indexName)
    	{
    	//alert(this.array[i][1]+" "+indexName);
      obj1.options[obj1.length]=new Option(this.array[i][2],this.array[i][0]);
    	}
    }
  	}
  	
  }
  function classChange3(array)
  {
   //数组，联动的数据源
  	this.array=array; 
  	this.indexName='';
  	this.obj='';
  	//设置子SELECT
	// 参数：当前onchange的SELECT ID，要设置的SELECT ID
      this.subSelectChange=function(selectName1,selectName2)
  	{
  	//try
  	//{
    var obj1=document.all[selectName1];
    var obj2=document.all[selectName2];
    var objName=this.toString();
    var me=this;
  
    obj1.onchange=function()
    {
    	
    	me.optionChange(this.options[this.selectedIndex].value,obj2.id)
    }

  	}
  	//设置第一个SELECT
	// 参数：indexName指选中项,selectName指select的ID
  	this.firstSelectChange=function(indexName,selectName)  
  	{
  	this.obj=document.all[selectName];
  	this.indexName=indexName;
  	this.optionChange(this.indexName,this.obj.id)

  	}
  
  // indexName指选中项,selectName指select的ID
  	this.optionChange=function (indexName,selectName)
  	{
    var obj1=document.all[selectName];
    var me=this;
    obj1.length=0;
    obj1.options[0]=new Option("请选择",'');
    for(var i=0;i<this.array.length;i++)
    {	
    
    	if(this.array[i][1]==indexName)
    	{
    	//alert(this.array[i][1]+" "+indexName);
      obj1.options[obj1.length]=new Option(this.array[i][2],this.array[i][0]);
    	}
    }
  	}
  	
  }
/*  
**    ==================================================================================================  
**    类名：CLASS_LIANDONG_YAO  
**    功能：多级连动菜单  
**    
**    作者：YAODAYIZI  

**    ==================================================================================================  
**/  	
  function schemaChange(schemaArray)
  {
  	this.schemaArray=schemaArray; 
  	this.indexName='';
  	this.obj='';
  	
    this.subSchemaChange=function(selectName1,selectName2)
  	{
	  	//try
	  	//{
	    var obj1=document.all[selectName1];
	    var obj2=document.all[selectName2];
	    var objName=this.toString();
	    var me=this;
	  
	    obj1.onchange=function()
	    {
	    	me.schemaOptionChange(this.options[this.selectedIndex].value,obj2.id)
	    }
  	}
  	
  	this.firstSchemaChange=function(indexName,selectName)  
  	{
	  	this.obj=document.all[selectName];
	  	this.indexName=indexName;
	    //alert(this.indexName+"\n"+this.obj.id);
	  	this.schemaOptionChange(this.indexName,this.obj.id)
  	}
  
  	this.schemaOptionChange=function (indexName,selectName)
  	{
	    var obj1=document.all[selectName];
	    var me=this;
	    obj1.length=0;
	    obj1.options[0]=new Option("全部",'');
	    for(var i=0;i<this.schemaArray.length;i++)
	    {	
	    	if(this.schemaArray[i][1]==indexName)
	    	{
		      obj1.options[obj1.length]=new Option(this.schemaArray[i][2],this.schemaArray[i][0]);
	    	}
	    }
	    obj1.options.remove(0);
  	}	
}

	//去掉全部 	
  function classChange2(array)
  {
   //数组，联动的数据源
  	this.array=array; 
  	this.indexName='';
  	this.obj='';
  	//设置子SELECT
	// 参数：当前onchange的SELECT ID，要设置的SELECT ID
      this.subSelectChange=function(selectName1,selectName2)
  	{
  	//try
  	//{
    var obj1=document.all[selectName1];
    var obj2=document.all[selectName2];
    var objName=this.toString();
    var me=this;
  
    obj1.onchange=function()
    {
    	
    	me.optionChange(this.options[this.selectedIndex].value,obj2.id)
    }

  	}
  	//设置第一个SELECT
	// 参数：indexName指选中项,selectName指select的ID
  	this.firstSelectChange=function(indexName,selectName)  
  	{
  	this.obj=document.all[selectName];
  	this.indexName=indexName;
  	this.optionChange(this.indexName,this.obj.id)

  	}
  
  // indexName指选中项,selectName指select的ID
  	this.optionChange=function (indexName,selectName)
  	{
    var obj1=document.all[selectName];
    var me=this;
    obj1.length=0;
    //obj1.options[0]=new Option("全部",'');
    for(var i=0;i<this.array.length;i++)
    {	
    
    	if(this.array[i][1]==indexName)
    	{
    	//alert(this.array[i][1]+" "+indexName);
      obj1.options[obj1.length]=new Option(this.array[i][2],this.array[i][0]);
    	}
    }
  	}
  	
  }
  
  function setChecked(obj,objvalue){
   	for (var i=0;i<obj.length;i++){
         if (obj[i].value==objvalue){
            obj[i].checked=(!obj[i].checked);
            break;
         }
      }
}
/*
*============================================
*isPostCode():判断是否为邮政编码(中国6位数字)
*============================================
*/
function isPostCode(str){
	var reg = /^\d{6}$/;
	return reg.test(str);
}
/*
*============================================
*isPostCode():判断是否为英文或数字
*============================================
*/
function isEnOrNum(str){
	var reg =/^(?=.*[a-zA-Z]+)(?=.*[0-9]+)[a-zA-Z0-9]+$/ 
	return reg.test(str);
}


/*
*============================================
*isEmail():判断是否为电子邮件地址
*============================================
*/
function isEmail(str){
	var reg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
	return reg.test(str);
}
/*
*============================================
*isEnChar():判断是否为纯英文
*============================================
*/
function isEnChar(str){
	var reg = /^[A-Za-z]+$/;
	return reg.test(str);
}
/*
*============================================
*isMInteger():判断是否为正整数
*============================================
*/
function isMInteger(str){
	var reg = /^[0-9]*[1-9][0-9]*$/;
	return reg.test(str);
}

function isPlus(str){
	var reg = /^(0|([1-9]\d*))(\.\d+)?$/;///^[0-9]*[1-9][0-9]*$/;
	return reg.test(str);
}

/*
*============================================
*isPhoneNo():判断是否为电话号码，区号+电话
*============================================
*/
function isPhoneNo(str){
	var reg = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
	return reg.test(str);
}
/*
*============================================
*isMobileNo():判断是否为手机号,11位号码
*============================================
*/
function isMobileNo(str){
	var reg =/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
	return reg.test(str);
}
/*
*============================================
*isCnChar():判断是否为中文字
*============================================
*/
function isCnChar(str){
	var reg = /^([\u4E00-\u9FA5]|[\uFE30-\uFFA0]|[\s])*$/gi;
	return reg.test(str);
}
function isDigitOrDoubleFor2(str){
	var reg = /^[+]?\d{0,8}\.{0,1}(\d{1,2})?$/;
	return reg.test(str);
}
function getL(str){
	var j=0;
	for   (var i=0;i<str.length;i++)  {  
		if(str.charCodeAt(i)>255)j=j+2;  
        else j++
	}
	return j;
}

function check_num(val_num)//判断是否为float型数据
{
  var checkOK = "0123456789.";
  var checkStr = val_num;
  var allValid = true;
  var decPoints = 0;
  var allNum = "";
  var n=0;
  for (i = 0;  i < checkStr.length;  i++)
  {
    ch = checkStr.charAt(i);
    if(ch==checkOK.charAt(10))
    {
       n++;//判断该字符串中有几个点
    }
    for (j = 0;  j < checkOK.length;  j++)
   if (ch == checkOK.charAt(j))
        break;

    if (j == checkOK.length)
    {
      allValid = false;
      break;
    }
 if(n>1)//如果字符串中点的个数>1的,错误
 {
  allValid=false;
  break;
 }
  }
  if (!allValid)
  {
    return (false);
  }
  return (true);
}
	