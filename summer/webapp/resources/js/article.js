$(() => {
	var total
	
	, bindEvent = () => {
		drawGrid();
	}
	
	, drawGrid = () => {
		var grid = new tui.Grid({
			el: $('#grid'),
			pagination: true,
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
		}).use('Net', {
		    perPage: 3,
		    readDataMethod: 'GET',
		    api: {
		        readData: '/summer/articles'
		    }
		}).on('response', function(data) {
            var pagination = grid.getPagination();
            
            grid.setData(data.responseData);
            
            pagination.setTotalItems(data.responseData.data.pagination);
            pagination._currentPage = data.responseData.data.page;
        });
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