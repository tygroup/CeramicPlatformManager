function page(pagenum){
	var totalPages = document.getElementById("totalPages").value;
	if(Number(pagenum) >= Number(totalPages)){
		pagenum=totalPages;
	}
	 document.getElementById("pages").value=pagenum;
	 document.getElementById("pages").form.submit();
	
}