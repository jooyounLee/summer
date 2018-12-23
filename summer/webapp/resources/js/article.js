
$(() => {
	console.log(1);
	
	var gridData = {
			Name: 'name',
			A: 'a'
	}
	
	var grid = new tui.Grid({
		el: $('#grid'),
		data: gridData,
		scrollX: false,
		scrollY: false,
		columns: [
			{
				title: 'Name',
				name: 'name'
			},
			{
				title: 'A',
				name: 'a'
			}
		]
	});
	
	
	
	
	
	
});