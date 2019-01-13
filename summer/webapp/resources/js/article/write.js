$(() => {
	var total
	
	, el = {
		btnSave : document.querySelector("input[name='btnSave']"),
		title : document.querySelector("input[name='title']"),
		user_name : document.querySelector("input[name='userName']"),
		password : document.querySelector("input[name='password']"),
	}
	
	, buttonEvent = () => {
		el.btnSave.onclick = save;
	}

	, editor = new tui.Editor({
		    el: document.querySelector('#editSection'),
		    initialEditType: 'wysiwyg',
		    previewStyle: 'vertical',
		    height: '500px'
		})
	
	, save = () => {
		$.ajax({
			type: 'POST',
			data: {
				content: editor.getHtml()
				, title: el.title.value
				, userName: el.user_name.value
				, password: el.password.value
			},
			url: "/summer/article",
			success: (saveResult) => {
				if(saveResult > 0) {
					alert("save success.");
					location.href = "/summer";
				}
			}
			
		});
	}
	
	buttonEvent();
});