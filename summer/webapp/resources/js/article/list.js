$(() => {
	var total
	, el = {
			go_write : document.querySelector('button[name=goWrite]')
	}

	, clickEvent = () => {
		el.go_write.onclick = () => {
			location.href="/summer/article";
		}
	}
	
	, drawGrid = () => {
		var grid = new tui.Grid({
			el: document.getElementById('grid'),
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
	        
	    }).on('click', (e) => {
	    	$.ajax({
				type: 'GET',
				url: "/summer/article/" + grid.getRow(e).idx,
				success: (result) => {
					if(result != null) {
						document.getElementById('view').style.display = 'block';
						document.querySelector('div [name=title]').innerHTML = result.title;
						document.querySelector('div [name=userName]').innerHTML = result.userName;
						document.querySelector('div [name=created]').innerHTML = result.created;
						document.querySelector('div [name=content]').innerHTML = result.content;
					}
				}
				
			});
	    });
	}
	
	// VIEW : WHEN CLICK OTHER PART CLOSE THE MODAL
	// WHEN CLICK CLOSE BUTTON CLOSE THE MODAL
	// UPDATE
	// DELETE
	//-----------------------------
	
	// SPRING SECURITY
	
	drawGrid();
	clickEvent();
});