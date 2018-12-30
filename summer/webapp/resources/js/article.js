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
					title: 'Num'
					, name: 'idx'
				},
				{
					title: 'Title'
					, name: 'title'
				},
				{
					title: 'Name'
					, name: 'userName'
				},
				{
					title: 'Date'
					, name: 'created'
					, formatter: (d) => {
						var date = new Date(d)
						, year = date.getFullYear()
						, month = date.getMonth() + 1
						, month = (month < 10) ? "0" + month : month
						, day = date.getDate()
						, day = (day < 10) ? "0" + day : day
						, createDate = year + "-" + month + "-" + day;
						
						return createDate;
					} 
				}
			]
		}).use('Net', {
		    perPage: 10,
		    readDataMethod: 'GET',
		    api: {
		        readData: '/summer/articles'
		        , createData: '/summer/article'
		    }
		}).on('response', (data) => {
            var pagination = grid.getPagination();

            grid.setData(data.responseData);
            
            pagination.setTotalItems(data.responseData.data.pagination);
            pagination._currentPage = data.responseData.data.page;
        });
	} 
	
	bindEvent();
});