/*
$(function() {
	$('#carrega-itens').click(function() {
		$('#itens').removeClass('hidden');
		$('#carrega-itens').addClass('hidden');
	});
});
*/

$(function(){
	$('#servico').change(function(){
		if( $(this).val() ) {
			//$('#material').hide();
			$.getJSON('/produtos/rest/' + $(this).val(), function(j){
				var options = '<option value=""></option>'; 
				for (var i = 0; i < j.length; i++) {
					options += '<option value="' + j[i].id + '">' + j[i].materialDescricao + '</option>';
				}	
				$('#material').html(options).show();
			});
		} 
		else {
			$('#material').html('<option value="">-- Escolha um material --</option>');
		}
	});
});
