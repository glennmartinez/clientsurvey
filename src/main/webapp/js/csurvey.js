/*$.fn.dataTableExt.afnFiltering.push(function(oSettings, aData, iDataIndex) {
	var minDateString = document.getElementById('min').value;
	var maxDateString = document.getElementById('max').value;
	var columnDateString = aData[2];
	var minDate = $.datepicker.parseDate('dd/mm/yy', minDateString);
	var maxDate = $.datepicker.parseDate('dd/mm/yy', maxDateString);
	var columnDate = $.datepicker.parseDate('dd/mm/yy', columnDateString);

	if (minDateString === '' && maxDateString === '') {
		return true;
	}
	if (minDateString === '' && columnDate <= maxDate) {
		return true;
	}
	if (minDate <= columnDate && maxDateString === '') {
		return true;
	}
	if (minDate <= columnDate && columnDate <= maxDate) {
		return true;
	}

	return false;
});
*/
/**
 * 
 */
var csurvey = window.csurvey || {};

csurvey.ClientList = function() {

	var oTable = $('#table1').dataTable({
		"bProcessing": true,
		"bServerSide": true,
		"sAjaxSource": "/clientsurvey/marketingSurvey/json.html",
		"sPaginationType": "full_numbers",
		"sDom": 'T<"clear">lfrtip',
		"oTableTools": {
			"sSwfPath": "/clientsurvey/images/copy_cvs_xls_pdf.swf"
		}
		
		
		
		
	});
	$('#myfield2').keyup( function (){
		
		oTable.fnFilter(this.value,2);
		
	});

	/* Add event listeners to the two range filtering inputs 
	$('#min').keyup(function() {
		oTable.fnDraw();
	});
	$('#max').keyup(function() {
		oTable.fnDraw();
	});*/

};

	      csurvey.RegionList = function() {
	var oTable = $('#table2').dataTable({
			"bProcessing": true,
			"sAjaxSource": "/clientsurvey/marketingSurvey/planner2.html",
			"sPaginationType": "full_numbers"
		});
		
	$('#rundate').keyup( function (){
		
		oTable.fnFilter(this.value,6);
		
	});
	
	$('#submit').click(function() {
		sentDateToServer();
	});
	
	
	
	
	function sentDateToServer(){
		var passDate = $('#rundate').val();
		$.ajax({
			type: 'GET',
			url: '/clientsurvey/marketingSurvey/planner2.html?runDate=' + passDate,
		
		});
				
	}	
	function show_alert(){
	var rundate = $('#rundate');	
	var msg = "welcome to client survey";
	alert(msg + rundate);
		
	}
}

