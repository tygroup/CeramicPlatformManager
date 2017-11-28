function SetTableColor() {
  var tbl = document.getElementById("imagetable");
  var trs = tbl.getElementsByTagName("tr");
  for (var i = 0; i < trs.length; i++) {
 var j = i + 1;
 if (j % 2 == 0) { //偶数行
   //trs[i].style.backgroundImage = "url("+"../../../images/common/green.png"+")";

 }
 else {
   trs[i].style.background = "#f5fafe";
 }
  }
}

 function IniEvent() {
            var tbl = document.getElementById("imagetable");
            var trs = tbl.getElementsByTagName("tr");
            for (var i = 0; i < trs.length; i++) {
                trs[i].onclick = TrOnClick;
            }
        }
        function TrOnClick() {
            var tbl = document.getElementById("imagetable");
            var trs = tbl.getElementsByTagName("tr");
            for (var i = 0; i < trs.length; i++) {
                if (trs[i] == this) {             //判断是不是当前选择的行
                    trs[i].style.background = "#E8F2FE";
                }
                else {
                    trs[i].style.background = "white";
                }
            }
        }