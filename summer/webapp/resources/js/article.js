$(() => {
	var total
	
	, bindEvent = () => {
		drawGrid();
	}
	
	, drawGrid = () => {
		grid = new tui.Grid({
			el: $('#grid'),
			//pagination: true,
			columns: [
				{
					title: 'Num',
					name: 'idx'
				},
				{
					title: 'Name',
					name: 'userName'
				},
				{
					title: 'Title', 
					name: 'title'
				},
				{
					title: 'Date',
					name: 'created'
				}
			]
		});
		
		findArticles();
	} 
	
	, findArticles = () => {
		$.ajax({
	        type : 'GET',
	        url : '/summer/articles',
	        success : (result) => {
	        	grid.setData(result);
	        }
	    });
	}
	
	
	bindEvent();
});